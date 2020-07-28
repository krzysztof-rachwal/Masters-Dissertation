package ebe.API;

import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.SchoolQueries;
import ebe.DBMethods.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class EventAPI {

    private EmployerQueries EmployerQrys;
    private EventQueries EventQrys;
    private SchoolQueries SchoolQrys;
    private VacancyQueries VacancyQrys;

    @Autowired
    public EventAPI(EmployerQueries em, EventQueries ev, SchoolQueries sc, VacancyQueries va){
        EmployerQrys = em;
        EventQrys = ev;
        SchoolQrys = sc;
        VacancyQrys = va;
    }

    ///////////////////////    CREATE     ////////////////////////////////
    //1. Create Events
    @RequestMapping(value="/api/create/event", method= RequestMethod.GET)
    public boolean createEvent(
            @RequestParam(name="Name") String Name,
            @RequestParam(name="TypeOfEvent") int TypeOfEvent,
            @RequestParam(name="Date") String Date,
            @RequestParam(name="isPublic") Boolean isPublic,
            @RequestParam(name="isCancelled") Boolean isCancelled,
            @RequestParam(name="PostCode") String PostCode,
            @RequestParam(name="NameOfAdviser") String NameOfAdviser,
            @RequestParam(name="NumberOfAttendees") int NumberOfAttendees,
            @RequestParam(name="PromotesApprenticeships") Boolean PromotesApprenticeships,
            @RequestParam(name="PromotesWelshLanguage") Boolean PromotesWelshLanguage,
            @RequestParam(name="ChallangesGenderStereoTypes") Boolean ChallangesGenderStereoTypes) throws ParseException {

        return 1 == EventQrys.createEvent(Name, TypeOfEvent, Date,  isPublic,  isCancelled,  PostCode,  NameOfAdviser,
                 NumberOfAttendees,  PromotesApprenticeships,  PromotesWelshLanguage,
                 ChallangesGenderStereoTypes);

    }
    ///////////////////////    DELETE     ////////////////////////////////
    //2. Delete Events
    @DeleteMapping("api/delete/event")
    public boolean deleteEvents(@RequestParam(value="eventId") Integer eventId){

        if (EventQrys.deleteEvent(eventId) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
