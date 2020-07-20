package ebe.DBMethods;

import ebe.DBClasses.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployerQueries extends DBQueries {

    @Autowired
    public EmployerQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Employers
    public List<Employer> getAllEmployers() throws DataAccessException{
        return jdbcTemplate().query("SELECT * FROM Employer", new Object[]{},
                (rs, i) -> new Employer(rs.getInt("EmployerID"), rs.getInt("StatusOfEmployer"),
                        rs.getString("EmployerName"), rs.getString("EmployerAddressCity"),
                        rs.getString("EmployerAddressStreet"),rs.getString("EmployerAddressNumber"),
                        rs.getString("EmployerPostCode"),rs.getString("Email"), rs.getString("Phone"),
                        rs.getString("Website"), rs.getInt("NumberOfEmployees"), rs.getString("CompanySummary"),
                        rs.getString("Notes"), rs.getString("EmployerDocumentsAndVideos"), rs.getString("EmployerLogo"),
                        rs.getBoolean("GivesSiteExperience"),rs.getBoolean("GivesSiteVisits"), rs.getBoolean("GivesWorkshops") ,
                        rs.getBoolean("GivesPresentations"),rs.getBoolean("AttendsCareerFairs"), rs.getBoolean("GivesWebinars"),
                        rs.getBoolean("WorksWithPrimaryPupils"),rs.getBoolean("UseOfModernForeignLanguage"),
                        rs.getBoolean("RunsBusinessInWelsh"), rs.getBoolean("CanDeliverToSchoolsInWelsh"),
                        rs.getBoolean("HasApprenticeshipProgramm"),rs.getInt("SchoolsPreferences"),rs.getString("Employerscol"))
                );
    }

    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////

    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
}
