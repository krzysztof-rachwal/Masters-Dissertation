package ebe.Controllers;

import ebe.API.EmailAPI;
import ebe.DBClasses.Email;
import ebe.DBClasses.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class EmailController {
    @Autowired
    private EmailAPI emailAPI;

    HttpSession session;

    @PostMapping("/contactUsEmail")
    public String contactUsSubmit(@ModelAttribute Email email,
                                  @AuthenticationPrincipal(expression = "claims['email']") String emailFrom) {
        emailAPI.sendMail(email.getName(), emailFrom, email.getPostcode(), email.getSubject(), email.getMessage());
        return "contactUsPage";
    }

    @PostMapping("/requestEvent")
    public String requestEventSubmit(@ModelAttribute Request request,
                                     @AuthenticationPrincipal(expression = "claims['email']") String emailFrom) throws MessagingException {
        emailAPI.sendRequestByEvent(emailFrom, request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getGuests());
        return "requestPage";
    }

    @PostMapping("/requestByIndustry")
    public String requestByIndustrySubmit(@ModelAttribute Request request,
                                          @AuthenticationPrincipal(expression = "claims['email']") String emailFrom) throws MessagingException {
        emailAPI.sendRequestByIndustry(emailFrom, request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getIndustry());
        return "requestPage";
    }

    @PostMapping("/requestByLanguage")
    public String requestByLanguageSubmit(@ModelAttribute Request request,
                                          @AuthenticationPrincipal(expression = "claims['email']") String emailFrom) throws MessagingException {
        emailAPI.sendRequestByLanguage(emailFrom, request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getLanguage());
        return "requestPage";
    }


}

