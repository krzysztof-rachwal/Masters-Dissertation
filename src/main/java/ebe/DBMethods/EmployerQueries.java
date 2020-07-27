package ebe.DBMethods;

import ebe.DBClasses.Employer;
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
public class EmployerQueries extends DBQueries {


    private Connection connection;
    private Statement statement;

    @Autowired
    public EmployerQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

    ///////////////////////////////////// GET ALL METHODS ///////////////////////////////////////////////
    // 1. Get All Employers
    public List<Employer> getAllEmployers() throws DataAccessException {
        String getQuery = "SELECT * FROM Employer";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer(rs.getInt("EmployerID"), rs.getInt("StatusOfEmployer"),
                        rs.getString("Name"), rs.getString("AddressCity"),
                        rs.getString("AddressStreet"), rs.getString("AddressNumber"),
                        rs.getString("PostCode"), rs.getString("Email"), rs.getString("Phone"),
                        rs.getString("Website"), rs.getInt("NumberOfEmployees"),
                        rs.getString("CompanySummary"), rs.getString("Notes"),
                        rs.getString("LogoLink"), rs.getBoolean("GivesSiteExperience"),
                        rs.getBoolean("GivesSiteVisits"), rs.getBoolean("GivesWorkshops"),
                        rs.getBoolean("GivesPresentations"), rs.getBoolean("AttendsCareerFairs"),
                        rs.getBoolean("GivesWebinars"), rs.getBoolean("WorksWithPrimaryPupils"),
                        rs.getBoolean("UseOfModernForeignLanguage"), rs.getBoolean("RunsBusinessInWelsh"),
                        rs.getBoolean("CanDeliverToSchoolsInWelsh"), rs.getBoolean("HasApprenticeshipProgramme"));

                list.add(employer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }

    // 2. Get Employer by Id
    public Employer getEmployerDetailsById(int employerId) throws DataAccessException {
        String getQuery = String.format("SELECT * FROM Employer WHERE EmployerID = \"%s\" LIMIT 1", employerId);
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                employer = new Employer();
                employer.setEmployerID(rs.getInt("EmployerID"));
                employer.setStatusOfEmployer(rs.getInt("StatusOfEmployer"));
                employer.setName(rs.getString("Name"));
                employer.setAddressCity(rs.getString("AddressCity"));
                employer.setAddressStreet(rs.getString("AddressStreet"));
                employer.setAddressNumber(rs.getString("AddressNumber"));
                employer.setPostcode(rs.getString("PostCode"));
                employer.setEmail(rs.getString("Email"));
                employer.setPhone(rs.getString("Phone"));
                employer.setWebsite(rs.getString("Website"));
                employer.setNumberOfEmployees(rs.getInt("NumberOfEmployees"));
                employer.setCompanySummary(rs.getString("CompanySummary"));
                employer.setNotes(rs.getString("Notes"));
                employer.setLogoLink(rs.getString("LogoLink"));
                employer.setGivesSiteExperience(rs.getBoolean("GivesSiteExperience"));
                employer.setGivesSiteVisits(rs.getBoolean("GivesSiteVisits"));
                employer.setGivesWorkshops(rs.getBoolean("GivesWorkshops"));
                employer.setGivesPresentations(rs.getBoolean("GivesPresentations"));
                employer.setAttendsCareerFairs(rs.getBoolean("AttendsCareerFairs"));
                employer.setGivesWebinars(rs.getBoolean("GivesWebinars"));
                employer.setWorksWithPrimaryPupils(rs.getBoolean("WorksWithPrimaryPupils"));
                employer.setUseOfModernForeignLanguage(rs.getBoolean("UseOfModernForeignLanguage"));
                employer.setRunsBusinessInWelsh(rs.getBoolean("RunsBusinessInWelsh"));
                employer.setCanDeliverToSchoolsInWelsh(rs.getBoolean("CanDeliverToSchoolsInWelsh"));
                employer.setHasApprenticeshipProgramme(rs.getBoolean("HasApprenticeshipProgramme"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return employer;
    }

    //4. Get all Employer Ids and Names
    public List<Employer> getAllEmployerNamesAndIds() throws DataAccessException {
        String getQuery = "SELECT EmployerID, Name  FROM Employer";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerID(rs.getInt("EmployerID"));
                employer.setName(rs.getString("Name"));

                list.add(employer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    //3. Create New Employer

    public int createNewEmployer(int statusOfEmployer, String Name, String AddressCity, String AddressStreet, String AddressNumber,
                                 String Postcode, String email, String phone, String website, int numberOfEmployees, String companySummary,
                                 String notes, String LogoLink, Boolean givesSiteExperience, Boolean givesSiteVisits,
                                 Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils,
                                 Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramme,
                                 int schoolPreferences) throws DataAccessException {

        String insertSql = "INSERT TO Employer Employer(statusOfEmployer, Name, AddressCity, AddressStreet, AddressNumber," +
                "                                   Postcode, email, phone, website, numberOfEmployees,  companySummary, notes, LogoLink, " +
                "                                   Logo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs," +
                "                                   givesWebinars,  worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh," +
                "                                   hasApprenticeshipProgramme, schoolPreferences)" +
                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql, statusOfEmployer, Name, AddressCity, AddressStreet, AddressNumber,
                Postcode, email, phone, website, numberOfEmployees, companySummary, notes, LogoLink,
                givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs,
                givesWebinars, worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh,
                hasApprenticeshipProgramme, schoolPreferences);

    }

    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    //5. Update Employer by Id
    public Integer updateEmployer(int employerId, int statusOfEmployer, String Name, String AddressCity, String AddressStreet, String AddressNumber,
                                  String Postcode, String email, String phone, String website, int numberOfEmployees, String companySummary,
                                  String notes, String DocumentsAndVideos, String Logo, Boolean givesSiteExperience, Boolean givesSiteVisits,
                                  Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils,
                                  Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramme,
                                  int schoolPreferences) throws DataAccessException {

        String updateSql = "UPDATE Employer SET StatusOfEmployer =?, Name = ?, AddressCity =?, AddressStreet=?, AddressNumber=?," +
                "Postcode=?, Email=?, Phone=?, Website=?, NumberOfEmployees=?,  CompanySummary=?, Notes=?, LogoLink=?" +
                "Logo=?, GivesSiteExperience=?, GivesSiteVisits=?, GivesWorkshops=?, GivesPresentations=?, AttendsCareerFairs=?," +
                "GivesWebinars=?,  WorksWithPrimaryPupils=?, UseOfModernForeignLanguage=?, RunsBusinessInWelsh=?, CanDeliverToSchoolsInWelsh=?," +
                "HasApprenticeshipProgramme=?, SchoolPreferences=? WHERE EmployerID =?";

        return jdbcTemplate().update(updateSql, statusOfEmployer, Name, AddressCity, AddressStreet, AddressNumber,
                Postcode, email, phone, website, numberOfEmployees, companySummary, notes, DocumentsAndVideos,
                Logo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs,
                givesWebinars, worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh,
                hasApprenticeshipProgramme, schoolPreferences, employerId);
    }


    ///////////////////////////////////// DELETE ALL METHODS ///////////////////////////////////////////////
    //6. DELETE EMPLOYER by Id
    public Integer deleteEmployer(int employerId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Employer WHERE EmployerID = '%s'",employerId);
        return jdbcTemplate().update(deleteSql);
    }

}