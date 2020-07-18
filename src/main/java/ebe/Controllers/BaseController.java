package ebe.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    @Autowired
    private HttpServletRequest context; // this will provide the current instance of HttpServletRequest

    // HomePage
    @GetMapping("/")
    public ModelAndView HomePage(HttpSession session) { ;
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("searchEmployerPage");
        return mv;
    }

    //Search Employer
    @GetMapping("/employers")
    public ModelAndView SearchEmployer(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("searchEmployerPage");
        return mv;
    }

    // Search Events
    @GetMapping("/events")
    public ModelAndView SearchEvents(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("searchEventsPage");
        return mv;
    }

    // Create Events
    @GetMapping("/create-events")
    public ModelAndView CreateEvents(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("createEventsPage");
        return mv;
    }

    // Create Events (get id of the event)
    @GetMapping("/events/id")
    public ModelAndView EventProfile(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("eventsProfilePage");
        return mv;
    }

    // Request
    @GetMapping("/request")
    public ModelAndView Request(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("requestPage");
        return mv;
    }

    // Report
    @GetMapping("/report")
    public ModelAndView Report(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("reportPage");
        return mv;
    }


    // Contact Us
    @GetMapping("/contact-us")
    public ModelAndView contactUs(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("contactUsPage");
        return mv;
    }


    //Search Vacancies
    @GetMapping("/vacancies")
    public ModelAndView SearchVacancies(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("searchVacanciesPage");
        return mv;
    }



    @GetMapping("/error")
    public RedirectView ErrorPage() {
        return new RedirectView("/searchEmployerPage");
    }

    // Default Controller
    @GetMapping("/employersProfile")
    public ModelAndView EmployersProfile(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("employersProfilePage");
        return mv;
    }

    @GetMapping("/add-vacancy")
    public ModelAndView AddVacancy (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("addVacancy");
        return mv;
    }

    // Default Controller
    @GetMapping("/add-employer")
    public ModelAndView AddEmployer (HttpSession session) {
        ModelAndView mv = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        // session = context.getSession();
        mv.setViewName("addEmployer");
        return mv;
    }



}
