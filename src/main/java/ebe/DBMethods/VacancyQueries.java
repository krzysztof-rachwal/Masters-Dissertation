package ebe.DBMethods;

import ebe.DBClasses.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class VacancyQueries extends DBQueries {

    @Autowired
    public VacancyQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Vacancy
    public List<Vacancy> getAllVacancy() throws DataAccessException {
        return jdbcTemplate().query("SELECT * FROM Vacancy", new Object[]{},
                (rs, i) -> new Vacancy(rs.getInt("VacancyID"), rs.getInt("EmployerID"),
                        rs.getString("VacancyTitle"), rs.getString("Details"), rs.getString("Link"),
                        rs.getInt("TypeOfVacancy"), rs.getInt("StatusOfVacancy"),
                        rs.getDate("StartOfVacancy"),rs.getDate("ClosingDate"),
                        rs.getInt("OccupationalCode"), rs.getString("ApplicationMethod"),
                        rs.getString("Postcode"))
        );
    }

    // 2. Get Vacancy by Id
    public Vacancy getVacancyDetailsById(int vacancyId) throws DataAccessException {
        String getSql = String.format("SELECT * FROM Vacancy WHERE VacancyID = \"%s\" LIMIT 1", vacancyId);
        List<Vacancy> schoolInfo = jdbcTemplate().query(getSql, new Object[]{},
                (rs, i) -> new Vacancy(rs.getInt("VacancyID"), rs.getInt("EmployerID"),
                        rs.getString("VacancyTitle"), rs.getString("Details"), rs.getString("Link"),
                        rs.getInt("TypeOfVacancy"), rs.getInt("StatusOfVacancy"),
                        rs.getDate("StartOfVacancy"),rs.getDate("ClosingDate"),
                        rs.getInt("OccupationalCode"), rs.getString("ApplicationMethod"),
                        rs.getString("Postcode"))
        );
        return schoolInfo.get(0);
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
