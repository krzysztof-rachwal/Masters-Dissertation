package ebe.Controllers;

import ebe.API.EmailAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailAPI emailAPI;

    @GetMapping("/sendmail")
    public String sendmail() {

        emailAPI.sendMail("krzysiek.rachwal@gmail.com", "Test Subject", "Test mail");

        return "emailsent";
    }
}

