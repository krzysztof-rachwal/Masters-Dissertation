package ebe.DBMethods;

import ebe.DBClasses.Event;
import ebe.DBClasses.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EventQueries extends DBQueries {

    private Connection connection;
    private Statement statement;

    @Autowired
    public EventQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Events
    public List<Event> getAllEvents() throws DataAccessException {
        String getQuery = "SELECT * FROM Event";
        List<Event> list = new ArrayList<Event>();
        Event event = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                event = new Event(rs.getInt("EventID"), rs.getString("EventName"),
                        rs.getInt("TypeOfEventID"), rs.getDate("EventDateAndTime"),
                        rs.getString("EventVenueName"),rs.getString("EventAddressCity"),
                        rs.getString("EventAddressStreet"),rs.getString("EventAddressNumber"),
                        rs.getString("EventVenuePostcode"),rs.getString("EventSummary"),
                        rs.getBoolean("isPublic"), rs.getBoolean("isCancelled"),
                        rs.getString("NameOfAdviser"), rs.getInt("NumberOfAttendees"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallengesGenderStereotypes"));

                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }

    // 2. Get Event by Id
    public Event getEventDetailsById(int eventId) throws DataAccessException {
    String getQuery = String.format("SELECT * FROM Event WHERE EventID = \"%s\" LIMIT 1", eventId);
        Event event = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                event = new Event(rs.getInt("EventID"), rs.getString("EventName"),
                        rs.getInt("TypeOfEventID"), rs.getDate("EventDateAndTime"),
                        rs.getString("EventVenueName"),rs.getString("EventAddressCity"),
                        rs.getString("EventAddressStreet"),rs.getString("EventAddressNumber"),
                        rs.getString("EventVenuePostcode"),rs.getString("EventSummary"),
                        rs.getBoolean("isPublic"), rs.getBoolean("isCancelled"),
                        rs.getString("NameOfAdviser"), rs.getInt("NumberOfAttendees"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallengesGenderStereotypes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return event;
    }

    // 3. Get List of Event Types Names and Ids
    public List<Event> getAllTypesOfEvents() throws DataAccessException {
        String getQuery = "SELECT * FROM TypeOfEventList";
        List<Event> list = new ArrayList<Event>();
        Event event = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                event = new Event();
                event.setTypeOfEventID(rs.getInt("TypeOfEventID"));
                event.setTypeOfEventName(rs.getString("TypeOfEventName"));

                list.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }

    // 4. Get List of Event Types Names and Ids
    public Integer getLastEventCreated(String eventName) throws DataAccessException {
        String getQuery = String.format("SELECT EventID FROM Event WHERE EventName = \"%s\"  ORDER BY EventID DESC LIMIT 1", eventName);
        Event event = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                event = new Event();
                event.setEventID(rs.getInt("EventID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return event.getEventID();
    }



    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 5. Create a new Event
    public int createEvent( String EventName, int TypeOfEventID, String EventDateAndTime, String EventVenueName,
                           String EventAddressCity, String EventAddressStreet, String EventAddressNumber, String EventVenuePostcode,
                           String EventSummary, Boolean IsPublic, Boolean IsCancelled, String NameOfAdviser, int NumberOfAttendees,
                           Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage, Boolean ChallengesGenderStereoTypes) throws DataAccessException {

        String insertSql = "INSERT INTO Event(EventName, TypeOfEventID, EventDateAndTime, EventVenueName, EventAddressCity," +
                " EventAddressStreet, EventAddressNumber, EventVenuePostcode, EventSummary, IsPublic, IsCancelled, NameOfAdviser," +
                " NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage,ChallengesGenderStereoTypes)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, EventName, TypeOfEventID, EventDateAndTime, EventVenueName, EventAddressCity,
                EventAddressStreet, EventAddressNumber, EventVenuePostcode, EventSummary, IsPublic, IsCancelled, NameOfAdviser,
                NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage, ChallengesGenderStereoTypes);

    }

    // 6. Create new Employer / Event Intersection
    public void updateEmployerEventIntersection(int EventID, List<Integer> EmployerID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_AttendingEmployerOnEvent(EventID, EmployerID) VALUE(?,?)";

        for (Integer employerId : EmployerID ){
            jdbcTemplate().update(updateSql, EventID, employerId);
        };
    }

    // 7. Create new School / Event Intersection
    public void updateSchoolEventIntersection(int EventID, List<Integer> SchoolID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_AttendingSchoolOnEvent(EventID, SchoolID) VALUES(?,?)";

        for (Integer schoolId : SchoolID ){
            jdbcTemplate().update(updateSql, EventID, schoolId);
        };
    }

    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////

    // 8. Update an Events by Id
    public Integer updateEvent(int EventID, String Name, int TypeOfEvent, String Date, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                               String NumberOfAttendees, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                               Boolean ChallengesGenderStereoTypes) throws DataAccessException {

        String updateSql = "UPDATE Event SET Name =?, TypeOfEvent =?, Date= ?, isPublic=?, isCancelled=?," +
                "PostCode=?, NameOfAdviser=?, NumberOfAttendees=?, PromotesApprenticeships=?, PromotesWelshLanguage=?" +
                "ChallengesGenderStereoTypes=? WHERE EventlID =?";

        return jdbcTemplate().update(updateSql, Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage,
                ChallengesGenderStereoTypes, EventID);
    }


    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 9. Delete an Event by ID

    public Integer deleteEvent(int eventId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Event WHERE EventID = '%s'",eventId);
        return jdbcTemplate().update(deleteSql);
    }
}
