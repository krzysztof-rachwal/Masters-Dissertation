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
                event = new Event(rs.getInt("EventID"), rs.getString("Name"),
                        rs.getInt("TypeOfEvent"), rs.getDate("Date"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallangesGenderStereotypes"));

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

                event = new Event(rs.getInt("EventID"), rs.getString("Name"),
                        rs.getInt("TypeOfEvent"), rs.getDate("Date"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallangesGenderStereotypes"));
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


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 1. Create a new Event
    public int createEvent(String Name, int TypeOfEvent, String Date, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                              int NumberOfAttendees, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                              Boolean ChallangesGenderStereoTypes) throws DataAccessException {

        String insertSql = "INSERT TO Event Event(Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser," +
                "                                 NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage," +
                "                                 ChallangesGenderStereoTypes)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage,
                ChallangesGenderStereoTypes);

    }
    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 1. Update an Events by Id

    public Integer updateEvent(int EventID, String Name, int TypeOfEvent, String Date, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                               String NumberOfAttendees, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                               Boolean ChallangesGenderStereoTypes) throws DataAccessException {

        String updateSql = "UPDATE Event SET Name =?, TypeOfEvent =?, Date= ?, isPublic=?, isCancelled=?," +
                "PostCode=?, NameOfAdviser=?, NumberOfAttendees=?, PromotesApprenticeships=?, PromotesWelshLanguage=?" +
                "ChallangesGenderStereoTypes=? WHERE EventlID =?";

        return jdbcTemplate().update(updateSql, Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, PromotesApprenticeships, PromotesWelshLanguage,
                ChallangesGenderStereoTypes, EventID);
    }

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 1. Delete an Event by ID

    public Integer deleteEvent(int eventId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Event WHERE EventID = '%s'",eventId);
        return jdbcTemplate().update(deleteSql);
    }
}
