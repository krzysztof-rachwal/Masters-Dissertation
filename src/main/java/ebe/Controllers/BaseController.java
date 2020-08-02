package ebe.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ebe.DBClasses.Employer;
import ebe.DBClasses.Event;
import ebe.DBClasses.Vacancy;
import ebe.DBMethods.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        mv.addObject("employer",employer);
        //        for (Employer employer : employers) {
        //            System.out.println(employer.getName());
        //        }
        return mv;
    }

    //3. Add Employer
    @GetMapping("/add-employer")
    public ModelAndView AddEmployer (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("addEmployerPage");
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
        mv.addObject("vacancy",vacancy);

        return mv;
    }

    //6. Add Vacancy
    @GetMapping("/add-vacancy")
    public ModelAndView AddVacancy (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("addVacancyPage");
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
        mv.addObject("event",event);

        return mv;
    }

    //9. Add Events
    @GetMapping("/add-events")
    public ModelAndView AddEvents(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("addEventsPage");
        return mv;
    }

    /////////4th - Header Menu (Request) /////////
    //10. Request
    @GetMapping("/request")
    public ModelAndView Request(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("requestPage");
        return mv;
    }

    /////////5th - Header Menu (Report) /////////
    //11. Report
    @GetMapping("/report")
    public ModelAndView Report(HttpSession session) {
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
        System.out.println(empBySector.toString());


        mv.addObject("numberOfEvents",numberOfEvents);
        mv.addObject("numberOfEmployers",numberOfEmployers);
        mv.addObject("numberOfVacancies",numberOfVacancies);
        mv.addObject("numberOfPupils",numberOfPupils);
        mv.addObject("schoolAtEvents",schoolAtEvents);
        mv.addObject("requestsBySchools",requestsBySchools);
        mv.addObject("eventsByAdv",eventsByAdv);
        mv.addObject("eventsByType",eventsByType);
        mv.addObject("empBySector",empBySector);
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
