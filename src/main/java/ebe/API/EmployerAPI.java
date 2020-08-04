package ebe.API;

import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.SchoolQueries;
import ebe.DBMethods.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



@RestController
public class EmployerAPI {
    private EmployerQueries EmployerQrys;
    private EventQueries EventQrys;
    private SchoolQueries SchoolQrys;
    private VacancyQueries VacancyQrys;

    @Autowired
    public EmployerAPI(EmployerQueries em, EventQueries ev, SchoolQueries sc, VacancyQueries va){
        EmployerQrys = em;
        EventQrys = ev;
        SchoolQrys = sc;
        VacancyQrys = va;
    }


    ///////////////////////    CREATE     ////////////////////////////////
    //1. Create Employer
    @RequestMapping(value="/api/create/employer", method= RequestMethod.GET)
    public boolean createEmployer(
            @RequestParam(name="StatusOfEmployerID") int StatusOfEmployerID,
            @RequestParam(name="EmployerName") String EmployerName,
            @RequestParam(name="EmployerSummary") String CompanySummary,
            @RequestParam(name="EmployerAddressCity") String EmployerAddressCity,
            @RequestParam(name="EmployerAddressStreet") String EmployerAddressStreet,
            @RequestParam(name="EmployerAddressNumber") String EmployerAddressNumber,
            @RequestParam(name="EmployerPostcode") String EmployerPostcode,
            @RequestParam(name="EmployerEmail") String EmployerEmail,
            @RequestParam(name="ContactPersonNameSurname") String ContactPersonNameSurname,
            @RequestParam(name="ContactPersonPosition") String ContactPersonPosition,
            @RequestParam(name="EmployerPhone") String EmployerPhone,
            @RequestParam(name="EmployerWebsite") String  EmployerWebsite,
            @RequestParam(name="EmployerTwitter") String EmployerTwitter,
            @RequestParam(name="EmployerFB") String EmployerFB,
            @RequestParam(name="NumberOfEmployeesID") int NumberOfEmployeesID,

            @RequestParam(name="EmployerNotes") String EmployerNotes,
//            @RequestParam(name="LogoLink") String LogoLink,
            @RequestParam(name="EmployerSectorIndustry") String EmployerSectorIndustry,
            @RequestParam(name="EmployerCooperationType") String EmployerCooperationType,
            @RequestParam(name="EmployerCurriculumAreas") String EmployerCurriculumAreas,
            @RequestParam(name="EmployerPreferences") String EmployerPreferences,
            @RequestParam(name="EmployerLanguage") String EmployerLanguage,
            @RequestParam(name="SchoolPreferences") String SchoolPreferences,
            @RequestParam(name="LocalAuthorities") String LocalAuthorities) throws ParseException {

        ArrayList<Integer> employerCooperationTypeList = new ArrayList<Integer>();
        ArrayList<Integer> employerIndustrySectorList = new ArrayList<Integer>();
        ArrayList<Integer> employerPreferencesList = new ArrayList<Integer>();
        ArrayList<Integer> employerSupportCurriculumAreaList = new ArrayList<Integer>();
        ArrayList<Integer> employerLanguageUsedList = new ArrayList<Integer>();
        ArrayList<Integer> employerLocalAuthorityList = new ArrayList<Integer>();
        ArrayList<Integer> employerSchoolPreferencesList = new ArrayList<Integer>();

        if(EmployerCooperationType.length() != 0){
            for (String employerID : EmployerCooperationType.split(",")) {
                employerCooperationTypeList.add(Integer.parseInt(employerID));
            }
        }
        if(EmployerSectorIndustry.length() != 0){
            for (String employerID : EmployerSectorIndustry.split(",")) {
                employerIndustrySectorList.add(Integer.parseInt(employerID));
            }
        }
        if(EmployerPreferences.length() != 0){
            for (String employerID : EmployerPreferences.split(",")) {
                employerPreferencesList.add(Integer.parseInt(employerID));
            }
        }

        if(EmployerCurriculumAreas.length() != 0){
            for (String employerID : EmployerCurriculumAreas.split(",")) {
                employerSupportCurriculumAreaList.add(Integer.parseInt(employerID));
            }
        }

        //Create the Employer
        EmployerQrys.createEmployer(StatusOfEmployerID,EmployerName,EmployerAddressCity,EmployerAddressStreet,EmployerAddressNumber,
                EmployerPostcode,EmployerEmail,ContactPersonNameSurname,ContactPersonPosition,EmployerPhone,EmployerWebsite,
                EmployerTwitter, EmployerFB,NumberOfEmployeesID,CompanySummary,EmployerNotes);

        //      Get Employer Created Id
        int EmployerID = EmployerQrys.getLastEmployerCreated(EmployerName);

        //     1. Intersection Table - Employer / Cooperation Type
        if(EmployerCooperationType.length() != 0) {
            EmployerQrys.createEmployerCooperationIntersection(EmployerID, employerCooperationTypeList);
        }

        //     2. Intersection Table - Employer / Industry Sector
        if(EmployerSectorIndustry.length() != 0) {
            EmployerQrys.createEmployerIndustrySectorIntersection(EmployerID, employerIndustrySectorList);
        }

        //     3. Intersection Table - Employer / Preferences
        if(EmployerPreferences.length() != 0) {
            EmployerQrys.createEmployerPreferencesIntersection(EmployerID, employerPreferencesList);
        }

        //     4. Intersection Table - Employer / School Preferences
        if(SchoolPreferences.length() != 0) {
            EmployerQrys.createSchoolEmployerSchoolPreferencesIntersection(EmployerID, employerSchoolPreferencesList);
        }

        //     5. Intersection Table - Employer / Support of Area of Curriculum
        if(EmployerCurriculumAreas.length() != 0) {
            EmployerQrys.createEmployerEmployerCurriculumAreaIntersection(EmployerID, employerSupportCurriculumAreaList);
        }

        //     6. Intersection Table - Employer / Language Used
        if(EmployerLanguage.length() != 0) {
            EmployerQrys.createSchoolEmployerLanguageIntersection(EmployerID, employerLanguageUsedList);
        }

        //     7. Intersection Table - Employer / Local Authority
        if(LocalAuthorities.length() != 0) {
            EmployerQrys.createSchoolEmployerLocalAuthoritiesIntersection(EmployerID, employerLocalAuthorityList);
        }
        return true;
    }


    ///////////////////////    CREATE     ////////////////////////////////
    //1. Create Employer
    @RequestMapping(value="/api/update/employer", method= RequestMethod.GET)
    public boolean updateEmployer(
            @RequestParam(name="EmployerID") int EmployerID,
            @RequestParam(name="StatusOfEmployerID") int StatusOfEmployerID,
            @RequestParam(name="EmployerName") String EmployerName,
            @RequestParam(name="EmployerSummary") String CompanySummary,
            @RequestParam(name="EmployerAddressCity") String EmployerAddressCity,
            @RequestParam(name="EmployerAddressStreet") String EmployerAddressStreet,
            @RequestParam(name="EmployerAddressNumber") String EmployerAddressNumber,
            @RequestParam(name="EmployerPostcode") String EmployerPostcode,
            @RequestParam(name="EmployerEmail") String EmployerEmail,
            @RequestParam(name="ContactPersonNameSurname") String ContactPersonNameSurname,
            @RequestParam(name="ContactPersonPosition") String ContactPersonPosition,
            @RequestParam(name="EmployerPhone") String EmployerPhone,
            @RequestParam(name="EmployerWebsite") String  EmployerWebsite,
            @RequestParam(name="EmployerTwitter") String EmployerTwitter,
            @RequestParam(name="EmployerFB") String EmployerFB,
            @RequestParam(name="NumberOfEmployeesID") int NumberOfEmployeesID,

            @RequestParam(name="EmployerNotes") String EmployerNotes,
//            @RequestParam(name="LogoLink") String LogoLink,
            @RequestParam(name="EmployerSectorIndustry") String EmployerSectorIndustry,
            @RequestParam(name="EmployerCooperationType") String EmployerCooperationType,
            @RequestParam(name="EmployerCurriculumAreas") String EmployerCurriculumAreas,
            @RequestParam(name="EmployerPreferences") String EmployerPreferences,
            @RequestParam(name="EmployerLanguage") String EmployerLanguage,
            @RequestParam(name="SchoolPreferences") String SchoolPreferences,
            @RequestParam(name="LocalAuthorities") String LocalAuthorities,
            @RequestParam(name="CreateEmployerAlumniName", required = false) String CreateEmployerAlumniName,
            @RequestParam(name="CreateEmployerAlumniSchoolID", required = false) String CreateEmployerAlumniSchoolID,
            @RequestParam(name="UpdateEmployerAlumniID", required = false) String UpdateEmployerAlumniID,
            @RequestParam(name="UpdateEmployerAlumniName", required = false) String UpdateEmployerAlumniName,
            @RequestParam(name="UpdateEmployerAlumniSchoolID", required = false) String UpdateEmployerAlumniSchoolID) throws ParseException {

        System.out.println("-------------------------------------------------");
        System.out.println("esi: " + EmployerSectorIndustry + "ect: " + EmployerCooperationType + " eca: " + EmployerCurriculumAreas
        + " ep: " +EmployerPreferences
        + " el: " + EmployerLanguage + " sp: " + SchoolPreferences + " la: " + LocalAuthorities );

        ArrayList<Integer> employerCooperationTypeList = new ArrayList<Integer>();
        ArrayList<Integer> employerIndustrySectorList = new ArrayList<Integer>();
        ArrayList<Integer> employerPreferencesList = new ArrayList<Integer>();
        ArrayList<Integer> employerSupportCurriculumAreaList = new ArrayList<Integer>();
        ArrayList<Integer> employerLanguageUsedList = new ArrayList<Integer>();
        ArrayList<Integer> employerLocalAuthorityList = new ArrayList<Integer>();
        ArrayList<Integer> employerSchoolPreferencesList = new ArrayList<Integer>();
        ArrayList<String> createEmployerAlumniNameList = new ArrayList<String>();
        ArrayList<Integer> createEmployerAlumniSchoolIDList = new ArrayList<Integer>();
        ArrayList<Integer> updateEmployerAlumniIDList = new ArrayList<Integer>();
        ArrayList<String> updateEmployerAlumniNameList = new ArrayList<String>();
        ArrayList<Integer> updateEmployerAlumniSchoolIDList = new ArrayList<Integer>();

        if(EmployerCooperationType.length() != 0){
            for (String employerID : EmployerCooperationType.split(",")) {
                employerCooperationTypeList.add(Integer.parseInt(employerID));
            }
        }
        if(EmployerSectorIndustry.length() != 0){
            for (String employerID : EmployerSectorIndustry.split(",")) {
                employerIndustrySectorList.add(Integer.parseInt(employerID));
            }
        }
        if(EmployerPreferences.length() != 0){
            for (String employerID : EmployerPreferences.split(",")) {
            employerPreferencesList.add(Integer.parseInt(employerID));
            }
        }

        if(EmployerCurriculumAreas.length() != 0){
            for (String employerID : EmployerCurriculumAreas.split(",")) {
                employerSupportCurriculumAreaList.add(Integer.parseInt(employerID));
            }
        }

        if(SchoolPreferences.length() != 0){
            for (String employerID : SchoolPreferences.split(",")) {
                employerSchoolPreferencesList.add(Integer.parseInt(employerID));
            }
        }
        System.out.println(employerSchoolPreferencesList);
        if(EmployerLanguage.length() != 0) {
            for (String employerID : EmployerLanguage.split(",")) {
                employerLanguageUsedList.add(Integer.parseInt(employerID));
            }
        }
        if(LocalAuthorities.length() != 0){
            for (String employerID : LocalAuthorities.split(",")) {
                employerLocalAuthorityList.add(Integer.parseInt(employerID));
            }
        }

        if(CreateEmployerAlumniName.length() != 0) {
            for (String employerID : CreateEmployerAlumniName.split(",")) {
                createEmployerAlumniNameList.add(employerID);
                System.out.println(createEmployerAlumniNameList);
            }
        }
        System.out.println("Lengh e: " + UpdateEmployerAlumniSchoolID.length());
        if(CreateEmployerAlumniSchoolID!= "0"){
            for (String employerID : CreateEmployerAlumniSchoolID.split(",")) {
                createEmployerAlumniSchoolIDList.add(Integer.parseInt(employerID));
            }
        }


        if(UpdateEmployerAlumniID!= "") {
            for (String employerID : UpdateEmployerAlumniID.split(",")) {
                System.out.println(UpdateEmployerAlumniID);
                updateEmployerAlumniIDList.add(Integer.parseInt(employerID));

            }
        }

        if(UpdateEmployerAlumniName != "") {
            for (String employerID : UpdateEmployerAlumniName.split(",")) {
                updateEmployerAlumniNameList.add(employerID);

            }
        }
        System.out.println(updateEmployerAlumniIDList);
        System.out.println(updateEmployerAlumniNameList);
        if(UpdateEmployerAlumniSchoolID != ""){
            for (String employerID : UpdateEmployerAlumniSchoolID.split(",")) {
                updateEmployerAlumniSchoolIDList.add(Integer.parseInt(employerID));
            }
        }

        //Update the Employer
        EmployerQrys.updateEmployer(EmployerID,StatusOfEmployerID,EmployerName,EmployerAddressCity,EmployerAddressStreet,EmployerAddressNumber,
                EmployerPostcode,EmployerEmail,ContactPersonNameSurname,ContactPersonPosition,EmployerPhone,EmployerWebsite,
                EmployerTwitter, EmployerFB,NumberOfEmployeesID,CompanySummary,EmployerNotes);


        //     1. Intersection Table - Employer / Cooperation Type
        if(EmployerCooperationType.length() != 0) {
            EmployerQrys.updateEmployerCooperationIntersection(EmployerID, employerCooperationTypeList);
        }

        //     2. Intersection Table - Employer / Industry Sector
        if(EmployerSectorIndustry.length() != 0) {
            EmployerQrys.updateEmployerIndustrySectorIntersection(EmployerID, employerIndustrySectorList);
        }

        //     3. Intersection Table - Employer / Preferences
        if(EmployerPreferences.length() != 0) {
            EmployerQrys.updateEmployerPreferencesIntersection(EmployerID, employerPreferencesList);
        }

        //     4. Intersection Table - Employer / School Preferences
        if(SchoolPreferences.length() != 0) {
            EmployerQrys.updateSchoolEmployerSchoolPreferencesIntersection(EmployerID, employerSchoolPreferencesList);
        }

        //     5. Intersection Table - Employer / Support of Area of Curriculum
        if(EmployerCurriculumAreas.length() != 0) {
            EmployerQrys.updateEmployerEmployerCurriculumAreaIntersection(EmployerID, employerSupportCurriculumAreaList);
        }

        //     6. Intersection Table - Employer / Language Used
        if(EmployerLanguage.length() != 0) {
            EmployerQrys.updateSchoolEmployerLanguageIntersection(EmployerID, employerLanguageUsedList);
        }

        //     7. Intersection Table - Employer / Local Authority
        if(LocalAuthorities.length() != 0) {
            EmployerQrys.updateSchoolEmployerLocalAuthoritiesIntersection(EmployerID, employerLocalAuthorityList);
        }

        System.out.println("Lengh e: " + UpdateEmployerAlumniSchoolID.length());
        if(updateEmployerAlumniIDList.size() !=0 ) {
            System.out.println("Alumni School: "+UpdateEmployerAlumniSchoolID.length());
            //      8.  Update Alumni
            EmployerQrys.updateAlumni(updateEmployerAlumniNameList, updateEmployerAlumniSchoolIDList, updateEmployerAlumniIDList);
        }

        if(CreateEmployerAlumniName.length()!=0) {
            //      9.  Create Alumni
            EmployerQrys.createAlumni(createEmployerAlumniNameList, createEmployerAlumniSchoolIDList);

            //      10.  Get Alumni IDs
            ArrayList<Integer> AlumniIdList = EmployerQrys.getAllAlumniIDFromEmployer(createEmployerAlumniNameList, createEmployerAlumniSchoolIDList);
            System.out.println("..........  AlumniIdList: " + AlumniIdList);

            //      11.  Create Intersection Table - Employer / Alumni
            EmployerQrys.createEmployerAlumniIntersection(EmployerID, AlumniIdList);
        }

        return true;
    }

    ///////////////////////    DELETE     ////////////////////////////////
    //2. Delete Employer
    @DeleteMapping("api/delete/employer")
    public boolean deleteEmployers(@RequestParam(value="employerId") Integer employerId){
        if (EmployerQrys.deleteEmployer(employerId) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
