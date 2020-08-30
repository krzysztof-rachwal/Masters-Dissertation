package ebe.API;

import ebe.DBClasses.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class EmailAPI {

    private JavaMailSender javaMailSender;

    public EmailAPI(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String name, String fromEmail, String postcode, String subject, String message) {

        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("daniel.f.m.leite@gmail.com");
        mailMessage.setSubject(subject);
        mailMessage.setText("You have a new message from " + name + ". Local Authority: " + postcode + ". \nContent of the message: \n" + message);
        mailMessage.setFrom(fromEmail);

        javaMailSender.send(mailMessage);


    }

    public void sendRequestByEvent(String emailFrom, String schoolName, String schoolPostcode, String eventName, String eventDate, String eventTime, String eventNotes, String eventType, String guests){
        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("carrers.wales@gmail.com");
        mailMessage.setSubject("Request for " + eventName);
        mailMessage.setText("You have a new request for " + eventName +
                "\nSchool Name: " + schoolName +
                "\nSchool Local Authority: " + schoolPostcode +
                "\nDate: " + eventDate +
                "\nTime: " + eventTime +
                "\nEvent type: " + eventType +
                "\nAdditional notes: " + eventNotes +
                "\nProposed guests: " + guests);
        mailMessage.setFrom(emailFrom);
        System.out.println(mailMessage);

        javaMailSender.send(mailMessage);
        System.out.println("sent");
    }

    public void sendRequestByIndustry(String emailFrom, String schoolName, String schoolPostcode, String eventName, String eventDate, String eventTime, String eventNotes, String eventType, String industry){
        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("carrers.wales@gmail.com");
        mailMessage.setSubject("Request for " + eventName);
        mailMessage.setText("You have a new request for " + eventName +
                "\nSchool Name: " + schoolName +
                "\nSchool Local Authority: " + schoolPostcode +
                "\nDate: " + eventDate +
                "\nTime: " + eventTime +
                "\nEvent type: " + eventType +
                "\nAdditional notes: " + eventNotes +
                "\nProposed Industry type(s): " + industry);
        mailMessage.setFrom(emailFrom);

        javaMailSender.send(mailMessage);
    }

    public void sendRequestByLanguage(String emailFrom, String schoolName, String schoolPostcode, String eventName, String eventDate, String eventTime, String eventNotes, String eventType, String language){
        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("carrers.wales@gmail.com");
        mailMessage.setSubject("Request for " + eventName);
        mailMessage.setText("You have a new request for " + eventName +
                "\nSchool Name: " + schoolName +
                "\nSchool Local Authority: " + schoolPostcode +
                "\nDate: " + eventDate +
                "\nTime: " + eventTime +
                "\nEvent type: " + eventType +
                "\nAdditional notes: " + eventNotes +
                "\nProposed language(s): " + language);
        mailMessage.setFrom(emailFrom);

        javaMailSender.send(mailMessage);
    }

    public void sendShowInterest(String emailFrom, String schoolName, String schoolPostcode, String eventName, String eventDate, String eventTime, String eventNotes){
        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("carrers.wales@gmail.com");
        mailMessage.setSubject("Show Interest for" + eventName);
        mailMessage.setText("You have a new request for " + eventName +
                "\nSchool Name: " + schoolName +
                "\nSchool Local Authority: " + schoolPostcode +
                "\nDate: " + eventDate +
                "\nTime: " + eventTime +
                "\nAdditional notes: " + eventNotes);
        mailMessage.setFrom(emailFrom);

        javaMailSender.send(mailMessage);
    }








//    TODO: HTML email template.
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendRequest(String eventName, String eventDate, String eventTime, String eventNotes, String eventType, String guests) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());


        Context context = new Context();

        String html = templateEngine.process("emailTemplate", context);

        helper.setTo("carrers.wales69@gmail.com");
        helper.setText(html, true);
        helper.setSubject("Request for " + eventName);
        helper.setFrom("krzysiek.rachwal@gmail.com"); //TODO: get session email address.

        emailSender.send(message);
    }
}
