package ebe.DBMethods;

import ebe.DBClasses.School;
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
    // 1. Get All School
    public List<School> getAllSchools() throws DataAccessException {
        return jdbcTemplate().query("SELECT * FROM School", new Object[]{},
                (rs, i) -> new School(rs.getInt("SchoolID"), rs.getString("SchoolName"),
                        rs.getString("SchoolAddressCity"), rs.getString("SchoolAddressStreet"),
                        rs.getString("SchoolAddressNumber"), rs.getString("Email"),
                        rs.getString("Phone"))
        );
    }

    // 2. Get School by Id
    public School getSchoolDetailsById(int schoolId) throws DataAccessException {
        String getSql = String.format("SELECT * FROM School WHERE SchoolID = \"%s\" LIMIT 1", schoolId);
        List<School> schoolInfo = jdbcTemplate().query(getSql, new Object[]{},
                (rs, i) -> new School(rs.getInt("SchoolID"), rs.getString("SchoolName"),
                        rs.getString("SchoolAddressCity"), rs.getString("SchoolAddressStreet"),
                        rs.getString("SchoolAddressNumber"), rs.getString("Email"),
                        rs.getString("Phone"))
        );
        return schoolInfo.get(0);
    }


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    // 1. Create a new School
    public int createNewSchool(String SchoolName, String SchoolAddressCity, String SchoolAddressStreet,
                               Boolean SchoolAddressNumber, String Email, String Phone) throws DataAccessException {

        String insertSql = "INSERT TO School School(SchoolName, SchoolAddressCity, SchoolAddressStreet, SchoolAddressNumber, Email, Phone)" +
                "                                  VALUES(?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, SchoolName, SchoolAddressCity, SchoolAddressStreet, SchoolAddressNumber, Email, Phone);

    }
    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    // 1. Update an School by Id

    public Integer updateSchool(int SchoolID,String SchoolName, String SchoolAddressCity, String SchoolAddressStreet,
                                Boolean SchoolAddressNumber, String Email, String Phone) throws DataAccessException {

        String updateSql = "UPDATE School SET SchoolName =?, SchoolAddressCity = ?, SchoolAddressStreet =?, SchoolAddressNumber=?," +
                           " SchoolAddressNumber=?, Email=?, Phone=?  WHERE SchoolID =?";

        return jdbcTemplate().update(updateSql, SchoolName, SchoolAddressCity, SchoolAddressStreet, SchoolAddressNumber, Email, Phone, SchoolID);
    }

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    // 1. Delete an School by ID

    public Integer deleteSchool(int schoolId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM School WHERE SchoolID = '%s'",schoolId);
        return jdbcTemplate().update(deleteSql);
    }
}
