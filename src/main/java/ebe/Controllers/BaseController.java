package ebe.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {

    @Autowired
    private HttpServletRequest context; // this will provide the current instance of HttpServletRequest

    // HomePage
    @GetMapping("/")
    public RedirectView redirectWithUsingRedirectView() {
        return new RedirectView("/searchEmployers");
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


}
