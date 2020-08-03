package ebe.api;

import ebe.jdbcRepos.EmployerQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api")
public class EmployerAPI {

    private EmployerQueries employerQueries;

    @Autowired
    public EmployerAPI(EmployerQueries em){ employerQueries = em; }

    // Create Employer
    @GetMapping(value="/create/employer")
    public boolean createEmployer(
//            @RequestParam(name="StatusOfEmployerID") int StatusOfEmployerID,
            @RequestParam(name="EmployerName") String EmployerName,
            @RequestParam(name="EmployerStatus") int EmployerStatus,
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

        ArrayList<Integer> employerCooperationTypeList = new ArrayList<>();
        ArrayList<Integer> employerIndustrySectorList = new ArrayList<>();
        ArrayList<Integer> employerPreferencesList = new ArrayList<>();
        ArrayList<Integer> employerSupportCurriculumAreaList = new ArrayList<>();
        ArrayList<Integer> employerLanguageUsedList = new ArrayList<>();
        ArrayList<Integer> employerLocalAuthorityList = new ArrayList<>();
        ArrayList<Integer> employerSchoolPreferencesList = new ArrayList<>();

        for (String schoolID : EmployerCooperationType.split(",")) {
            employerCooperationTypeList.add(Integer.parseInt(schoolID));
        }
        for (String schoolID : EmployerSectorIndustry.split(",")) {
            employerIndustrySectorList.add(Integer.parseInt(schoolID));
        }
        for (String schoolID : EmployerPreferences.split(",")) {
            employerPreferencesList.add(Integer.parseInt(schoolID));
        }
        for (String schoolID : EmployerCurriculumAreas.split(",")) {
            employerSupportCurriculumAreaList.add(Integer.parseInt(schoolID));
        }
        for (String schoolID : EmployerLanguage.split(",")) {
            employerLanguageUsedList.add(Integer.parseInt(schoolID));
        }
        for (String schoolID : LocalAuthorities.split(",")) {
            employerLocalAuthorityList.add(Integer.parseInt(schoolID));
        }

        for (String schoolID : SchoolPreferences.split(",")) {
            employerSchoolPreferencesList.add(Integer.parseInt(schoolID));
        }

        //Create the Employer
        employerQueries.createEmployer(EmployerStatus,EmployerName,EmployerAddressCity,EmployerAddressStreet,EmployerAddressNumber,
                EmployerPostcode,EmployerEmail,ContactPersonNameSurname,ContactPersonPosition,EmployerPhone,EmployerWebsite,
                EmployerTwitter, EmployerFB,NumberOfEmployeesID,CompanySummary,EmployerNotes);

//      Get Employer Created Id
        int employerId = employerQueries.getLastEmployerCreated(EmployerName);
//
        //     1. Intersection Table - Employer / Cooperation Type
                employerQueries.updateEmployerCooperationIntersection(employerId, employerCooperationTypeList);
        //     2. Intersection Table - Employer / Industry Sector
                employerQueries.updateEmployerIndustrySectorIntersection(employerId, employerCooperationTypeList);
        //     3. Intersection Table - Employer / Preferences
                employerQueries.updateEmployerPreferencesIntersection(employerId, employerCooperationTypeList);
        //     4. Intersection Table - Employer / School Preferences
                employerQueries.updateSchoolEmployerSchoolPreferencesIntersection(employerId, employerCooperationTypeList);
        //     5. Intersection Table - Employer / Support of Area of Curriculum
                employerQueries.updateEmployerEmployerCurriculumAreaIntersection(employerId, employerCooperationTypeList);
        //     6. Intersection Table - Employer / Language Used
                employerQueries.updateSchoolEmployerLanguageIntersection(employerId, employerCooperationTypeList);
        //     7. Intersection Table - Employer / Local Authority
                employerQueries.updateSchoolEmployerLocalAuthoritiesIntersection(employerId, employerCooperationTypeList);

//        EventQrys.updateSchoolEventIntersection(eventId, schoolIdList);

        return true;
    }

    // Delete Employer
    @DeleteMapping("/delete/employer")
    public boolean deleteEmployers(@RequestParam(value="employerId") Integer employerId){
        return employerQueries.deleteEmployer(employerId) == 1;
    }
}
