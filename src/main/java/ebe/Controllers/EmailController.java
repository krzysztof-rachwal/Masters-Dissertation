package ebe.Controllers;

import ebe.API.EmailAPI;
import ebe.Classes.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @Autowired
    private EmailAPI emailAPI;

    @PostMapping("/sendemail")
    public String greetingSubmit(@ModelAttribute Email email) {
        emailAPI.sendMail(email.getEmail(), email.getSubject(), email.getMessage());
        return "contactUsPage";
    }
}