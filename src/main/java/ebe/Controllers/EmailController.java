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
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class EmailController {
    @Autowired
    private EmailAPI emailAPI;

    private StatisticsQueries statisticsQueries;

    @Autowired
    public EmailController(StatisticsQueries sq){
        statisticsQueries = sq;
    }


    @PostMapping("/contactUsEmail")
    public ModelAndView contactUsSubmit(@ModelAttribute Email email, HttpSession session) {
        int localAuthorityID = statisticsQueries.getLocalAuthID(parseInt(session.getAttribute("SESSION_UserID").toString()));
        String localAuthorityName = statisticsQueries.getLocalAuthNameById(localAuthorityID);
        emailAPI.sendMail(session.getAttribute("SESSION_SchoolName").toString(), session.getAttribute("SESSION_Email").toString(), localAuthorityName, email.getSubject(), email.getMessage());

        return new ModelAndView("redirect:/contact-us");
    }

    @PostMapping("/requestEvent")
    public ModelAndView requestEventSubmit(@ModelAttribute Request request, HttpSession session) throws MessagingException {
        int localAuthorityID = statisticsQueries.getLocalAuthID(parseInt(session.getAttribute("SESSION_UserID").toString()));
        String localAuthorityName = statisticsQueries.getLocalAuthNameById(localAuthorityID);
        emailAPI.sendRequestByEvent(session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolName").toString(),localAuthorityName, request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getGuests());

        statisticsQueries.updateSchoolRequestNumber(parseInt(session.getAttribute("SESSION_UserID").toString()));

        return new ModelAndView("redirect:/request");
    }

    @PostMapping("/requestByIndustry")
    public ModelAndView requestByIndustrySubmit(@ModelAttribute Request request, HttpSession session) throws MessagingException {
        int localAuthorityID = statisticsQueries.getLocalAuthID(parseInt(session.getAttribute("SESSION_UserID").toString()));
        String localAuthorityName = statisticsQueries.getLocalAuthNameById(localAuthorityID);
        System.out.println("--------------------------------");
        System.out.println("User ID: " +parseInt(session.getAttribute("SESSION_UserID").toString()));

        emailAPI.sendRequestByIndustry(session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolName").toString(), localAuthorityName, request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getIndustry());

        statisticsQueries.updateSchoolRequestNumber(parseInt(session.getAttribute("SESSION_UserID").toString()));

        return new ModelAndView("redirect:/request");
    }

    @PostMapping("/requestByLanguage")
    public ModelAndView requestByLanguageSubmit(@ModelAttribute Request request, HttpSession session) throws MessagingException {
        int localAuthorityID = statisticsQueries.getLocalAuthID(parseInt(session.getAttribute("SESSION_UserID").toString()));
        String localAuthorityName = statisticsQueries.getLocalAuthNameById(localAuthorityID);

        emailAPI.sendRequestByLanguage(session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolName").toString(), localAuthorityName, request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getLanguage());
        statisticsQueries.updateSchoolRequestNumber(parseInt(session.getAttribute("SESSION_UserID").toString()));

        return new ModelAndView("redirect:/request");
    }

    @PostMapping("/event/showInterest")
    public ModelAndView eventShowInterestSubmit(@ModelAttribute Request request, HttpSession session) throws MessagingException {
        int localAuthorityID = statisticsQueries.getLocalAuthID(parseInt(session.getAttribute("SESSION_UserID").toString()));
        String localAuthorityName = statisticsQueries.getLocalAuthNameById(localAuthorityID);

        emailAPI.sendShowInterest(session.getAttribute("SESSION_Email").toString(), session.getAttribute("SESSION_SchoolName").toString(), localAuthorityName, request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes());
        statisticsQueries.updateSchoolRequestNumber(parseInt(session.getAttribute("SESSION_UserID").toString()));

        return new ModelAndView("redirect:/");
    }


}

