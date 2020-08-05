package ebe.API;

import ebe.DBMethods.EmployerQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
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

        ArrayList<Integer> employerCooperationTypeList = new ArrayList<>();
        ArrayList<Integer> employerIndustrySectorList = new ArrayList<>();
        ArrayList<Integer> employerPreferencesList = new ArrayList<>();
        ArrayList<Integer> employerSupportCurriculumAreaList = new ArrayList<>();
        ArrayList<Integer> employerLanguageUsedList = new ArrayList<>();
        ArrayList<Integer> employerLocalAuthorityList = new ArrayList<>();
        ArrayList<Integer> employerSchoolPreferencesList = new ArrayList<>();

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

        //Create the Employer
        int createVal = employerQueries.createEmployer(statusOfEmployerID,employerName,employerAddressCity,employerAddressStreet,employerAddressNumber,
                employerPostcode,employerEmail,contactPersonNameSurname,contactPersonPosition,employerPhone,employerWebsite,
                employerTwitter, employerFB,numberOfEmployeesID,companySummary,employerNotes);

        //      Get Employer Created Id
        int employerID = employerQueries.getLastEmployerCreated(employerName);

        //     1. Intersection Table - Employer / Cooperation Type
        if(employerCooperationType.length() != 0) {
            employerQueries.createEmployerCooperationIntersection(employerID, employerCooperationTypeList);
        }

        //     2. Intersection Table - Employer / Industry Sector
        if(employerSectorIndustry.length() != 0) {
            employerQueries.createEmployerIndustrySectorIntersection(employerID, employerIndustrySectorList);
        }

        //     3. Intersection Table - Employer / Preferences
        if(employerPreferences.length() != 0) {
            employerQueries.createEmployerPreferencesIntersection(employerID, employerPreferencesList);
        }

        //     4. Intersection Table - Employer / School Preferences
        if(schoolPreferences.length() != 0) {
            employerQueries.createSchoolEmployerSchoolPreferencesIntersection(employerID, employerSchoolPreferencesList);
        }

        //     5. Intersection Table - Employer / Support of Area of Curriculum
        if(employerCurriculumAreas.length() != 0) {
            employerQueries.createEmployerEmployerCurriculumAreaIntersection(employerID, employerSupportCurriculumAreaList);
        }

        //     6. Intersection Table - Employer / Language Used
        if(employerLanguage.length() != 0) {
            employerQueries.createSchoolEmployerLanguageIntersection(employerID, employerLanguageUsedList);
        }

        //     7. Intersection Table - Employer / Local Authority
        if(localAuthorities.length() != 0) {
            employerQueries.createSchoolEmployerLocalAuthoritiesIntersection(employerID, employerLocalAuthorityList);
        }
        return createVal == 1;
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

}
