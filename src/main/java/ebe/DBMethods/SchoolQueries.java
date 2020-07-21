package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SchoolQueries extends DBQueries {

    @Autowired
    public SchoolQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Events
    public List<Event> getAllEvents() throws DataAccessException {
        return jdbcTemplate().query("SELECT * FROM Event", new Object[]{},
                (rs, i) -> new Event(rs.getInt("EventID"), rs.getString("Name"),
                        rs.getInt("TypeOfEvent"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getInt("AttendingSchools"),rs.getInt("AttendingEmployers"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallengesGenderStereotypes"))
        );
    }

    // 2. Get Event by Id
    public Event getEventDetailsById(int eventId) throws DataAccessException {
        String getSql = String.format("SELECT * FROM Event WHERE EventID = \"%s\" LIMIT 1", eventId);
        List<Event> eventInfo = jdbcTemplate().query(getSql, new Object[]{},
                (rs, i) -> new Event(rs.getInt("EventID"), rs.getString("EventName"),
                        rs.getInt("TypeOfEvent"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getInt("AttendingSchools"),rs.getInt("AttendingEmployers"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallengesGenderStereotypes"))
        );
        return eventInfo.get(0);
    }


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 1. Create a new Event
    public int createNewEvent(String EventName, int TypeOfEvent, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                              String NumberOfAttendees, int AttendingSchools, int AttendingEmployers, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                              Boolean ChallengesGenderStereoTypes) throws DataAccessException {

        String insertSql = "INSERT TO Event Event(EventName, TypeOfEvent, isPublic, isCancelled, PostCode, NameOfAdviser," +
                "                                 NumberOfAttendees, AttendingSchools, AttendingEmployers, PromotesApprenticeships, PromotesWelshLanguage," +
                "                                 ChallengesGenderStereoTypes)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, EventName, TypeOfEvent, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, AttendingSchools, AttendingEmployers, PromotesApprenticeships, PromotesWelshLanguage,
                ChallengesGenderStereoTypes);

    }
    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 1. Update an Events by Id

    public Integer updateEvent(int EventID, String EventName, int TypeOfEvent, Boolean isPublic, Boolean isCancelled, String PostCode, String NameOfAdviser,
                               String NumberOfAttendees, int AttendingSchools, int AttendingEmployers, Boolean PromotesApprenticeships, Boolean PromotesWelshLanguage,
                               Boolean ChallengesGenderStereoTypes) throws DataAccessException {

        String updateSql = "UPDATE Event SET EventName =?, EmployerName = ?, TypeOfEvent =?, isPublic=?, isCancelled=?," +
                "PostCode=?, NameOfAdviser=?, NumberOfAttendees=?, AttendingSchools=?, AttendingEmployers=?,  PromotesApprenticeships=?, PromotesWelshLanguage=?" +
                "EmployerLogo=?, GivesSiteExperience=?, GivesSiteVisits=?, GivesWorkshops=?, GivesPresentations=?, AttendsCareerFairs=?," +
                "ChallengesGenderStereoTypes=?";

        return jdbcTemplate().update(updateSql, EventName, TypeOfEvent, isPublic, isCancelled, PostCode, NameOfAdviser,
                NumberOfAttendees, AttendingSchools, AttendingEmployers, PromotesApprenticeships, PromotesWelshLanguage,
                ChallengesGenderStereoTypes);
    }

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 1. Delete an Event by ID

    public Integer deleteEvent(int eventId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Event WHERE EventID = '%s'",eventId);
        return jdbcTemplate().update(deleteSql);
    }
}
