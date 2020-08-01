package ebe.Controllers;

import ebe.API.EmailAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {
    @Autowired
    private EmailAPI emailAPI;

    @GetMapping(value = "/sendmail")
    public String sendmail() {

        emailAPI.sendMail("careers.wales69@gmail.com", "Test Subject", "Test mail");

        return "emailsent";
    }
}

