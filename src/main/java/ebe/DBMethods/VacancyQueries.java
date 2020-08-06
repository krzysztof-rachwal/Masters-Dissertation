package ebe.DBMethods;

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
public class VacancyQueries extends DBQueries {

    private Connection connection;
    private Statement statement;

    @Autowired
    public VacancyQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Vacancy
    public List<Vacancy> getAllVacancy() throws DataAccessException {
        String getQuery = "SELECT * FROM Vacancy";
        List<Vacancy> list = new ArrayList<Vacancy>();
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                vacancy = new Vacancy(rs.getInt("VacancyID"), rs.getInt("EmployerID"),
                        rs.getString("VacancyName"), rs.getString("VacancySummary"), rs.getString("VacancyLink"),
                        rs.getInt("TypeOfVacancyID"), rs.getInt("StatusOfVacancyID"),
                        rs.getDate("StartOfVacancy"),rs.getDate("DeadlineForApplication"),
                        rs.getInt("OccupationalCodeID"), rs.getInt("ApplicationMethodID"),
                        rs.getString("VacancyPostcode"));

                list.add(vacancy);
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


    // 2. Get Vacancy by id
    public Vacancy  getVacancyDetailsById(int vacancyId) throws DataAccessException {
        String getQuery = String.format("SELECT * FROM Vacancy WHERE VacancyID = \"%s\" LIMIT 1", vacancyId);
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                vacancy = new Vacancy(rs.getInt("VacancyID"), rs.getInt("EmployerID"),
                        rs.getString("VacancyName"), rs.getString("VacancySummary"), rs.getString("VacancyLink"),
                        rs.getInt("TypeOfVacancyID"), rs.getInt("StatusOfVacancyID"),
                        rs.getDate("StartOfVacancy"),rs.getDate("DeadlineForApplication"),
                        rs.getInt("OccupationalCodeID"), rs.getInt("ApplicationMethodID"),
                        rs.getString("VacancyPostcode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return vacancy;
    }

    // 3. Get Vacancy Type id
    public Integer getTypeOfVacancyIdByName(String vacancyType) throws DataAccessException {
        String getQuery = String.format("SELECT TypeOfVacancyID FROM TypeOfVacancyList WHERE TypeOfVacancyName = \"%s\" LIMIT 1", vacancyType);
        Vacancy vacancy = null;
        ResultSet rs = null;
        System.out.println(vacancyType);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                vacancy = new Vacancy();
                vacancy.setTypeOfVacancyID( rs.getInt("TypeOfVacancyID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        System.out.println(vacancy.getTypeOfVacancyID());
        return vacancy.getTypeOfVacancyID();
    }

    // 4. Get Vacancy OccupationalCode id
    public Integer getOccupationalCodeIdByName(String occupationalCode) throws DataAccessException {
        String getQuery = String.format("OccupationalCodeID \"%s\" LIMIT 1", occupationalCode);
        Vacancy vacancy = null;
        ResultSet rs = null;
        System.out.println(occupationalCode);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                vacancy = new Vacancy();
                vacancy.setOccupationalCodeID( rs.getInt("OccupationalCodeID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return vacancy.getOccupationalCodeID();
    }

    // 5. Get Vacancy Status id
    public Integer getStatusOfVacancyIdByName(String vacancyStatus) throws DataAccessException {
        String getQuery = String.format("SELECT StatusOfVacancyID FROM StatusOfVacancyList WHERE StatusOfVacancyName = \"%s\" LIMIT 1", vacancyStatus);
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                vacancy = new Vacancy();
                vacancy.setStatusOfVacancyID( rs.getInt("StatusOfVacancyID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return vacancy.getStatusOfVacancyID();
    }

    // 6. Get List of Vacancy Types Names and Ids
    public List<Vacancy> getAllTypesOfVacancy() throws DataAccessException {
        String getQuery = "SELECT * FROM TypeOfVacancyList";
        List<Vacancy> list = new ArrayList<Vacancy>();
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                vacancy = new Vacancy();
                vacancy.setTypeOfVacancyID(rs.getInt("TypeOfVacancyID"));
                vacancy.setTypeOfVacancyName(rs.getString("TypeOfVacancyName"));

                list.add(vacancy);
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

    // 7. Get List of Vacancy Status Names and Ids
    public List<Vacancy> getAllStatusOfVacancy() throws DataAccessException {
        String getQuery = "SELECT * FROM StatusOfVacancyList";
        List<Vacancy> list = new ArrayList<Vacancy>();
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                vacancy = new Vacancy();
                vacancy.setStatusOfVacancyID(rs.getInt("StatusOfVacancyID"));
                vacancy.setStatusOfVacancyName(rs.getString("StatusOfVacancyName"));

                list.add(vacancy);
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

    // 8. Get List of OccupationalCodes Names and Ids
    public List<Vacancy> getAllOccupationalCodes() throws DataAccessException {
        String getQuery = "SELECT OccupationalCodeID, OccupationalCodeName FROM OccupationalCodeList";
        List<Vacancy> list = new ArrayList<Vacancy>();
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                vacancy = new Vacancy();
                vacancy.setOccupationalCodeID(rs.getInt("OccupationalCodeID"));
                vacancy.setOccupationalCodeName(rs.getString("OccupationalCodeName"));

                list.add(vacancy);
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

    // 9. Get List of ApplicationMethods Names and Ids
    public List<Vacancy> getAllApplicationMethods() throws DataAccessException {
        String getQuery = "SELECT ApplicationMethodID, ApplicationMethodName FROM ApplicationMethodList";
        List<Vacancy> list = new ArrayList<Vacancy>();
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                vacancy = new Vacancy();
                vacancy.setApplicationMethodID(rs.getInt("ApplicationMethodID"));
                vacancy.setApplicationMethodName(rs.getString("ApplicationMethodName"));

                list.add(vacancy);
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

    // 10. Get Vacancy - Employer Name
    public Vacancy getVacancyEmployerName(int employerId) throws DataAccessException {
        String getQuery = String.format("SELECT EmployerName FROM Employer WHERE EmployerID = \"%s\" LIMIT 1", employerId);

        List<Vacancy> list = new ArrayList<Vacancy>();
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                vacancy = new Vacancy();
                vacancy.setEmployerName(rs.getString("EmployerName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return vacancy;
    }

    // 10. Update Vacancy Id by Giving Name and PostCode
    public Integer getVacancyIdByNameAndPostCode(String vacancyName, String vacancyPostCode) throws DataAccessException {
        String updateQuery = String.format("SELECT VacancyID FROM Vacancy WHERE (VacancyName = \"%s\" AND VacancyPostcode = \"%s\")", vacancyName,vacancyPostCode);
        ResultSet rs = null;
        int vacancyId = 0;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(updateQuery);
            while (rs.next()) {
                vacancyId = rs.getInt("VacancyID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return vacancyId;
    }

    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 10. Create a new Vacancy
    public int createVacancy (int EmployerID, String VacancyName, String VacancySummary, String VacancyLink, int TypeOfVacancyID,int StatusOfVacancyID ,String StartOfVacancy,
                              String DeadlineForApplication, int OccupationalCodeID, String ApplicationMethodID, String VacancyPostcode) throws DataAccessException {

        String insertSql = "INSERT INTO Vacancy(EmployerID, VacancyName, VacancySummary, VacancyLink, TypeOfVacancyID, StatusOfVacancyID," +
                "StartOfVacancy, DeadlineForApplication, OccupationalCodeID, ApplicationMethodID, VacancyPostcode)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, EmployerID, VacancyName, VacancySummary, VacancyLink, TypeOfVacancyID, StatusOfVacancyID,
                StartOfVacancy, DeadlineForApplication, OccupationalCodeID, ApplicationMethodID, VacancyPostcode);


    }
    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 11. Update an Vacancy by Id

    public Integer updateVacancy(int VacancyID,int EmployerID, String VacancyName, String VacancySummary, String VacancyLink, int TypeOfVacancyID,int StatusOfVacancyID ,String StartOfVacancy,
                                 String DeadlineForApplication, int OccupationalCodeID, String ApplicationMethodID, String VacancyPostcode) throws DataAccessException {

        String updateSql = "UPDATE Vacancy SET EmployerID=?, VacancyName=?, VacancySummary=?, VacancyLink=?, TypeOfVacancyID=?, StatusOfVacancyID=?," +
                "StartOfVacancy=?, DeadlineForApplication=?, OccupationalCodeID=?, ApplicationMethodID=?, VacancyPostcode=?  WHERE VacancyID =?";

        return jdbcTemplate().update(updateSql,EmployerID, VacancyName, VacancySummary, VacancyLink, TypeOfVacancyID, StatusOfVacancyID,
                StartOfVacancy, DeadlineForApplication, OccupationalCodeID, ApplicationMethodID, VacancyPostcode, VacancyID);
    }

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 11. Delete an Vacancy by ID

    public Integer deleteVacancy(int vacancyId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Vacancy WHERE VacancyID = '%s'",vacancyId);
        return jdbcTemplate().update(deleteSql);
    }
}
