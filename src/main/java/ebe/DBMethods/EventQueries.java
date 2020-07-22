package ebe.DBMethods;

import ebe.DBClasses.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EventQueries extends DBQueries {

    @Autowired
    public EventQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Events
    public List<Event> getAllEvents() throws DataAccessException {
        return jdbcTemplate().query("SELECT * FROM Event", new Object[]{},
                (rs, i) -> new Event(rs.getInt("EventID"), rs.getString("Name"),
                        rs.getInt("TypeOfEvent"), rs.getDate("Date"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getInt("AttendingSchools"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallengesGenderStereotypes"))
        );
    }

    // 2. Get Event by Id
    public Event getEventDetailsById(int eventId) throws DataAccessException {
        String getSql = String.format("SELECT * FROM Event WHERE EventID = \"%s\" LIMIT 1", eventId);
        List<Event> eventInfo = jdbcTemplate().query(getSql, new Object[]{},
                (rs, i) -> new Event(rs.getInt("EventID"), rs.getString("Name"),
                        rs.getInt("TypeOfEvent"), rs.getDate("Date"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getInt("AttendingSchools"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallengesGenderStereotypes"))
        );
        return eventInfo.get(0);
    }


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 1. Create a new Event
    public int createNewEvent(String Name, int TypeOfEvent, String Date, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                              String NumberOfAttendees, int AttendingSchools, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                              Boolean ChallengesGenderStereoTypes) throws DataAccessException {

        String insertSql = "INSERT TO Event Event(Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser," +
                "                                 NumberOfAttendees, AttendingSchools, PromotesApprenticeships, PromotesWelshLanguage," +
                "                                 ChallengesGenderStereoTypes)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, AttendingSchools, PromotesApprenticeships, PromotesWelshLanguage,
                ChallengesGenderStereoTypes);

    }
    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 1. Update an Events by Id

    public Integer updateEvent(int EventID, String Name, int TypeOfEvent, String Date, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                               String NumberOfAttendees, int AttendingSchools, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                               Boolean ChallengesGenderStereoTypes) throws DataAccessException {

        String updateSql = "UPDATE Event SET Name =?, TypeOfEvent =?, Date= ?, isPublic=?, isCancelled=?," +
                "PostCode=?, NameOfAdviser=?, NumberOfAttendees=?, AttendingSchools=?,  PromotesApprenticeships=?, PromotesWelshLanguage=?" +
                "ChallengesGenderStereoTypes=? WHERE EventlID =?";

        return jdbcTemplate().update(updateSql, Name, TypeOfEvent, Date, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, AttendingSchools, PromotesApprenticeships, PromotesWelshLanguage,
                ChallengesGenderStereoTypes, EventID);
    }

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 1. Delete an Event by ID

    public Integer deleteEvent(int eventId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Event WHERE EventID = '%s'",eventId);
        return jdbcTemplate().update(deleteSql);
    }
}
