package ebe.controllers;

import ebe.models.Employer;
import ebe.models.Event;
import ebe.models.School;
import ebe.models.Vacancy;
import ebe.jdbcRepos.EmployerQueries;
import ebe.jdbcRepos.EventQueries;
import ebe.jdbcRepos.SchoolQueries;
import ebe.jdbcRepos.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    private EmployerQueries employerQueries;
    private EventQueries eventQueries;
    private SchoolQueries schoolQueries;
    private VacancyQueries vacancyQueries;

    @Autowired
    public BaseController(EmployerQueries em, EventQueries ev, SchoolQueries sc, VacancyQueries va){
        employerQueries = em;
        eventQueries = ev;
        schoolQueries = sc;
        vacancyQueries = va;
    }

    @Autowired
    private HttpServletRequest context; // this will provide the current instance of HttpServletRequest


    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchEmployerPage");
        return mv;
    }

    @GetMapping("/employers")
    public ModelAndView searchEmployer() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchEmployerPage");

        List<Employer> employers;
        employers = employerQueries.getAllEmployers();

        Map<String,Object> allEmployers = new HashMap<>();
        allEmployers.put("allEmployers", employers);

        mv.addAllObjects(allEmployers);
        return mv;
    }


    @GetMapping("/profile-employer")
    public ModelAndView employersProfile(@RequestParam(value="employerId")int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profileEmployerPage");

        Employer employer = employerQueries.getEmployerDetailsById(id);
        mv.addObject("employer",employer);
        return mv;
    }

    //3. Add Employer
    @GetMapping("/add-employer")
    public ModelAndView addEmployer() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addEmployerPage");

        List<Employer> employer = employerQueries.getAllEmployers();
        List<Employer> employerLanguage = employerQueries.getAllLanguages();
        List<Employer> employerLocalAuthorities = employerQueries.getAllLocalAuthorities();
        List<Employer> employerIndustrySectorAreas = employerQueries.getAllIndustrySectors();
        List<Employer> employerCurriculumAreas = employerQueries.getAllCurriculumAreas();
        List<Employer> employerNumberOfEmployees = employerQueries.getAllNumberOfEmployersPossible();
        List<Employer> employerCooperationType = employerQueries.getAllCooperationTypes();
        List<Employer> employerPreferences = employerQueries.getAllPreferences();
        List<Employer> employerStatus = employerQueries.getAllEmployerStatus();
        List<School> schoolAllNamesAndIds = schoolQueries.getAllSchoolNamesAndIds();

        Map<String,Object> allEmployers = new HashMap<>();
        allEmployers.put("allEmployer", employer);
        allEmployers.put("allEmployerLanguage", employerLanguage);
        allEmployers.put("allEmployerLocalAuthorities", employerLocalAuthorities);
        allEmployers.put("allEmployerIndustrySectors", employerIndustrySectorAreas);
        allEmployers.put("allEmployerCurriculumAreas", employerCurriculumAreas);
        allEmployers.put("allEmployerNumberOfEmployees", employerNumberOfEmployees);
        allEmployers.put("allEmployerCooperationType", employerCooperationType);
        allEmployers.put("allEmployerPreferences", employerPreferences);
        allEmployers.put("allEmployerStatus", employerStatus);
        allEmployers.put("allSchoolNamesAndIds", schoolAllNamesAndIds);

        mv.addAllObjects(allEmployers);
        return mv;
    }

    @GetMapping("/vacancies")
    public ModelAndView searchVacancies() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchVacanciesPage");

        List<Vacancy> vacancies;
        vacancies = vacancyQueries.getAllVacancy();

        Map<String,Object> allVacancies = new HashMap<>();
        allVacancies.put("allVacancies", vacancies);

        mv.addAllObjects(allVacancies);
        return mv;
    }

    @GetMapping("/profile-vacancy")
    public ModelAndView vacancy(@RequestParam(value="vacancyId")int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profileVacancyPage");

        Vacancy vacancy = vacancyQueries.getVacancyDetailsById(id);
        Vacancy vacanciesEmployerName = vacancyQueries.getVacancyEmployerName(vacancy.getEmployerID());

        List<Employer> employerAllNamesAndIds = employerQueries.getAllEmployerNamesAndIds();
        List<Vacancy> vacanciesAllTypes = vacancyQueries.getAllTypesOfVacancy();
        List<Vacancy> vacanciesAllStatus = vacancyQueries.getAllStatusOfVacancy();
        List<Vacancy> vacanciesAllOccupationalCodes = vacancyQueries.getAllOccupationalCodes();
        List<Vacancy> vacanciesAllApplicationMethods = vacancyQueries.getAllApplicationMethods();

        Map<String,Object> allVacancies = new HashMap<>();

        allVacancies.put("vacancy", vacancy);
        allVacancies.put("vacancyEmployerName", vacanciesEmployerName);
        allVacancies.put("allEmployerNamesAndIds", employerAllNamesAndIds);
        allVacancies.put("allVacanciesTypes", vacanciesAllTypes);
        allVacancies.put("allVacanciesStatus", vacanciesAllStatus);
        allVacancies.put("allVacanciesOccupationalCodes", vacanciesAllOccupationalCodes);
        allVacancies.put("allVacanciesApplicationMethods", vacanciesAllApplicationMethods);
        mv.addAllObjects(allVacancies);

        return mv;
    }

    //6. Add Vacancy
    @GetMapping("/add-vacancy")
    public ModelAndView addVacancy() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addVacancyPage");

        List<Employer> employerAllNamesAndIds = employerQueries.getAllEmployerNamesAndIds();
        List<Vacancy>  vacanciesAllTypes = vacancyQueries.getAllTypesOfVacancy();
        List<Vacancy>  vacanciesAllStatus = vacancyQueries.getAllStatusOfVacancy();
        List<Vacancy> vacanciesAllOccupationalCodes = vacancyQueries.getAllOccupationalCodes();
        List<Vacancy>  vacanciesAllApplicationMethods = vacancyQueries.getAllApplicationMethods();

        Map<String,Object> allVacancies = new HashMap<>();
        allVacancies.put("AllEmployerNamesAndIds", employerAllNamesAndIds);
        allVacancies.put("allVacanciesTypes", vacanciesAllTypes);
        allVacancies.put("allVacanciesStatus", vacanciesAllStatus);
        allVacancies.put("allVacanciesOccupationalCodes", vacanciesAllOccupationalCodes);
        allVacancies.put("allVacanciesApplicationMethods", vacanciesAllApplicationMethods);

        mv.addAllObjects(allVacancies);
        return mv;
    }

    @GetMapping("/events")
    public ModelAndView searchEvents() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchEventsPage");
        List<Event> events;
        events = eventQueries.getAllEvents();

        Map<String,Object> allEvents = new HashMap<>();
        allEvents.put("allEvents", events);

        mv.addAllObjects(allEvents);
        return mv;
    }

    //8. Events Profile (get id of the event)
    @GetMapping("/profile-event")
    public ModelAndView eventProfile(@RequestParam(value="eventId")int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("profileEventPage");

        Event event = eventQueries.getEventDetailsById(id);
        List<School> eventSchoolsIDs = schoolQueries.getAllSchoolIDsAttendingEvent(id);
        List<School> eventSchoolNames = schoolQueries.getAllSchoolNamesAttendingEvent(eventSchoolsIDs);
        List<Employer> eventEmployerIDs = employerQueries.getAllEmployerIDsAttendingEvent(id);
        List<Employer> eventEmployerNames = employerQueries.getAllEmployerNamesAttendingEvent(eventEmployerIDs);

        Map<String,Object> eventsMap = new HashMap<>();
        eventsMap.put("event", event);
        eventsMap.put("allSchoolsNames", eventSchoolNames);
        eventsMap.put("allEmployersNames", eventEmployerNames);
        mv.addAllObjects(eventsMap);

        return mv;
    }

    //9. Add Events
    @GetMapping("/add-events")
    public ModelAndView addEvents() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("addEventsPage");

        List<School> schoolAllNamesAndIds = schoolQueries.getAllSchoolNamesAndIds();
        List<Event> eventsAllTypes = eventQueries.getAllTypesOfEvents();
        List<Employer> employerAllNamesAndIds = employerQueries.getAllEmployerNamesAndIds();

        Map<String,Object> allEvents = new HashMap<>();
        allEvents.put("allSchoolNamesAndIds", schoolAllNamesAndIds);
        allEvents.put("allEventTypes", eventsAllTypes);
        allEvents.put("AllEmployerNamesAndIds", employerAllNamesAndIds);

        mv.addAllObjects(allEvents);
        return mv;
    }

    //10. Request
    @GetMapping("/request")
    public ModelAndView request() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("requestPage");
        return mv;
    }

    //11. Report
    @GetMapping("/report")
    public ModelAndView report() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("reportPage");
        return mv;
    }

    //12. Contact Us
    @GetMapping("/contact-us")
    public ModelAndView contactUs() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("contactUsPage");
        return mv;
    }


    @GetMapping("/error")
    public RedirectView errorPage() {
        return new RedirectView("/searchEmployerPage");
    }

}
