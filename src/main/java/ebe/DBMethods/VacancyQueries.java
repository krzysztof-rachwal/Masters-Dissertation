package ebe.DBMethods;

import ebe.DBClasses.Employer;
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
import java.util.Date;
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
                        rs.getString("VacancyTitle"), rs.getString("Details"), rs.getString("Link"),
                        rs.getInt("TypeOfVacancy"), rs.getInt("StatusOfVacancy"),
                        rs.getDate("StartOfVacancy"),rs.getDate("ClosingDate"),
                        rs.getInt("OccupationalCode"), rs.getString("ApplicationMethod"),
                        rs.getString("Postcode"));

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


    // 2. Get Vacancy by Id
    public Vacancy getVacancyDetailsById(int vacancyId) throws DataAccessException {
        String getQuery = String.format("SELECT * FROM Vacancy WHERE VacancyID = \"%s\" LIMIT 1", vacancyId);
        Vacancy vacancy = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                vacancy = new Vacancy(rs.getInt("VacancyID"), rs.getInt("EmployerID"),
                        rs.getString("VacancyTitle"), rs.getString("Details"), rs.getString("Link"),
                        rs.getInt("TypeOfVacancy"), rs.getInt("StatusOfVacancy"),
                        rs.getDate("StartOfVacancy"),rs.getDate("ClosingDate"),
                        rs.getInt("OccupationalCode"), rs.getString("ApplicationMethod"),
                        rs.getString("Postcode"));
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


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 1. Create a new Vacancy
    public int createNewVacancy (int EmployerID, String VacancyTitle, String Details, String Link, int TypeOfVacancy,int StatusOfVacancy ,Date StartOfVacancy,
                                Date ClosingDate, int OccupationalCode, String ApplicationMethod, String Postcode) throws DataAccessException {

        String insertSql = "INSERT TO Vacancy Vacancy(EmployerID, VacancyTitle, Details, Link, TypeOfVacancy, StatusOfVacancy" +
                "StartOfVacancy, StartOfVacancy, ClosingDate, OccupationalCode, ApplicationMethod, Postcode)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, EmployerID, VacancyTitle, Details, Link, TypeOfVacancy, TypeOfVacancy,StatusOfVacancy,
                StartOfVacancy, ClosingDate, OccupationalCode, ApplicationMethod, Postcode);

    }
    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 1. Update an Vacancy by Id

    public Integer updateVacancy(int VacancyID, int EmployerID, String VacancyTitle, String Details, String Link, int TypeOfVacancy,int StatusOfVacancy ,Date StartOfVacancy,
                                 Date ClosingDate, int OccupationalCode, String ApplicationMethod, String Postcode) throws DataAccessException {

        String updateSql = "UPDATE Vacancy SET EmployerID =?, VacancyTitle=?, Details = ?, Link =?, TypeOfVacancy=?, StatusOfVacancy=?," +
                "StartOfVacancy=?, ClosingDate=?, OccupationalCode=?, ApplicationMethod=?, Postcode=?  WHERE VacancyID =?";

        return jdbcTemplate().update(updateSql,EmployerID, VacancyTitle, Details, Link, TypeOfVacancy,StatusOfVacancy,
                StartOfVacancy, ClosingDate, OccupationalCode, ApplicationMethod, Postcode, VacancyID);
    }

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 1. Delete an Vacancy by ID

    public Integer deleteVacancy(int vacancyId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Vacancy WHERE VacancyID = '%s'",vacancyId);
        return jdbcTemplate().update(deleteSql);
    }
}
