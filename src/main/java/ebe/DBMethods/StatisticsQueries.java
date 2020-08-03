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
import java.util.Map;

@Repository
public class StatisticsQueries extends DBQueries {

    private Connection connection;
    private Statement statement;

    @Autowired
    public StatisticsQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    public int getTotalEvents() throws DataAccessException {
        return jdbcTemplate().queryForObject("SELECT count(*) FROM Event",
                new Object[]{}, Integer.class);
    }

    public int getTotalEmployers() throws DataAccessException {
        return jdbcTemplate().queryForObject("SELECT count(*) FROM Employer;",
                new Object[]{}, Integer.class);
    }

    public int getTotalVacancies() throws DataAccessException {
        return jdbcTemplate().queryForObject("SELECT count(*) FROM Vacancy;",
                new Object[]{}, Integer.class);
    }

    public int getSchoolsAtEvents() throws DataAccessException {
        return jdbcTemplate().queryForObject("SELECT COUNT(*) FROM INT_AttendingSchoolOnEvent;",
                new Object[]{}, Integer.class);
    }

    public int getTotalPupils() throws DataAccessException {
        return jdbcTemplate().queryForObject("SELECT sum(NumberOfAttendees) From Event;",
                new Object[]{}, Integer.class);
    }

    public int getRequestsBySchools() throws DataAccessException {
        return jdbcTemplate().queryForObject("SELECT sum(SchoolNumberOfRequest) FROM School;",
                new Object[]{}, Integer.class);
    }

    public Map<String, Integer> getEventsByAdviser() throws DataAccessException {
        String query = "SELECT NameOfAdviser, count(NameOfAdviser) FROM Event group by 1;";
        Map<String, Integer> evMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                evMap.put(rs.getString("NameOfAdviser"), rs.getInt("count(NameOfAdviser)"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evMap;
    }

    public Map<String, Integer> getEventsByType() throws DataAccessException {
        String query = "SELECT  eventList.TypeOfEventName, count(eve.TypeOfEventID) \n" +
                "FROM Event as eve\n" +
                "INNER JOIN TypeOfEventList as eventList ON eventList.TypeOfEventID = eve.TypeOfEventID\n" +
                "group by eve.TypeOfEventID;";
        Map<String, Integer> evMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                evMap.put(rs.getString("TypeOfEventName"), rs.getInt("count(eve.TypeOfEventID)"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return evMap;
    }

    public Map<String, Integer> getEmployersBySector() throws DataAccessException {
        String query = "SELECT count(emp.EmployerName) as empCount, ind.IndustrySectorName as sector\n" +
                "FROM INT_EmployerIndustrySector inter \n" +
                "INNER JOIN Employer emp ON inter.EmployerID = emp.EmployerID\n" +
                "INNER JOIN IndustrySectorList ind ON ind.IndustrySectorID = inter.IndustrySectorID\n" +
                "GROUP BY inter.IndustrySectorID;";
        Map<String, Integer> empMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                empMap.put(rs.getString("sector"), rs.getInt("empCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empMap;
    }

    public Map<String, Integer> getEventByLocalAuth() throws DataAccessException {
        String query = "SELECT count(eve.EventID) as eveCount, la.LocalAuthorityName as authName\n" +
                "FROM Event eve\n" +
                "INNER JOIN PostcodeList pc ON pc.PostcodeName = eve.EventVenuePostcode\n" +
                "INNER JOIN LocalAuthorityList la ON la.LocalAuthorityID = pc.LocalAuthorityID\n" +
                "GROUP BY 2;  ";
        Map<String, Integer> eveMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                eveMap.put(rs.getString("authName"), rs.getInt("eveCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eveMap;
    }

    public Map<String, Integer> getTotalPupilsByAuth() throws DataAccessException {
        String query = "SELECT sum(eve.NumberOfAttendees)  as numberOfAttendees, la.LocalAuthorityName as authName\n" +
                "From Event eve \n" +
                "INNER JOIN PostcodeList pc ON pc.PostcodeName = eve.EventVenuePostcode\n" +
                "INNER JOIN LocalAuthorityList la ON la.LocalAuthorityID = pc.LocalAuthorityID\n" +
                "GROUP BY 2;";
        Map<String, Integer> pupilsMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                pupilsMap.put(rs.getString("authName"), rs.getInt("numberOfAttendees"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pupilsMap;
    }

    public Map<String, Integer> getSchoolsAttendingEventsByAuth() throws DataAccessException {
        String query = "SELECT COUNT(sc.SchoolId) as schoolCount, la.LocalAuthorityName as authName\n" +
                "FROM INT_AttendingSchoolOnEvent sc\n" +
                "INNER JOIN Event eve ON eve.EventID = sc.EventID\n" +
                "INNER JOIN PostcodeList pc ON pc.PostcodeName = eve.EventVenuePostcode\n" +
                "INNER JOIN LocalAuthorityList la ON la.LocalAuthorityID = pc.LocalAuthorityID\n" +
                "GROUP BY 2;";
        Map<String, Integer> schoolMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                schoolMap.put(rs.getString("authName"), rs.getInt("schoolCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schoolMap;
    }

    public Map<String, Integer> getEmpByLocalAuth() throws DataAccessException {
        String query = "SELECT count(inter.EmployerID) empCount, la.LocalAuthorityName as authName\n" +
                "FROM INT_LocalAuthorityEmployerCanWorkWith inter\n" +
                "INNER JOIN LocalAuthorityList la ON inter.LocalAuthorityID = la.LocalAuthorityID\n" +
                "GROUP BY 2;";
        Map<String, Integer> empMap = new HashMap<>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                empMap.put(rs.getString("authName"), rs.getInt("empCount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empMap;
    }


}












