package ebe.Controllers;

import ebe.API.EmailAPI;
import ebe.Classes.Email;
import ebe.Classes.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;

@Controller
public class EmailController {
    @Autowired
    private EmailAPI emailAPI;

    @PostMapping("/contactUsEmail")
    public String contactUsSubmit(@ModelAttribute Email email) {
        emailAPI.sendMail(email.getName(), email.getEmail(), email.getPostcode(), email.getSubject(), email.getMessage());
        return "contactUsPage";
    }

    @PostMapping("/requestEmail")
    public String requestSubmit(@ModelAttribute Request request) throws MessagingException {
        emailAPI.sendRequest(request.getEventName(), request.getEventDate(), request.getEventTime(), request.getEventNotes(), request.getEventType(), request.getGuests());
        return "requestPage";
    }

}