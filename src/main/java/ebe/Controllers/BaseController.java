package ebe.Controllers;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.ObjectMapper;
import ebe.DBClasses.Employer;
import ebe.DBClasses.Event;
import ebe.DBClasses.School;
import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.SchoolQueries;
import ebe.DBMethods.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    private EmployerQueries EmployerQrys;
    private EventQueries EventQrys;
    private SchoolQueries SchoolQrys;
    private VacancyQueries VacancyQrys;

    @Autowired
    public BaseController(EmployerQueries em, EventQueries ev, SchoolQueries sc, VacancyQueries va){
        EmployerQrys = em;
        EventQrys = ev;
        SchoolQrys = sc;
        VacancyQrys = va;
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

    /////////1st - Header Menu /////////
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
    public ModelAndView EmployersProfile(@RequestParam(value="employerId" )int id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employersProfilePage");
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

    /////////2nd - Header Menu /////////
    //4. Search Vacancies
    @GetMapping("/vacancies")
    public ModelAndView SearchVacancies(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("searchVacanciesPage");
        List<Employer> employers;
        employers = EmployerQrys.getAllEmployers();

        Map<String,Object> allEmployers = new HashMap<String,Object>();
        allEmployers.put("allEmployers", employers);
        mv.addAllObjects(allEmployers);

        return mv;
    }

    //5. Vacancy Profile
    @GetMapping("/vacancies/id")
    public ModelAndView Vacancy(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("vacancyProfilePage");
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

    /////////3rd - Header Menu /////////
    //7. Search Events
    @GetMapping("/events")
    public ModelAndView SearchEvents(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("searchEventsPage");
        return mv;
    }

    //8. Add Events
    @GetMapping("/add-events")
    public ModelAndView AddEvents(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("addEventsPage");
        return mv;
    }

    //9. Events Profile (get id of the event)
    @GetMapping("/events/id")
    public ModelAndView EventProfile(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("eventsProfilePage");
        return mv;
    }

    /////////4th - Header Menu /////////
    //10. Request
    @GetMapping("/request")
    public ModelAndView Request(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("requestPage");
        return mv;
    }

    /////////5th - Header Menu /////////
    //11. Report
    @GetMapping("/report")
    public ModelAndView Report(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("reportPage");
        return mv;
    }

    /////////6th - Header Menu /////////
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
