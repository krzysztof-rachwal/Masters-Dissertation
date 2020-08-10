package ebe.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ebe.DBClasses.Employer;
import ebe.DBClasses.Event;
import ebe.DBClasses.School;
import ebe.DBClasses.Vacancy;
import ebe.DBMethods.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    private EmployerQueries EmployerQrys;
    private EventQueries EventQrys;
    private SchoolQueries SchoolQrys;
    private VacancyQueries VacancyQrys;
    private StatisticsQueries statisticsQueries;

    @Autowired
    public BaseController(EmployerQueries em, EventQueries ev, SchoolQueries sc, VacancyQueries va, StatisticsQueries sq){
        EmployerQrys = em;
        EventQrys = ev;
        SchoolQrys = sc;
        VacancyQrys = va;
        statisticsQueries = sq;
    }

    @Autowired
    private HttpServletRequest context; // this will provide the current instance of HttpServletRequest


    // HomePage
    @GetMapping("/")
    public ModelAndView HomePage(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("searchEmployerPage");
        return mv;
    };

    /////////1st - Header Menu (Employer) /////////
    //1. Search Employer
    @GetMapping("/employers")
    public ModelAndView SearchEmployer(HttpSession session) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchEmployerPage");
        List<Employer> employers;
        employers = EmployerQrys.getAllEmployers();

        Map<String,Object> allEmployers = new HashMap<String,Object>();
        allEmployers.put("allEmployers", employers);
        mv.addAllObjects(allEmployers);

        return mv;
    }

    //2. Employer Profile (with the id)
    @GetMapping("/profile-employer")
    public ModelAndView EmployersProfile(@RequestParam(value="employerId")int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profileEmployerPage");
        Employer employer = EmployerQrys.getEmployerDetailsById(id);

        List<Employer> employerInfo;
        List<Employer> employerLanguage;
        List<Integer> employerChosenLanguage;
        List<Employer> employerIndustrySectorAreas;
        List<Integer> employerChosenIndustrySectorAreas;
        List<Employer> employerCurriculumAreas;
        List<Integer> employerChosenCurriculumAreas;
        List<Employer> employerLocalAuthorities;
        List<Integer> employerChosenLocalAuthorities;
        List<Employer> employerNumberOfEmployees;
        List<Employer> employerCooperationType;
        List<Integer> employerChosenCooperationType;
        List<Employer> employerPreferences;
        List<Integer> employerChosenPreferences;
        List<Integer> employerAlumni;
        List<Employer> employerAlumniNamesAndSchoolID;
        List<Employer> employerStatus;
        List<School> schoolAllNamesAndIds;
        List<Integer> employerSchoolPreferences;

        employerInfo = EmployerQrys.getAllEmployers();
        employerLanguage = EmployerQrys.getAllLanguages();
        employerLocalAuthorities = EmployerQrys.getAllLocalAuthorities();
        employerChosenLocalAuthorities = EmployerQrys.getChosenLocalAuthorities(employer.getEmployerID());

        employerIndustrySectorAreas = EmployerQrys.getAllIndustrySectors();
        employerChosenIndustrySectorAreas = EmployerQrys.getChosenIndustrySectors(employer.getEmployerID());
        employerCurriculumAreas = EmployerQrys.getAllCurriculumAreas();
        employerChosenCurriculumAreas = EmployerQrys.getChosenCurriculumAreas(employer.getEmployerID());
        employerNumberOfEmployees = EmployerQrys.getAllNumberOfEmployersPossible();
        employerCooperationType = EmployerQrys.getAllCooperationTypes();
        employerChosenCooperationType = EmployerQrys.getChosenCooperationTypes(employer.getEmployerID());
        employerPreferences = EmployerQrys.getAllPreferences();
        employerChosenPreferences = EmployerQrys.getChosenPreferences(employer.getEmployerID());
        employerAlumni = EmployerQrys.getAllAlumni(employer.getEmployerID());
        employerAlumniNamesAndSchoolID = EmployerQrys.getAllAlumniNamesAndSchoolID(employerAlumni);
        schoolAllNamesAndIds = SchoolQrys.getAllSchoolNamesAndIds();
        employerStatus = EmployerQrys.getAllEmployerStatus();
        employerSchoolPreferences = EmployerQrys.getEmployerSchoolPreferences(employer.getEmployerID());

        Map<String,Object> allEmployer = new HashMap<String,Object>();
        allEmployer.put("employer", employer);
        allEmployer.put("allEmployer", employerInfo);
        allEmployer.put("allEmployerLanguage", employerLanguage);
        allEmployer.put("allEmployerLocalAuthorities", employerLocalAuthorities);
        allEmployer.put("allEmployerChosenLocalAuthorities", employerChosenLocalAuthorities);
        allEmployer.put("allEmployerIndustrySectors", employerIndustrySectorAreas);
        allEmployer.put("allEmployerChosenIndustrySectors", employerChosenIndustrySectorAreas);
        allEmployer.put("allEmployerCurriculumAreas", employerCurriculumAreas);
        allEmployer.put("allEmployerChosenCurriculumAreas", employerChosenCurriculumAreas);
        allEmployer.put("allEmployerNumberOfEmployees", employerNumberOfEmployees);
        allEmployer.put("allEmployerCooperationType", employerCooperationType);
        allEmployer.put("allEmployerChosenCooperationType", employerChosenCooperationType);
        allEmployer.put("allEmployerPreferences", employerPreferences);
        allEmployer.put("allEmployerAlumni",employerAlumniNamesAndSchoolID);
        allEmployer.put("allEmployerChosenPreferences", employerChosenPreferences);
        allEmployer.put("allSchoolNamesAndIds", schoolAllNamesAndIds);
        allEmployer.put("allEmployerStatus",employerStatus);
        allEmployer.put("allEmployerSchoolPreferences", employerSchoolPreferences);


        mv.addAllObjects(allEmployer);


        return mv;
    }

    //3. Add Employer
    @GetMapping("/add-employer")
    public ModelAndView AddEmployer (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addEmployerPage");

        List<Employer> employer;
        List<Employer> employerLanguage;
        List<Employer> employerIndustrySectorAreas;
        List<Employer> employerCurriculumAreas;
        List<Employer> employerLocalAuthorities;
        List<Employer> employerNumberOfEmployees;
        List<Employer> employerCooperationType;
        List<Employer> employerPreferences;
        List<Employer> employerStatus;
        List<School> schoolAllNamesAndIds;

        employer = EmployerQrys.getAllEmployers();
        employerLanguage = EmployerQrys.getAllLanguages();
        employerLocalAuthorities = EmployerQrys.getAllLocalAuthorities();
        employerIndustrySectorAreas = EmployerQrys.getAllIndustrySectors();
        employerCurriculumAreas = EmployerQrys.getAllCurriculumAreas();
        employerNumberOfEmployees = EmployerQrys.getAllNumberOfEmployersPossible();
        employerCooperationType = EmployerQrys.getAllCooperationTypes();
        employerPreferences = EmployerQrys.getAllPreferences();
        employerStatus = EmployerQrys.getAllEmployerStatus();
        schoolAllNamesAndIds = SchoolQrys.getAllSchoolNamesAndIds();

        Map<String,Object> allEmployer = new HashMap<String,Object>();
        allEmployer.put("allEmployer", employer);
        allEmployer.put("allEmployerLanguage", employerLanguage);
        allEmployer.put("allEmployerLocalAuthorities", employerLocalAuthorities);
        allEmployer.put("allEmployerIndustrySectors", employerIndustrySectorAreas);
        allEmployer.put("allEmployerCurriculumAreas", employerCurriculumAreas);
        allEmployer.put("allEmployerNumberOfEmployees", employerNumberOfEmployees);
        allEmployer.put("allEmployerCooperationType", employerCooperationType);
        allEmployer.put("allEmployerPreferences", employerPreferences);
        allEmployer.put("allEmployerStatus",employerStatus);
        allEmployer.put("allSchoolNamesAndIds", schoolAllNamesAndIds);

        mv.addAllObjects(allEmployer);

        return mv;
    }

    /////////2nd - Header Menu (Vacancies) /////////
    //4. Search Vacancies
    @GetMapping("/vacancies")
    public ModelAndView SearchVacancies(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchVacanciesPage");
        List<Vacancy> vacancies;
        vacancies = VacancyQrys.getAllVacancy();

        Map<String,Object> allVacancies = new HashMap<String,Object>();
        allVacancies.put("allVacancies", vacancies);
        mv.addAllObjects(allVacancies);

        return mv;
    }

    //5. Vacancy Profile
    @GetMapping("/profile-vacancy")
    public ModelAndView Vacancy(@RequestParam(value="vacancyId")int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profileVacancyPage");

        Vacancy vacancy = VacancyQrys.getVacancyDetailsById(id);
        Vacancy vacanciesEmployerName = VacancyQrys.getVacancyEmployerName(vacancy.getEmployerID());
        List<Vacancy> vacanciesAllTypes;
        List<Vacancy> vacanciesAllStatus;
        List<Vacancy> vacanciesAllOccupationalCodes;
        List<Vacancy> vacanciesAllApplicationMethods;
        List<Employer> employerAllNamesAndIds;

        employerAllNamesAndIds = EmployerQrys.getAllEmployerNamesAndIds();
        vacanciesAllTypes = VacancyQrys.getAllTypesOfVacancy();
        vacanciesAllStatus = VacancyQrys.getAllStatusOfVacancy();
        vacanciesAllOccupationalCodes = VacancyQrys.getAllOccupationalCodes();
        vacanciesAllApplicationMethods = VacancyQrys.getAllApplicationMethods();

        Map<String,Object> allVacancies = new HashMap<String,Object>();

        allVacancies.put("vacancy", vacancy);
        allVacancies.put("vacancyEmployerName", vacanciesEmployerName);
        allVacancies.put("AllEmployerNamesAndIds", employerAllNamesAndIds);
        allVacancies.put("allVacanciesTypes", vacanciesAllTypes);
        allVacancies.put("allVacanciesStatus", vacanciesAllStatus);
        allVacancies.put("allVacanciesOccupationalCodes", vacanciesAllOccupationalCodes);
        allVacancies.put("allVacanciesApplicationMethods", vacanciesAllApplicationMethods);
        mv.addAllObjects(allVacancies);

        return mv;
    }

    //6. Add Vacancy
    @GetMapping("/add-vacancy")
    public ModelAndView AddVacancy (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addVacancyPage");

        List<Employer> employerAllNamesAndIds;
        List<Vacancy> vacanciesAllTypes;
        List<Vacancy> vacanciesAllStatus;
        List<Vacancy> vacanciesAllOccupationalCodes;
        List<Vacancy> vacanciesAllApplicationMethods;

        employerAllNamesAndIds = EmployerQrys.getAllEmployerNamesAndIds();
        vacanciesAllTypes = VacancyQrys.getAllTypesOfVacancy();
        vacanciesAllStatus = VacancyQrys.getAllStatusOfVacancy();
        vacanciesAllOccupationalCodes = VacancyQrys.getAllOccupationalCodes();
        vacanciesAllApplicationMethods = VacancyQrys.getAllApplicationMethods();

        Map<String,Object> allVacancies = new HashMap<String,Object>();
        allVacancies.put("AllEmployerNamesAndIds", employerAllNamesAndIds);
        allVacancies.put("allVacanciesTypes", vacanciesAllTypes);
        allVacancies.put("allVacanciesStatus", vacanciesAllStatus);
        allVacancies.put("allVacanciesOccupationalCodes", vacanciesAllOccupationalCodes);
        allVacancies.put("allVacanciesApplicationMethods", vacanciesAllApplicationMethods);
        mv.addAllObjects(allVacancies);

        return mv;
    }

    /////////3rd - Header Menu (Events) /////////
    //7. Search Events
    @GetMapping("/events")
    public ModelAndView SearchEvents(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchEventsPage");
        List<Event> events;
        events = EventQrys.getAllEvents();

        Map<String,Object> allEvents = new HashMap<String,Object>();
        allEvents.put("allEvents", events);
        mv.addAllObjects(allEvents);

        return mv;
    }


    //8. Events Profile (get id of the event)
    @GetMapping("/profile-event")
    public ModelAndView EventProfile(@RequestParam(value="eventId")int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profileEventPage");

        Event event = EventQrys.getEventDetailsById(id);
        List<Event> eventsAllTypes;
        List<School> schoolAllNamesAndIds;
        List<Employer> employerAllNamesAndIds;
        List<Integer> eventSchoolsIDs = SchoolQrys.getAllSchoolIDsAttendingEvent(id);
//        List<School> eventSchoolNames = SchoolQrys.getAllSchoolNamesAttendingEvent(eventSchoolsIDs);
        List<Integer> eventEmployerIDs = EmployerQrys.getAllEmployerIDsAttendingEvent(id);
//        List<Employer> eventEmployerNames = EmployerQrys.getAllEmployerNamesAttendingEvent(eventEmployerIDs);


        schoolAllNamesAndIds = SchoolQrys.getAllSchoolNamesAndIds();
        eventsAllTypes = EventQrys.getAllTypesOfEvents();
        employerAllNamesAndIds = EmployerQrys.getAllEmployerNamesAndIds();

        Map<String,Object> Event = new HashMap<String,Object>();
        Event.put("event", event);
//        Event.put("AllSchoolsNames", eventSchoolNames);
        Event.put("EventSchoolsIDs", eventSchoolsIDs);
//        Event.put("AllEmployersNames", eventEmployerNames);
        Event.put("EventEmployersIDs", eventEmployerIDs);
        Event.put("allSchoolNamesAndIds", schoolAllNamesAndIds);
        Event.put("allEventTypes", eventsAllTypes);
        Event.put("AllEmployerNamesAndIds", employerAllNamesAndIds);
        mv.addAllObjects(Event);

//        mv.addObject("event",event);

        return mv;
    }

    //9. Add Events
    @GetMapping("/add-events")
    public ModelAndView AddEvents(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addEventsPage");

        List<Event> eventsAllTypes;
        List<School> schoolAllNamesAndIds;
        List<Employer> employerAllNamesAndIds;

        schoolAllNamesAndIds = SchoolQrys.getAllSchoolNamesAndIds();
        eventsAllTypes = EventQrys.getAllTypesOfEvents();
        employerAllNamesAndIds = EmployerQrys.getAllEmployerNamesAndIds();




        Map<String,Object> allEvents = new HashMap<String,Object>();
        allEvents.put("allSchoolNamesAndIds", schoolAllNamesAndIds);
        allEvents.put("allEventTypes", eventsAllTypes);
        allEvents.put("AllEmployerNamesAndIds", employerAllNamesAndIds);

        mv.addAllObjects(allEvents);

        return mv;
    }

    /////////4th - Header Menu (Request) /////////
    //10. Request
    @GetMapping("/request")
    public ModelAndView Request(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("requestPage");

        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();

        List<Event> eventsAllTypes;
        eventsAllTypes = EventQrys.getAllTypesOfEvents();

        mv.addObject("allEventTypes",eventsAllTypes);
        return mv;
    }

    /////////5th - Header Menu (Report) /////////
    //11. Report
    @GetMapping("/report")
    public ModelAndView Report(/*@RequestParam(required = false,name="typeEvent") Integer typeID,
                               @RequestParam(required = false,name = "localAuth") Integer authID,*/
            HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("reportPage");

        int numberOfEvents = statisticsQueries.getTotalEvents();
        int numberOfVacancies = statisticsQueries.getTotalVacancies();
        int numberOfPupils = statisticsQueries.getTotalPupils();
        int numberOfEmployers = statisticsQueries.getTotalEmployers();
        int schoolAtEvents = statisticsQueries.getSchoolsAtEvents();
        int requestsBySchools = statisticsQueries.getRequestsBySchools();

        Map<String,Integer> eventsByAdv = statisticsQueries.getEventsByAdviser();
        Map<String,Integer> eventsByType = statisticsQueries.getEventsByType();
        Map<String,Integer> empBySector = statisticsQueries.getEmployersBySector();
        Map<String,Integer> evByLocalAuth = statisticsQueries.getEventByLocalAuth();
        Map<String,Integer> pupilsByAuth = statisticsQueries.getTotalPupilsByAuth();
        Map<String,Integer> schoolsOnEveLocalAuth = statisticsQueries.getSchoolsAttendingEventsByAuth();
        Map<String,Integer> empByLocalAuth = statisticsQueries.getEmpByLocalAuth();
        Map<String,Integer> schoolAndRequests = statisticsQueries.getSchoolsAndRequests();

        List<School> allSchoolsNames = SchoolQrys.getAllSchoolNamesAndIds();
        List<Event> allTypesOfEvents = EventQrys.getAllTypesOfEvents();
        List<Employer> allLocalAuthorities = EmployerQrys.getAllLocalAuthorities();

        mv.addObject("numberOfEvents",numberOfEvents);
        mv.addObject("numberOfEmployers",numberOfEmployers);
        mv.addObject("numberOfVacancies",numberOfVacancies);
        mv.addObject("numberOfPupils",numberOfPupils);
        mv.addObject("schoolAtEvents",schoolAtEvents);
        mv.addObject("requestsBySchools",requestsBySchools);
        mv.addObject("eventsByAdv",eventsByAdv);
        mv.addObject("eventsByType",eventsByType);
        mv.addObject("empBySector",empBySector);
        mv.addObject("evByLocalAuth",evByLocalAuth);
        mv.addObject("pupilsByAuth",pupilsByAuth);
        mv.addObject("schoolsOnEveLocalAuth",schoolsOnEveLocalAuth);
        mv.addObject("empByLocalAuth",empByLocalAuth);
        mv.addObject("allSchoolsNames",allSchoolsNames);
        mv.addObject("allTypesOfEvents",allTypesOfEvents);
        mv.addObject("allLocalAuthorities",allLocalAuthorities);
        mv.addObject("schoolAndRequests",schoolAndRequests);

        return mv;
    }

    /////////6th - Header Menu (Contact Us) /////////
    //12. Contact Us
    @GetMapping("/contact-us")
    public ModelAndView contactUs(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("contactUsPage");
        return mv;
    }


    @GetMapping("/error")
    public RedirectView ErrorPage() {
        return new RedirectView("/searchEmployerPage");
    }

}
