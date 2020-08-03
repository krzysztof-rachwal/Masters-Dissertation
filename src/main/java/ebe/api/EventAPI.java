package ebe.api;

import ebe.jdbcRepos.EmployerQueries;
import ebe.jdbcRepos.EventQueries;
import ebe.jdbcRepos.SchoolQueries;
import ebe.jdbcRepos.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/api")
public class EventAPI {

    private EventQueries eventQueries;

    @Autowired
    public EventAPI(EmployerQueries em, EventQueries ev, SchoolQueries sc, VacancyQueries va){
        eventQueries = ev;
    }

    // Create Events
    @GetMapping(value="/create/event")
    public boolean createEvent(
            @RequestParam(name="eventName") String EventName,
            @RequestParam(name="typeOfEventID") int TypeOfEventID,
            @RequestParam(name="eventDate") String EventDate,
            @RequestParam(name="eventTime") String EventTime,
            @RequestParam(name="eventVenueName") String EventVenueName,
            @RequestParam(name="eventAddressCity") String EventAddressCity,
            @RequestParam(name="eventAddressStreet") String EventAddressStreet,
            @RequestParam(name="eventAddressNumber") String EventAddressNumber,
            @RequestParam(name="eventPostcode") String EventPostcode,
            @RequestParam(name="eventSummary") String EventSummary,
            @RequestParam(name="isPublic") Boolean IsPublic,
//          @RequestParam(name="isCancelled") Boolean isCancelled,
            @RequestParam(name="nameOfAdviser") String NameOfAdviser,
            @RequestParam(name="numberOfAttendees") int NumberOfAttendees,
            @RequestParam(name="promotesApprenticeships") Boolean PromotesApprenticeships,
            @RequestParam(name="promotesWelshLanguage") Boolean PromotesWelshLanguage,
            @RequestParam(name="challengesGenderStereotypes") Boolean ChallengesGenderStereotypes,
            @RequestParam(name="employerAttending") String EmployerAttending,
            @RequestParam(name="schoolAttending") String SchoolAttending) throws ParseException {

            //All events created start as not cancelled
            boolean isCancelled = false;
            String EventDateAndTime = EventDate + " " + EventTime;
            ArrayList<Integer> employerIdList = new ArrayList<Integer>();
            ArrayList<Integer> schoolIdList = new ArrayList<Integer>();

            for (String employerID : EmployerAttending.split(",")) {
                employerIdList.add(Integer.parseInt(employerID));
            }
            for (String schoolID : SchoolAttending.split(",")) {
                schoolIdList.add(Integer.parseInt(schoolID));
            }

            //Create the Event
            eventQueries.createEvent(EventName, TypeOfEventID, EventDateAndTime,  EventVenueName,  EventAddressCity,
                    EventAddressStreet, EventAddressNumber, EventPostcode, EventSummary, IsPublic, isCancelled, NameOfAdviser,
                    NumberOfAttendees,  PromotesApprenticeships,  PromotesWelshLanguage,ChallengesGenderStereotypes);

    //      Get Event Created Id
            int eventId = eventQueries.getLastEventCreated(EventName);

    //      Insert into the Employer / Event intersection table
            eventQueries.updateEmployerEventIntersection(eventId,employerIdList);

    //      Insert into the School / Event intersection table
            eventQueries.updateSchoolEventIntersection(eventId, schoolIdList);

            return true;
    }

    // Delete Events
    @DeleteMapping("api/delete/event")
    public boolean deleteEvents(@RequestParam(value="eventId") Integer eventId){

        if (eventQueries.deleteEvent(eventId) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
