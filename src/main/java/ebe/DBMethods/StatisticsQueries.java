package ebe.DBMethods;

import ebe.DBClasses.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatisticsQueries extends DBQueries {

    @Autowired
    public StatisticsQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    public int getTotalEvents() throws DataAccessException{
        return jdbcTemplate().queryForObject("SELECT count(*) FROM Event",
                new Object[]{} , Integer.class);
    }

    public int getTotalEmployers() throws DataAccessException{
        return jdbcTemplate().queryForObject("SELECT count(*) FROM Employer;",
                new Object[]{} , Integer.class);
    }

    public int getTotalVacancies() throws DataAccessException{
        return jdbcTemplate().queryForObject("SELECT count(*) FROM Vacancy;",
                new Object[]{} , Integer.class);
    }
  public int getSchoolsAtEvents() throws DataAccessException{
        return jdbcTemplate().queryForObject("SELECT COUNT(*) FROM INT_AttendingSchoolOnEvent WHERE EventID=3;",
                new Object[]{} , Integer.class);
    }
  public int getTotalPupils() throws DataAccessException{
        return jdbcTemplate().queryForObject("SELECT sum(NumberOfAttendees) From Event;",
                new Object[]{} , Integer.class);
    }
    public int getRequestsBySchools() throws DataAccessException{
        return jdbcTemplate().queryForObject("SELECT sum(SchoolNumberOfRequest) FROM School;",
                new Object[]{} , Integer.class);
    }











}
