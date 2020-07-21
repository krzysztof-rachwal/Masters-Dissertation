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
                        rs.getInt("TypeOfEvent"), rs.getBoolean("isPublic"),
                        rs.getBoolean("isCancelled"), rs.getString("PostCode"),
                        rs.getString("NameOfAdviser"), rs.getString("NumberOfAttendees"),
                        rs.getInt("AttendingSchools"),rs.getInt("AttendingEmployers"),
                        rs.getBoolean("PromotesApprenticeships"), rs.getBoolean("PromotesWelshLanguage"),
                        rs.getBoolean("ChallengesGenderStereotypes"))
        );
    }

    // 2. Get Event by Id


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 1. Create a new Event

    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 1. Update an Events by Id

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 1. Delete an Event by ID
}
