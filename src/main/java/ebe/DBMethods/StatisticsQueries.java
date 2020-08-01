package ebe.DBMethods;

import ebe.DBClasses.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StatisticsQueries extends DBQueries {

    private Connection connection;
    private Statement statement;

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

    public Map<String,Integer> getEventsByAdviser() throws DataAccessException{
        String query = "SELECT NameOfAdviser, count(NameOfAdviser) FROM Event group by 1;";
        Map<String,Integer> evMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                evMap.put(rs.getString("NameOfAdviser"),rs.getInt("count(NameOfAdviser)"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evMap;
    }

    public Map<String,Integer> getEventsByType() throws DataAccessException{
        String query = "SELECT  eventList.TypeOfEventName, count(eve.TypeOfEventID) \n" +
                "FROM Event as eve\n" +
                "INNER JOIN TypeOfEventList as eventList ON eventList.TypeOfEventID = eve.TypeOfEventID\n" +
                "group by eve.TypeOfEventID;";
        Map<String,Integer> evMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                evMap.put(rs.getString("TypeOfEventName"),rs.getInt("count(eve.TypeOfEventID)"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evMap;
    }











}
