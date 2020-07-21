package ebe.DBMethods;

import ebe.DBClasses.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.xml.crypto.Data;
import java.util.List;

public class EmployerQueries extends DBQueries {

    @Autowired
    public EmployerQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Employers
    public List<Employer> getAllEmployers() throws DataAccessException {
        return jdbcTemplate().query("SELECT * FROM Employer", new Object[]{},
                (rs, i) -> new Employer(rs.getInt("EmployerID"), rs.getInt("StatusOfEmployer"),
                        rs.getString("EmployerName"), rs.getString("EmployerAddressCity"),
                        rs.getString("EmployerAddressStreet"), rs.getString("EmployerAddressNumber"),
                        rs.getString("EmployerPostCode"), rs.getString("Email"), rs.getString("Phone"),
                        rs.getString("Website"), rs.getInt("NumberOfEmployees"), rs.getString("CompanySummary"),
                        rs.getString("Notes"), rs.getString("EmployerDocumentsAndVideos"), rs.getString("EmployerLogo"),
                        rs.getBoolean("GivesSiteExperience"), rs.getBoolean("GivesSiteVisits"), rs.getBoolean("GivesWorkshops"),
                        rs.getBoolean("GivesPresentations"), rs.getBoolean("AttendsCareerFairs"), rs.getBoolean("GivesWebinars"),
                        rs.getBoolean("WorksWithPrimaryPupils"), rs.getBoolean("UseOfModernForeignLanguage"),
                        rs.getBoolean("RunsBusinessInWelsh"), rs.getBoolean("CanDeliverToSchoolsInWelsh"),
                        rs.getBoolean("HasApprenticeshipProgramme"), rs.getInt("SchoolsPreferences"))
        );
    }

    // 2. Get Employer by Id
    public Employer getEmployerDetailsById(int employerId) throws DataAccessException {
        String getSql = String.format("SELECT * FROM Employer WHERE EmployerID = \"%s\" LIMIT 1", employerId);
        List<Employer> employerInfo = jdbcTemplate().query(getSql, new Object[]{},
                (rs, i) -> new Employer(rs.getInt("EmployerID"), rs.getInt("StatusOfEmployer"),
                        rs.getString("EmployerName"), rs.getString("EmployerAddressCity"),
                        rs.getString("EmployerAddressStreet"), rs.getString("EmployerAddressNumber"),
                        rs.getString("EmployerPostCode"), rs.getString("Email"), rs.getString("Phone"),
                        rs.getString("Website"), rs.getInt("NumberOfEmployees"), rs.getString("CompanySummary"),
                        rs.getString("Notes"), rs.getString("EmployerDocumentsAndVideos"), rs.getString("EmployerLogo"),
                        rs.getBoolean("GivesSiteExperience"), rs.getBoolean("GivesSiteVisits"), rs.getBoolean("GivesWorkshops"),
                        rs.getBoolean("GivesPresentations"), rs.getBoolean("AttendsCareerFairs"), rs.getBoolean("GivesWebinars"),
                        rs.getBoolean("WorksWithPrimaryPupils"), rs.getBoolean("UseOfModernForeignLanguage"),
                        rs.getBoolean("RunsBusinessInWelsh"), rs.getBoolean("CanDeliverToSchoolsInWelsh"),
                        rs.getBoolean("HasApprenticeshipProgramme"), rs.getInt("SchoolsPreferences"))
        );
        return employerInfo.get(0);
    }

    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    //1. Create New Employer

    public int createNewEmployer(int statusOfEmployer, String employerName, String employerAddressCity, String employerAddressStreet, String employerAddressNumber,
                                 String employerPostcode, String email, String phone, String website, int numberOfEmployees, String companySummary,
                                 String notes, String employerDocumentsAndVideos, String employerLogo, Boolean givesSiteExperience, Boolean givesSiteVisits,
                                 Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils,
                                 Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramme,
                                 int schoolPreferences) throws DataAccessException {

        String insertSql = "INSERT TO Employer Employer(statusOfEmployer, employerName, employerAddressCity, employerAddressStreet, employerAddressNumber," +
                "                                   employerPostcode, email, phone, website, numberOfEmployees,  companySummary, notes, employerDocumentsAndVideos, " +
                "                                   employerLogo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs," +
                "                                   givesWebinars,  worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh," +
                "                                   hasApprenticeshipProgramme, schoolPreferences)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, statusOfEmployer, employerName, employerAddressCity, employerAddressStreet, employerAddressNumber,
                employerPostcode, email, phone, website, numberOfEmployees, companySummary, notes, employerDocumentsAndVideos,
                employerLogo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs,
                givesWebinars, worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh,
                hasApprenticeshipProgramme, schoolPreferences);

    }

    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    //1. Update Employer by Id
    public Integer updateEmployer(int employerId, int statusOfEmployer, String employerName, String employerAddressCity, String employerAddressStreet, String employerAddressNumber,
                                  String employerPostcode, String email, String phone, String website, int numberOfEmployees, String companySummary,
                                  String notes, String employerDocumentsAndVideos, String employerLogo, Boolean givesSiteExperience, Boolean givesSiteVisits,
                                  Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils,
                                  Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramme,
                                  int schoolPreferences) throws DataAccessException {

        String updateSql = "UPDATE Employer SET StatusOfEmployer =?, EmployerName = ?, EmployerAddressCity =?, EmployerAddressStreet=?, EmployerAddressNumber=?," +
                "EmployerPostcode=?, Email=?, Phone=?, Website=?, NumberOfEmployees=?,  CompanySummary=?, Notes=?, EmployerDocumentsAndVideos=?" +
                "EmployerLogo=?, GivesSiteExperience=?, GivesSiteVisits=?, GivesWorkshops=?, GivesPresentations=?, AttendsCareerFairs=?," +
                "GivesWebinars=?,  WorksWithPrimaryPupils=?, UseOfModernForeignLanguage=?, RunsBusinessInWelsh=?, CanDeliverToSchoolsInWelsh=?," +
                "HasApprenticeshipProgramme=?, SchoolPreferences=? WHERE EmployerID =?";

        return jdbcTemplate().update(updateSql, statusOfEmployer, employerName, employerAddressCity, employerAddressStreet, employerAddressNumber,
                employerPostcode, email, phone, website, numberOfEmployees, companySummary, notes, employerDocumentsAndVideos,
                employerLogo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs,
                givesWebinars, worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh,
                hasApprenticeshipProgramme, schoolPreferences, employerId);
    }


    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    //1. DELETE EMPLOYER by Id
    public Integer deleteEmployer(int employerId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Employer WHERE EmployerID = '%s'",employerId);
        return jdbcTemplate().update(deleteSql);
    }

}