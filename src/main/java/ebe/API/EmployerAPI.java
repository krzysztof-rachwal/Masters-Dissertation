package ebe.API;

import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.SchoolQueries;
import ebe.DBMethods.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

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

//        ArrayList<Integer> schoolIdList = new ArrayList<Integer>();
//
//        for (String schoolID : SchoolPreferences.split(",")) {
//            schoolIdList.add(Integer.parseInt(schoolID));
//        }

        //Create the Employer
        return 1 == EmployerQrys.createEmployer(StatusOfEmployerID,EmployerName,EmployerAddressCity,EmployerAddressStreet,EmployerAddressNumber,
                EmployerPostcode,EmployerEmail,ContactPersonNameSurname,ContactPersonPosition,EmployerPhone,EmployerWebsite,
                EmployerTwitter, EmployerFB,NumberOfEmployeesID,CompanySummary,EmployerNotes);

//        //      Get Employer Created Id
//        int eventId = EventQrys.getLastEventCreated(EmployerName);
//
//        //      Insert into the School / Event intersection table
//        EventQrys.updateSchoolEventIntersection(eventId, schoolIdList);

    }

    ///////////////////////    CREATE     ////////////////////////////////
    //1. Create Employer
    @RequestMapping(value="/api/update/employer", method= RequestMethod.GET)
    public boolean updateEmployer(
//            @RequestParam(name="StatusOfEmployerID") int StatusOfEmployerID,
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

//        ArrayList<Integer> schoolIdList = new ArrayList<Integer>();
//
//        for (String schoolID : SchoolPreferences.split(",")) {
//            schoolIdList.add(Integer.parseInt(schoolID));
//        }

        //Update the Employer
//        EmployerQrys.updateEmployer(EmployerName,EmployerAddressCity,EmployerAddressStreet,EmployerAddressNumber,
//                EmployerPostcode,EmployerEmail,ContactPersonNameSurname,ContactPersonPosition,EmployerPhone,EmployerWebsite,
//                EmployerTwitter, EmployerFB,NumberOfEmployeesID,CompanySummary,EmployerNotes);

//        //      Get Employer Created Id
//        int eventId = EventQrys.getLastEventCreated(EmployerName);
//
//        //      Insert into the School / Event intersection table
//        EventQrys.updateSchoolEventIntersection(eventId, schoolIdList);

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
