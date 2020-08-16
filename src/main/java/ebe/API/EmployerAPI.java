package ebe.API;

import ebe.DBMethods.EmployerQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployerAPI {

    private EmployerQueries employerQueries;

    @Autowired
    public EmployerAPI(EmployerQueries em){
        employerQueries = em;
    }

    //1. Create Employer
    @GetMapping(value="/api/create/employer")
    public boolean createEmployer(
            @RequestParam(name="StatusOfEmployerID") int statusOfEmployerID,
            @RequestParam(name="EmployerName") String employerName,
            @RequestParam(name="EmployerSummary") String companySummary,
            @RequestParam(name="EmployerAddressCity") String employerAddressCity,
            @RequestParam(name="EmployerAddressStreet") String employerAddressStreet,
            @RequestParam(name="EmployerAddressNumber") String employerAddressNumber,
            @RequestParam(name="EmployerPostcode") String employerPostcode,
            @RequestParam(name="EmployerEmail") String employerEmail,
            @RequestParam(name="ContactPersonNameSurname") String contactPersonNameSurname,
            @RequestParam(name="ContactPersonPosition") String contactPersonPosition,
            @RequestParam(name="EmployerPhone") String employerPhone,
            @RequestParam(name="EmployerWebsite") String  employerWebsite,
            @RequestParam(name="EmployerTwitter") String employerTwitter,
            @RequestParam(name="EmployerFB") String employerFB,
            @RequestParam(name="NumberOfEmployeesID") int numberOfEmployeesID,
            @RequestParam(name="EmployerNotes") String employerNotes,
//            @RequestParam(name="LogoLink") String logoLink,
            @RequestParam(name="EmployerSectorIndustry") String employerSectorIndustry,
            @RequestParam(name="EmployerCooperationType") String employerCooperationType,
            @RequestParam(name="EmployerCurriculumAreas") String employerCurriculumAreas,
            @RequestParam(name="EmployerPreferences") String employerPreferences,
            @RequestParam(name="EmployerLanguage") String employerLanguage,
            @RequestParam(name="SchoolPreferences") String schoolPreferences,
            @RequestParam(name="LocalAuthorities") String localAuthorities) throws ParseException {

        // ---------------------------
        //1. Create the ArrayList that are going to be used to populate the database
        ArrayList<Integer> employerCooperationTypeList = new ArrayList<>();
        ArrayList<Integer> employerIndustrySectorList = new ArrayList<>();
        ArrayList<Integer> employerPreferencesList = new ArrayList<>();
        ArrayList<Integer> employerSupportCurriculumAreaList = new ArrayList<>();
        ArrayList<Integer> employerLanguageUsedList = new ArrayList<>();
        ArrayList<Integer> employerLocalAuthorityList = new ArrayList<>();
        ArrayList<Integer> employerSchoolPreferencesList = new ArrayList<>();

        // ---------------------------
        //2. Populate the ArrayList
        if(employerCooperationType.length() != 0){
            for (String employerID : employerCooperationType.split(",")) {
                employerCooperationTypeList.add(Integer.parseInt(employerID));
            }
        }
        if(employerSectorIndustry.length() != 0){
            for (String employerID : employerSectorIndustry.split(",")) {
                employerIndustrySectorList.add(Integer.parseInt(employerID));
            }
        }
        if(employerPreferences.length() != 0){
            for (String employerID : employerPreferences.split(",")) {
                employerPreferencesList.add(Integer.parseInt(employerID));
            }
        }

        if(employerCurriculumAreas.length() != 0){
            for (String employerID : employerCurriculumAreas.split(",")) {
                employerSupportCurriculumAreaList.add(Integer.parseInt(employerID));
            }
        }

        if(employerLanguage.length() != 0) {
            for (String empID : employerLanguage.split(",")) {
                employerLanguageUsedList.add(Integer.parseInt(empID));
            }
        }

        if(schoolPreferences.length() != 0){
            for (String empID : schoolPreferences.split(",")) {
                employerSchoolPreferencesList.add(Integer.parseInt(empID));
            }
        }

        if(localAuthorities.length() != 0){
            for (String empID : localAuthorities.split(",")) {
                employerLocalAuthorityList.add(Integer.parseInt(empID));
            }
        }

        // ---------------------------
        //3. Create the Employer
        int createVal = employerQueries.createEmployer(statusOfEmployerID,employerName,employerAddressCity,employerAddressStreet,employerAddressNumber,
                employerPostcode,employerEmail,contactPersonNameSurname,contactPersonPosition,employerPhone,employerWebsite,
                employerTwitter, employerFB,numberOfEmployeesID,companySummary,employerNotes);

        // ---------------------------
        //4. Get Employer Created Id
        int employerID = employerQueries.getLastEmployerCreated(employerName);

        // ---------------------------
        //5. Fill Intersections

        //     5.1. Intersection Table - Employer / Cooperation Type
        if(employerCooperationType.length() != 0) {
            employerQueries.createEmployerCooperationIntersection(employerID, employerCooperationTypeList);
        }

        //     5.2. Intersection Table - Employer / Industry Sector
        if(employerSectorIndustry.length() != 0) {
            employerQueries.createEmployerIndustrySectorIntersection(employerID, employerIndustrySectorList);
        }

        //     5.3. Intersection Table - Employer / Preferences
        if(employerPreferences.length() != 0) {
            employerQueries.createEmployerPreferencesIntersection(employerID, employerPreferencesList);
        }

        //     5.4. Intersection Table - Employer / School Preferences
        if(schoolPreferences.length() != 0) {
            employerQueries.createSchoolEmployerSchoolPreferencesIntersection(employerID, employerSchoolPreferencesList);
        }

        //     5.5. Intersection Table - Employer / Support of Area of Curriculum
        if(employerCurriculumAreas.length() != 0) {
            employerQueries.createEmployerEmployerCurriculumAreaIntersection(employerID, employerSupportCurriculumAreaList);
        }

        //     5.6. Intersection Table - Employer / Language Used
        if(employerLanguage.length() != 0) {
            employerQueries.createSchoolEmployerLanguageIntersection(employerID, employerLanguageUsedList);
        }

        //     5.7. Intersection Table - Employer / Local Authority
        if(localAuthorities.length() != 0) {
            employerQueries.createSchoolEmployerLocalAuthoritiesIntersection(employerID, employerLocalAuthorityList);
        }
        return createVal == 1;
    }


    //2. Update Employer
    @GetMapping(value="/api/update/employer")
    public boolean updateEmployer(
            @RequestParam(name="EmployerID") int employerID,
            @RequestParam(name="StatusOfEmployerID") int statusOfEmployerID,
            @RequestParam(name="EmployerName") String employerName,
            @RequestParam(name="EmployerSummary") String companySummary,
            @RequestParam(name="EmployerAddressCity") String employerAddressCity,
            @RequestParam(name="EmployerAddressStreet") String employerAddressStreet,
            @RequestParam(name="EmployerAddressNumber") String employerAddressNumber,
            @RequestParam(name="EmployerPostcode") String employerPostcode,
            @RequestParam(name="EmployerEmail") String employerEmail,
            @RequestParam(name="ContactPersonNameSurname") String contactPersonNameSurname,
            @RequestParam(name="ContactPersonPosition") String contactPersonPosition,
            @RequestParam(name="EmployerPhone") String employerPhone,
            @RequestParam(name="EmployerWebsite") String  employerWebsite,
            @RequestParam(name="EmployerTwitter") String employerTwitter,
            @RequestParam(name="EmployerFB") String employerFB,
            @RequestParam(name="NumberOfEmployeesID") int numberOfEmployeesID,
            @RequestParam(name="EmployerNotes") String employerNotes,
//            @RequestParam(name="LogoLink") String LogoLink,
            @RequestParam(name="EmployerSectorIndustry") String employerSectorIndustry,
            @RequestParam(name="EmployerCooperationType") String employerCooperationType,
            @RequestParam(name="EmployerCurriculumAreas") String employerCurriculumAreas,
            @RequestParam(name="EmployerPreferences") String employerPreferences,
            @RequestParam(name="EmployerLanguage") String employerLanguage,
            @RequestParam(name="SchoolPreferences") String schoolPreferences,
            @RequestParam(name="LocalAuthorities") String localAuthorities,
            @RequestParam(name="CreateEmployerAlumniName", required = false) String createEmployerAlumniName,
            @RequestParam(name="CreateEmployerAlumniSchoolID", required = false) String createEmployerAlumniSchoolID,
            @RequestParam(name="UpdateEmployerAlumniID", required = false) String updateEmployerAlumniID,
            @RequestParam(name="UpdateEmployerAlumniName", required = false) String updateEmployerAlumniName,
            @RequestParam(name="UpdateEmployerAlumniSchoolID", required = false) String updateEmployerAlumniSchoolID) throws ParseException {

        // ---------------------------
        //1. Create the ArrayList that are going to be used to populate the database
        ArrayList<Integer> employerCooperationTypeList = new ArrayList<>();
        ArrayList<Integer> employerIndustrySectorList = new ArrayList<>();
        ArrayList<Integer> employerPreferencesList = new ArrayList<>();
        ArrayList<Integer> employerSupportCurriculumAreaList = new ArrayList<>();
        ArrayList<Integer> employerLanguageUsedList = new ArrayList<>();
        ArrayList<Integer> employerLocalAuthorityList = new ArrayList<>();
        ArrayList<Integer> employerSchoolPreferencesList = new ArrayList<>();
        ArrayList<String> createEmployerAlumniNameList = new ArrayList<>();
        ArrayList<Integer> createEmployerAlumniSchoolIDList = new ArrayList<>();
        ArrayList<Integer> updateEmployerAlumniIDList = new ArrayList<>();
        ArrayList<String> updateEmployerAlumniNameList = new ArrayList<>();
        ArrayList<Integer> updateEmployerAlumniSchoolIDList = new ArrayList<>();

        // ---------------------------
        //2. Populate the ArrayList
         if(employerCooperationType.length() != 0){
            for (String empID : employerCooperationType.split(",")) {
                employerCooperationTypeList.add(Integer.parseInt(empID));
            }
        }
        if(employerSectorIndustry.length() != 0){
            for (String empID : employerSectorIndustry.split(",")) {
                employerIndustrySectorList.add(Integer.parseInt(empID));
            }
        }
        if(employerPreferences.length() != 0){
            for (String empID : employerPreferences.split(",")) {
            employerPreferencesList.add(Integer.parseInt(empID));
            }
        }

        if(employerCurriculumAreas.length() != 0){
            for (String empID : employerCurriculumAreas.split(",")) {
                employerSupportCurriculumAreaList.add(Integer.parseInt(empID));
            }
        }

        if(schoolPreferences.length() != 0){
            for (String empID : schoolPreferences.split(",")) {
                employerSchoolPreferencesList.add(Integer.parseInt(empID));
            }
        }

        if(employerLanguage.length() != 0) {
            for (String empID : employerLanguage.split(",")) {
                employerLanguageUsedList.add(Integer.parseInt(empID));
            }
        }
        if(localAuthorities.length() != 0){
            for (String empID : localAuthorities.split(",")) {
                employerLocalAuthorityList.add(Integer.parseInt(empID));
            }
        }

        if(createEmployerAlumniName.length() != 0) {
            for (String empID : createEmployerAlumniName.split(",")) {
                createEmployerAlumniNameList.add(empID);
            }
        }
        if(!createEmployerAlumniSchoolID.equals("")){
            for (String empID : createEmployerAlumniSchoolID.split(",")) {
                createEmployerAlumniSchoolIDList.add(Integer.parseInt(empID));
            }
        }

        if(!updateEmployerAlumniID.equals("")) {
            for (String empID : updateEmployerAlumniID.split(",")) {
                updateEmployerAlumniIDList.add(Integer.parseInt(empID));
            }
        }

        if(!updateEmployerAlumniName.equals("")) {
            for (String empID : updateEmployerAlumniName.split(",")) {
                updateEmployerAlumniNameList.add(empID);
            }
        }

        if(!updateEmployerAlumniSchoolID.equals("")){
            for (String empID : updateEmployerAlumniSchoolID.split(",")) {
                updateEmployerAlumniSchoolIDList.add(Integer.parseInt(empID));
            }
        }

        // ---------------------------
        //3. Update the Employer
        int updateVal = employerQueries.updateEmployer(employerID,statusOfEmployerID,employerName,employerAddressCity,employerAddressStreet,employerAddressNumber,
                employerPostcode,employerEmail,contactPersonNameSurname,contactPersonPosition,employerPhone,employerWebsite,
                employerTwitter, employerFB,numberOfEmployeesID,companySummary,employerNotes);

        // ---------------------------
        //4. Fill Intersections

        //     4.1. Intersection Table - Employer / Cooperation Type
        if(employerCooperationType.length() != 0) {
            employerQueries.updateEmployerCooperationIntersection(employerID, employerCooperationTypeList);
        }

        //     4.2. Intersection Table - Employer / Industry Sector
        if(employerSectorIndustry.length() != 0) {
            employerQueries.updateEmployerIndustrySectorIntersection(employerID, employerIndustrySectorList);
        }

        //     4.3. Intersection Table - Employer / Preferences
        if(employerPreferences.length() != 0) {
            employerQueries.updateEmployerPreferencesIntersection(employerID, employerPreferencesList);
        }

        //     4.4. Intersection Table - Employer / School Preferences
        if(schoolPreferences.length() != 0) {
            employerQueries.updateSchoolEmployerSchoolPreferencesIntersection(employerID, employerSchoolPreferencesList);
        }

        //     4.5. Intersection Table - Employer / Support of Area of Curriculum
        if(employerCurriculumAreas.length() != 0) {
            employerQueries.updateEmployerEmployerCurriculumAreaIntersection(employerID, employerSupportCurriculumAreaList);
        }

        //     4.6. Intersection Table - Employer / Language Used
        if(employerLanguage.length() != 0) {
            employerQueries.updateSchoolEmployerLanguageIntersection(employerID, employerLanguageUsedList);
        }

         //     4.7. Intersection Table - Employer / Local Authority
        if(localAuthorities.length() != 0) {
            employerQueries.updateSchoolEmployerLocalAuthoritiesIntersection(employerID, employerLocalAuthorityList);
        }

        //      4.8.  Update Alumni
        if(!updateEmployerAlumniIDList.isEmpty()) {
            employerQueries.updateAlumni(updateEmployerAlumniNameList, updateEmployerAlumniSchoolIDList, updateEmployerAlumniIDList);
        }

        if(createEmployerAlumniName.length()!=0) {
            //      4.9.  Create Alumni
            employerQueries.createAlumni(createEmployerAlumniNameList, createEmployerAlumniSchoolIDList);
            //      4.10.  Get Alumni IDs
            List<Integer> alumniIdList = employerQueries.getAllAlumniIDFromEmployer(createEmployerAlumniNameList, createEmployerAlumniSchoolIDList);
            //      4.11.  Create Intersection Table - Employer / Alumni
            employerQueries.createEmployerAlumniIntersection(employerID, alumniIdList);
        }

        return updateVal == 1;
    }

    //3. Delete Employer
    @DeleteMapping("api/delete/employer")
    public boolean deleteEmployers(@RequestParam(value="employerId") Integer employerId){
        if (employerQueries.deleteEmployer(employerId) == 1) {
            return true;
        } else {
            return false;
        }
    }

    //4. Delete Alumni
    @DeleteMapping("/api/delete/employer/alumni")
    public boolean deleteAlumni(@RequestParam(value="alumniID") Integer alumniID){
        if (employerQueries.deleteAlumni(alumniID) == 1) {
            return true;
        } else {
            return false;
        }
    }

    ///////////////////////    FILTER     ////////////////////////////////
    @RequestMapping("api/filter/employer")
    public List<Integer> filterEmployers(@RequestParam(name="EmployerSectorIndustry") String EmployerSectorIndustry,
                                         @RequestParam(name="EmployerCooperationType") String EmployerCooperationType,
                                         @RequestParam(name="EmployerCurriculumAreas") String EmployerCurriculumAreas,
                                         @RequestParam(name="EmployerPreferences") String EmployerPreferences,
                                         @RequestParam(name="EmployerLanguage") String EmployerLanguage,
                                         @RequestParam(name="SchoolPreferences") String SchoolPreferences,
                                         @RequestParam(name="LocalAuthorities") String LocalAuthorities){

        List<Integer> filteredEmployerIDs = new ArrayList<Integer>();

        List<Integer> employerCooperationTypeList = new ArrayList<Integer>();
        List<Integer> employerIndustrySectorList = new ArrayList<Integer>();
        List<Integer> employerPreferencesList = new ArrayList<Integer>();
        List<Integer> employerSupportCurriculumAreaList = new ArrayList<Integer>();
        List<Integer> employerLanguageUsedList = new ArrayList<Integer>();
        List<Integer> employerLocalAuthorityList = new ArrayList<Integer>();
        List<Integer> employerSchoolPreferencesList = new ArrayList<Integer>();

        if (!EmployerCooperationType.equals("")) {
            for (String cooperationTypeID : EmployerCooperationType.split(",")) {
                employerCooperationTypeList.add(Integer.parseInt(cooperationTypeID));
            }
        }  else{
            employerCooperationTypeList = Arrays.asList();
        }

        if (!EmployerSectorIndustry.equals("")) {
            for (String sectorIndustryID : EmployerSectorIndustry.split(",")) {
                employerIndustrySectorList.add(Integer.parseInt(sectorIndustryID));
            }
        } else {
            employerIndustrySectorList = Arrays.asList();
        }

        if (!EmployerPreferences.equals("")) {
            for (String employerPreferenceID : EmployerPreferences.split(",")) {
                employerPreferencesList.add(Integer.parseInt(employerPreferenceID));
            }
        } else {
            employerPreferencesList = Arrays.asList();
        }

        if (!EmployerCurriculumAreas.equals("")) {
            for (String areaOfCurriculumID : EmployerCurriculumAreas.split(",")) {
                employerSupportCurriculumAreaList.add(Integer.parseInt(areaOfCurriculumID));
            }
        } else {
            employerSupportCurriculumAreaList = Arrays.asList();
        }

        if (!EmployerLanguage.equals("")) {
            for (String languageID : EmployerLanguage.split(",")) {
                employerLanguageUsedList.add(Integer.parseInt(languageID));
            }
        } else {
            employerLanguageUsedList = Arrays.asList();
        }

        if (!LocalAuthorities.equals("")) {
            for (String localAuthorityID : LocalAuthorities.split(",")) {
                employerLocalAuthorityList.add(Integer.parseInt(localAuthorityID));
            }
        } else {
            employerLocalAuthorityList = Arrays.asList();
        }

        if (!SchoolPreferences.equals("")) {
            for (String schoolID : SchoolPreferences.split(",")) {
                employerSchoolPreferencesList.add(Integer.parseInt(schoolID));
            }
        } else {
            employerSchoolPreferencesList = Arrays.asList();
        }

        // There should be AlumniList as well, once implemented. In function below I call empty Arrays.asList() to fill this place.

        filteredEmployerIDs = employerQueries.getFilteredEmployersIds(employerIndustrySectorList, employerLocalAuthorityList,
                employerSupportCurriculumAreaList, employerLanguageUsedList,
                employerSchoolPreferencesList, employerPreferencesList, employerCooperationTypeList, Arrays.asList());



        return filteredEmployerIDs;

    }


}
