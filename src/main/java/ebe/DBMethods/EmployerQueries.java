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
import java.util.Arrays;
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
                employer = new Employer(rs.getInt("EmployerID"), rs.getInt("StatusOfEmployerID"),
                        rs.getString("EmployerName"), rs.getString("EmployerAddressCity"),
                        rs.getString("EmployerAddressStreet"), rs.getString("EmployerAddressNumber"),
                        rs.getString("EmployerPostcode"), rs.getString("EmployerEmail"),
                        rs.getString("ContactPersonNameSurname"),rs.getString("ContactPersonPosition"),
                        rs.getString("EmployerPhone"), rs.getString("EmployerWebsite"),
                        rs.getString("EmployerTwitter"), rs.getString("EmployerFB"),
                        rs.getInt("NumberOfEmployeesID"), rs.getString("CompanySummary"),
                        rs.getString("Notes"), rs.getString("LogoLink"));

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
                employer.setStatusOfEmployerID(rs.getInt("StatusOfEmployerID"));
                employer.setEmployerName(rs.getString("EmployerName"));
                employer.setEmployerAddressCity(rs.getString("EmployerAddressCity"));
                employer.setEmployerAddressStreet(rs.getString("EmployerAddressStreet"));
                employer.setEmployerAddressNumber(rs.getString("EmployerAddressNumber"));
                employer.setEmployerPostcode(rs.getString("EmployerPostcode"));
                employer.setEmployerEmail(rs.getString("EmployerEmail"));
                employer.setContactPersonNameSurname(rs.getString("ContactPersonNameSurname"));
                employer.setContactPersonPosition(rs.getString("ContactPersonPosition"));
                employer.setEmployerPhone(rs.getString("EmployerPhone"));
                employer.setEmployerWebsite(rs.getString("EmployerWebsite"));
                employer.setEmployerTwitter(rs.getString("EmployerTwitter"));
                employer.setEmployerFB(rs.getString("EmployerFB"));
                employer.setNumberOfEmployeesID(rs.getInt("NumberOfEmployeesID"));
                employer.setCompanySummary(rs.getString("CompanySummary"));
                employer.setNotes(rs.getString("Notes"));
                employer.setLogoLink(rs.getString("LogoLink"));

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

    public List<Integer> getFilteredEmployersIds(List<Integer> IndustrySectors,
                                                 List<Integer> LocalAuthorities, List<Integer> AreasOfCurriculum,
                                                 List<Integer> Languages, List<Integer> SchoolPreferences, List<Integer> EmployerPreferences,
                                                 List<Integer> CooperationTypes, List<Integer> AlumniSchools ) throws DataAccessException {

        List<Integer> ids = new ArrayList<>();
        connection = ConnectionFactory.getConnection();

        // return only live employers
        int StatusOfEmployer = 1;

        ResultSet rs = null;

        List<List<Integer>> listOfFilters = Arrays.asList(IndustrySectors, LocalAuthorities, AreasOfCurriculum,
                Languages, SchoolPreferences, EmployerPreferences, CooperationTypes, AlumniSchools);

//        List<Integer> listOfSingleAttributes = Arrays.asList(NumberOfEmployees, StatusOfEmployer);
//
//        List<Integer> listOfBooleans = Arrays.asList(WorkExperience, SiteVisits,
//                SchoolWorkshop, Presentations, CareerFairs, Webinars, WorksWithPrimaries, RunsBusinessInWelsh,
//                DeliversInWelsh,HasApprenticeships);

        List<String> listOfSQL = Arrays.asList("SELECT eis.EmployerID FROM INT_EmployerIndustrySector AS eis",
                "SELECT la.EmployerID FROM INT_LocalAuthorityEmployerCanWorkWith as la",
                "SELECT ac.EmployerID FROM INT_EmployerSupportOfAreaOfCurriculum as ac",
                "SELECT l.EmployerID FROM INT_LanguageUsedByEmployer as l",
                "SELECT sp.EmployerID FROM INT_EmployerSchoolPreference as sp",
                "SELECT ep.EmployerID FROM INT_EmployerPreference as ep",
                "SELECT ct.EmployerID FROM INT_EmployerCooperationType as ct",
                "SELECT ae.EmployerID FROM INT_AlumniWorkingForEmployer AS ae WHERE ae.AlumniID IN (SELECT a.AlumniID FROM Alumni AS a");

        List<String> listOfExtensions = Arrays.asList("eis.IndustrySectorID = ", "la.LocalAuthorityID = ", "ac.AreaOfCurriculumID = ",
                "l.LanguageID = ", "sp.SchoolID = ", "ep.PreferenceID = ", "ct.CooperationTypeID = ", "a.AlumniSchoolID = ");

        List<String> generatedSQL = new ArrayList<>();

        // Prepare Queries
        for(int i = 0; i < listOfFilters.size(); ++i){
            if (listOfFilters.get(i).size() != 0){
                listOfSQL.set(i,listOfSQL.get(i).concat(" WHERE "));
            } else {
                listOfSQL.set(i,listOfSQL.get(i).concat(""));
            }

            String Extension = "";
            for (int k = 0; k < listOfFilters.get(i).size(); ++k) {
                Extension = Extension.concat(listOfExtensions.get(i) + listOfFilters.get(i).get(k) + " ");
                if (k != listOfFilters.get(i).size()-1){
                    Extension = Extension.concat("OR ");
                } else {
                    // Trap for AlumniSchool to close the statement
                    if (i == listOfFilters.size()-1){
                        Extension = Extension.concat(")");
                    }
                    Extension = Extension.concat("");
                }
            }
            generatedSQL.add(listOfSQL.get(i)+Extension);
        }

        // If AlumniSchool is empty, add ")" to the string in order to close statement
        if (listOfFilters.get(listOfFilters.size()-1).size() == 0){
            generatedSQL.set(listOfFilters.size()-1,generatedSQL.get(generatedSQL.size()-1).concat(")"));
        }
//        System.out.println(generatedSQL);

        String finalSQL = "SELECT distinct EmployerID FROM Employer WHERE EmployerID IN ";
        for (int i = 0; i < generatedSQL.size(); ++i){
            finalSQL = finalSQL.concat("( " + generatedSQL.get(i) + ") ");
            if (i != generatedSQL.size()-1){
                finalSQL = finalSQL.concat(" AND EmployerID IN ");
            } else{
                finalSQL = finalSQL.concat("");
            }
        }

//        List<String> intValuesListofSQLQuery = Arrays.asList(" e.NumberOfEmployeesID = ", " e.StatusOfEmployerID = ");
//
//        List<String> singleValueslistOfSQLQuery = Arrays.asList(
//                " e.GivesSiteExperience = "," e.GivesSiteVisits = "," e.GivesWorkshops = " , " e.GivesPresentations = ",
//                " e.AttendsCareerFairs = ", " e.GivesWebinars = ", " e.WorksWithPrimaryPupils = ", " e.RunsBusinessInWelsh = ",
//                " e.CanDeliverToSchoolsInWelsh = ", " e.HasApprenticeshipProgramme = ");
//
//        // Build SQL for single value attributes
//        String booleanSQL = "AND EmployerID IN ( SELECT e.EmployerID FROM Employer AS e ";
//
//        // If at least one single value attribute is selected
//        if (listOfBooleans.contains(1)){
//            booleanSQL = booleanSQL.concat(" WHERE ");
//        }
//
//        for (int i = 0; i < listOfBooleans.size(); ++i){
//            if (listOfBooleans.get(i) == 1 ){
//                booleanSQL = booleanSQL.concat(singleValueslistOfSQLQuery.get(i) + listOfBooleans.get(i));
//
//                if ( i != listOfBooleans.size()-1){
//                    booleanSQL = booleanSQL.concat(" AND ");
//                } else {
//                    booleanSQL = booleanSQL.concat(")");
//                }
//            }
//        }
//
//        String intValuesSQL = "WHERE EmployerID IN ( SELECT e.EmployerID FROM Employer AS e WHERE e.StatusOfEmployerID = " + StatusOfEmployer;
//        if (NumberOfEmployees != 0){
//            intValuesSQL = intValuesSQL.concat(" AND e.NumberOfEmployeesID = " + NumberOfEmployees + " ));");
//        } else {
//            intValuesSQL = intValuesSQL.concat("));");
//        }
//
//        String SQL = finalSQL + booleanSQL + intValuesSQL;
//
        System.out.println(finalSQL);

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(finalSQL);
            while (rs.next()) {
                ids.add(rs.getInt("EmployerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
        }

        return ids;
    }


    //4. Get all Employer Ids and Names
    public List<Employer> getAllEmployerNamesAndIds() throws DataAccessException {
        String getQuery = "SELECT EmployerID, EmployerName  FROM Employer";
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
                employer.setEmployerName(rs.getString("EmployerName"));

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

    //5. Get Last Employer Created
    public Integer getLastEmployerCreated(String employerName) throws DataAccessException {
        String getQuery = String.format("SELECT EmployerID FROM Employer WHERE EmployerName = \"%s\" ORDER BY EmployerID DESC LIMIT 1", employerName);
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                employer = new Employer();
                employer.setEmployerID(rs.getInt("EmployerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return employer.getEmployerID();
    }


    //6. Get Possible Number of Employers
    public List<Employer> getAllNumberOfEmployersPossible() throws DataAccessException {
        String getQuery = "SELECT EmployeesRangeID, EmployeesRangeName FROM EmployeesRangeList";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setNumberOfEmployeesID(rs.getInt("EmployeesRangeID"));
                employer.setNumberOfEmployeesName(rs.getString("EmployeesRangeName"));

                list.add(employer);
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

    //7. Get All Possible Language List
    public List<Employer> getAllLanguages() throws DataAccessException {
        String getQuery = "SELECT LanguageID, LanguageName FROM LanguageList";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerLanguageID(rs.getInt("LanguageID"));
                employer.setEmployerLanguageName(rs.getString("LanguageName"));

                list.add(employer);
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

    //8. Get All Possible Local Authorities List
    public List<Employer> getAllLocalAuthorities() throws DataAccessException {
        String getQuery = "SELECT LocalAuthorityID, LocalAuthorityName FROM LocalAuthorityList";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerLocalAuthorityID(rs.getInt("LocalAuthorityID"));
                employer.setEmployerLocalAuthorityName(rs.getString("LocalAuthorityName"));

                list.add(employer);
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

    //9. Get All Possible Industry Sector List
    public List<Employer> getAllIndustrySectors() throws DataAccessException {
        String getQuery = "SELECT IndustrySectorID, IndustrySectorName FROM IndustrySectorList";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerIndustrySectorID(rs.getInt("IndustrySectorID"));
                employer.setEmployerIndustrySectorName(rs.getString("IndustrySectorName"));

                list.add(employer);
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

    //10. Get All Possible Curriculum Areas List
    public List<Employer> getAllCurriculumAreas() throws DataAccessException {
        String getQuery = "SELECT AreaOfCurriculumID, AreaOfCurriculumName FROM AreaOfCurriculumList";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerAreaOfCurriculumID(rs.getInt("AreaOfCurriculumID"));
                employer.setEmployAreaOfCurriculumName(rs.getString("AreaOfCurriculumName"));

                list.add(employer);
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

    //11. Get All Possible Cooperation Types
    public List<Employer> getAllCooperationTypes() throws DataAccessException {
        String getQuery = "SELECT CooperationTypeID, CooperationTypeName FROM CooperationTypeList";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerCooperationTypeID(rs.getInt("CooperationTypeID"));
                employer.setEmployerCooperationTypeName(rs.getString("CooperationTypeName"));

                list.add(employer);
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

    //12. Get All Possible Preferences
    public List<Employer> getAllPreferences() throws DataAccessException {
        String getQuery = "SELECT PreferenceID, PreferenceName FROM PreferenceList";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerPreferencesID(rs.getInt("PreferenceID"));
                employer.setEmployerPreferencesName(rs.getString("PreferenceName"));

                list.add(employer);
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

    //13. Get All Alumni
    public List<Employer> getAllAlumni() throws DataAccessException {
        String getQuery = "SELECT AlumniID, AlumniNameAndSurname, AlumniSchoolID  FROM Alumni";
        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setEmployerAlumniID(rs.getInt("AlumniID"));
                employer.setEmployerAlumniName(rs.getString("AlumniNameAndSurname"));

                list.add(employer);
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


    // 14. Get All Employer Names and Ids
    public List<Integer> getAllEmployerIDsAttendingEvent(int eventId) throws DataAccessException {
        String getQuery = String.format("SELECT EmployerID FROM INT_AttendingEmployerOnEvent WHERE EventID = \"%s\"", eventId);

        List<Integer> list = new ArrayList<Integer>();
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {

                list.add(rs.getInt("EmployerID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }

    // 15. Get All Employer Name Attending Specific event
    public List<String> getAllEmployerNamesAttendingEvent(List<Integer> employersID) throws DataAccessException {

        List<String> list = new ArrayList<String>();

        for (Integer employer : employersID) {
            String getQuery = String.format("SELECT EmployerName FROM Employer WHERE EmployerID = \"%s\"", employer);


            ResultSet rs = null;
            try {
                connection = ConnectionFactory.getConnection();
                statement = connection.createStatement();
                rs = statement.executeQuery(getQuery);
                while (rs.next()) {
                    String employerName;
                    employerName = rs.getString("EmployerName");

                    list.add(employerName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(rs);
                DBUtil.close(statement);
                DBUtil.close(connection);
            }
        }
        return list;
    }

    // 16. Get All Employer Status
    public List<Employer> getAllEmployerStatus() throws DataAccessException {

        String getQuery = String.format("SELECT StatusOfEmployerID, StatusOfEmployerName  FROM StatusOfEmployerList");

        List<Employer> list = new ArrayList<Employer>();
        Employer employer = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(getQuery);
            while (rs.next()) {
                employer = new Employer();
                employer.setStatusOfEmployerID(rs.getInt("StatusOfEmployerID"));
                employer.setStatusOfEmployerName(rs.getString("StatusOfEmployerName"));

                list.add(employer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(statement);
            DBUtil.close(connection);
        }
        return list;
    }


    ///////////////////////////////////// CREATE ALL METHODS ///////////////////////////////////////////////
    //17. Create New Employer

//    public int createEmployer(int statusOfEmployer, String Name, String AddressCity, String AddressStreet, String AddressNumber,
//                                 String Postcode, String email, String phone, String website, int numberOfEmployees, String companySummary,
//                                 String notes, String LogoLink, Boolean givesSiteExperience, Boolean givesSiteVisits,
//                                 Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils,
//                                 Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramme,
//                                 int schoolPreferences) throws DataAccessException {
//
//        String insertSql = "INSERT INTO Employer Employer(statusOfEmployer, Name, AddressCity, AddressStreet, AddressNumber," +
//                "                                   Postcode, email, phone, website, numberOfEmployees,  companySummary, notes, LogoLink, " +
//                "                                   Logo, givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs," +
//                "                                   givesWebinars,  worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh," +
//                "                                   hasApprenticeshipProgramme, schoolPreferences)" +
//                "                                  VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        return jdbcTemplate().update(insertSql, statusOfEmployer, Name, AddressCity, AddressStreet, AddressNumber,
//                Postcode, email, phone, website, numberOfEmployees, companySummary, notes, LogoLink,
//                givesSiteExperience, givesSiteVisits, givesWorkshops, givesPresentations, attendsCareerFairs,
//                givesWebinars, worksWithPrimaryPupils, useOfModernForeignLanguage, runsBusinessInWelsh, canDeliverToSchoolsInWelsh,
//                hasApprenticeshipProgramme, schoolPreferences);
//
//    }

    // 18. Create a new Employer / version 1 not complete
    public int createEmployer(int StatusOfEmployerID,  String EmployerName, String EmployerAddressCity, String EmployerAddressStreet, String EmployerAddressNumber,
                              String EmployerPostcode, String EmployerEmail, String ContactPersonNameSurname, String ContactPersonPosition, String EmployerPhone,
                              String EmployerTwitter, String EmployerFB, String EmployerWebsite, int NumberOfEmployeesID, String CompanySummary,
                              String Notes) throws DataAccessException {

        String insertSql = "INSERT INTO Employer(StatusOfEmployerID, EmployerName, EmployerAddressCity, EmployerAddressStreet, EmployerAddressNumber, EmployerPostcode," +
                " EmployerEmail,ContactPersonNameSurname,ContactPersonPosition, EmployerPhone, EmployerWebsite, EmployerTwitter, EmployerFB, NumberOfEmployeesID," +
                "  CompanySummary, Notes)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate().update(insertSql,StatusOfEmployerID, EmployerName, EmployerAddressCity, EmployerAddressStreet, EmployerAddressNumber,
                EmployerPostcode, EmployerEmail, ContactPersonNameSurname, ContactPersonPosition, EmployerPhone, EmployerWebsite,
                EmployerTwitter, EmployerFB, NumberOfEmployeesID, CompanySummary, Notes);
    }


    // 19. Create new Employer / Cooperation Type Intersection
    public void updateEmployerCooperationIntersection(int EmployerID, List<Integer> CooperationTypeID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_EmployerCooperationType(EmployerID, CooperationTypeID) VALUE(?,?)";

        for (Integer cooperationTypeId : CooperationTypeID ){
            jdbcTemplate().update(updateSql, EmployerID, cooperationTypeId);
        };
    }

    // 20. Create new Employer / Industry Sector
    public void updateEmployerIndustrySectorIntersection(int EmployerID, List<Integer> IndustrySectorID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_EmployerIndustrySector(EmployerID, IndustrySectorID) VALUES(?,?)";

        for (Integer industrySectorId : IndustrySectorID) {
            jdbcTemplate().update(updateSql, EmployerID, industrySectorId);
        }
    }


    // 21. Create new Employer / Preference
    public void updateEmployerPreferencesIntersection(int EmployerID, List<Integer> PreferenceID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_EmployerPreference(EmployerID, PreferenceID) VALUE(?,?)";

        for (Integer preferencesId : PreferenceID ){
            jdbcTemplate().update(updateSql, EmployerID, preferencesId);
        };
    }

    // 22. Create new Employer / School Preference
    public void updateSchoolEmployerSchoolPreferencesIntersection(int EmployerID, List<Integer> SchoolID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_EmployerSchoolPreference(EmployerID, SchoolID) VALUES(?,?)";

        for (Integer schoolId : SchoolID) {
            jdbcTemplate().update(updateSql, EmployerID, schoolId);
        }
    };

    // 23. Create new Employer / Curriculum Area
    public void updateEmployerEmployerCurriculumAreaIntersection(int EmployerID, List<Integer> AreaOfCurriculumID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_EmployerSupportOfAreaOfCurriculum(EmployerID, AreaOfCurriculumID) VALUE(?,?)";

        for (Integer areaOfCurriculumId : AreaOfCurriculumID ){
            jdbcTemplate().update(updateSql, EmployerID, areaOfCurriculumId);
        };
    }

    // 24. Create new Employer / Language
    public void updateSchoolEmployerLanguageIntersection(int EmployerID, List<Integer> LanguageID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_LanguageUsedByEmployer(EmployerID, LanguageID) VALUES(?,?)";

        for (Integer languageId : LanguageID) {
            jdbcTemplate().update(updateSql, EmployerID, languageId);
        }
    }

    // 24. Create new Employer / Local Authorities
    public void updateSchoolEmployerLocalAuthoritiesIntersection(int EmployerID, List<Integer> LocalAuthorityID) throws DataAccessException {

        String updateSql = "INSERT INTO INT_LocalAuthorityEmployerCanWorkWith(EmployerID, LocalAuthorityID) VALUES(?,?)";

        for (Integer localAuthoritiesId : LocalAuthorityID) {
            jdbcTemplate().update(updateSql, EmployerID, localAuthoritiesId);
        }
    }







    ///////////////////////////////////// UPDATE ALL METHODS ///////////////////////////////////////////////
    //19. Update Employer by Id
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
    //20. DELETE EMPLOYER by Id
    public Integer deleteEmployer(int employerId) throws DataAccessException {
        String deleteSql = String.format("DELETE FROM Employer WHERE EmployerID = '%s'",employerId);
        return jdbcTemplate().update(deleteSql);
    }

}
