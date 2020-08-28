package ebe.Controllers;

import ebe.API.EmailAPI;
import ebe.DBClasses.Email;
import ebe.DBClasses.Employer;
import ebe.DBClasses.Request;
import ebe.DBClasses.School;
import ebe.DBMethods.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private EmailAPI emailAPI;

    private SchoolQueries schoolQueries;


    @PostMapping("/contactUsEmail")
    public String contactUsSubmit(@ModelAttribute Email email, HttpSession session) {
        emailAPI.sendMail(session.getAttribute("SESSION_SchoolName").toString(), session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolPostCode").toString(), email.getSubject(), email.getMessage());
        return "contactUsPage";
    }

    @PostMapping("/requestEvent")
    public String requestEventSubmit(@ModelAttribute Request request, HttpSession session) throws MessagingException {
        emailAPI.sendRequestByEvent(session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolName").toString(), session.getAttribute("SESSION_SchoolPostCode").toString(), request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getGuests());
//        schoolQueries.addRequestCount(session.getAttribute("SESSION_Email").toString());
//        TODO: increase number of requests for school (above line). Most probably there is an error in SQL in SchoolQueries (number 6).
        return "requestPage";
    }

    @PostMapping("/requestByIndustry")
    public String requestByIndustrySubmit(@ModelAttribute Request request, HttpSession session) throws MessagingException {
        emailAPI.sendRequestByIndustry(session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolName").toString(), session.getAttribute("SESSION_SchoolPostCode").toString(), request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getIndustry());
        return "requestPage";
    }

    @PostMapping("/requestByLanguage")
    public String requestByLanguageSubmit(@ModelAttribute Request request, HttpSession session) throws MessagingException {
        emailAPI.sendRequestByLanguage(session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolName").toString(), session.getAttribute("SESSION_SchoolPostCode").toString(), request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getLanguage());
        return "requestPage";
    }


}

