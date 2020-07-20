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

    // 2. Get Employer Information by Id
    public Employer getEmployerDetailsById(int employerId) throws DataAccessException{
        String getSql = String.format("SELECT * FROM Employer WHERE EmployerID = \"%s\" LIMIT 1", employerId);
        List<Employer>  employerInfo = jdbcTemplate().query(getSql, new Object[]{},
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
        return employerInfo.get(0);
    }

    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    //1. Create Employer Information

    public int  createNewEmployer(int statusOfEmployer, String employerName, String employerAddressCity, String employerAddressStreet, String employerAddressNumber,
                                  String employerPostcode, String email, String phone, String website, int numberOfEmployees, String companySummary,
                                  String notes, String employerDocumentsAndVideos, String employerLogo, Boolean givesSiteExperience, Boolean givesSiteVisits,
                                  Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils,
                                  Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramm,
                                  int schoolPreferences, String employerscol) throws DataAccessException {

        String updateSql = "INSERT TO Employer Employer(statusOfEmployer, employerName, employerAddressCity, employerAddressStreet, employerAddressNumber," +
                "                                   employerPostcode, email, phone, website, numberOfEmployees,  companySummary, notes, employerDocumentsAndVideos, " +
                "                                   employerLogo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs," +
                "                                   givesWebinars,  worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh," +
                "                                   hasApprenticeshipProgramm, schoolPreferences, employerscol)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(updateSql, statusOfEmployer, employerName, employerAddressCity, employerAddressStreet, employerAddressNumber,
                employerPostcode, email, phone, website, numberOfEmployees,  companySummary, notes, employerDocumentsAndVideos,
                employerLogo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs,
                givesWebinars,  worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh,
                hasApprenticeshipProgramm, schoolPreferences, employerscol);



    }


    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
}
