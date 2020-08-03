package ebe.API;

import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.SchoolQueries;
import ebe.DBMethods.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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

        ArrayList<Integer> employerCooperationTypeList = new ArrayList<Integer>();
        ArrayList<Integer> employerIndustrySectorList = new ArrayList<Integer>();
        ArrayList<Integer> employerPreferencesList = new ArrayList<Integer>();
        ArrayList<Integer> employerSupportCurriculumAreaList = new ArrayList<Integer>();
        ArrayList<Integer> employerLanguageUsedList = new ArrayList<Integer>();
        ArrayList<Integer> employerLocalAuthorityList = new ArrayList<Integer>();
        ArrayList<Integer> employerSchoolPreferencesList = new ArrayList<Integer>();

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
        EmployerQrys.createEmployer(EmployerStatus,EmployerName,EmployerAddressCity,EmployerAddressStreet,EmployerAddressNumber,
                EmployerPostcode,EmployerEmail,ContactPersonNameSurname,ContactPersonPosition,EmployerPhone,EmployerWebsite,
                EmployerTwitter, EmployerFB,NumberOfEmployeesID,CompanySummary,EmployerNotes);

//        //      Get Employer Created Id
        int employerId = EmployerQrys.getLastEmployerCreated(EmployerName);
//
        //     1. Intersection Table - Employer / Cooperation Type
        EmployerQrys.updateEmployerCooperationIntersection(employerId, employerCooperationTypeList);
        //     2. Intersection Table - Employer / Industry Sector
        EmployerQrys.updateEmployerIndustrySectorIntersection(employerId, employerCooperationTypeList);
        //     3. Intersection Table - Employer / Preferences
        EmployerQrys.updateEmployerPreferencesIntersection(employerId, employerCooperationTypeList);
        //     4. Intersection Table - Employer / School Preferences
        EmployerQrys.updateSchoolEmployerSchoolPreferencesIntersection(employerId, employerCooperationTypeList);
        //     5. Intersection Table - Employer / Support of Area of Curriculum
        EmployerQrys.updateEmployerEmployerCurriculumAreaIntersection(employerId, employerCooperationTypeList);
        //     6. Intersection Table - Employer / Language Used
        EmployerQrys.updateSchoolEmployerLanguageIntersection(employerId, employerCooperationTypeList);
        //     7. Intersection Table - Employer / Local Authority
        EmployerQrys.updateSchoolEmployerLocalAuthoritiesIntersection(employerId, employerCooperationTypeList);

//        EventQrys.updateSchoolEventIntersection(eventId, schoolIdList);

        return true;
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

        filteredEmployerIDs = EmployerQrys.getFilteredEmployersIds(employerIndustrySectorList, employerLocalAuthorityList,
                employerSupportCurriculumAreaList, employerLanguageUsedList,
                employerSchoolPreferencesList, employerPreferencesList, employerCooperationTypeList, Arrays.asList());



        return filteredEmployerIDs;

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
