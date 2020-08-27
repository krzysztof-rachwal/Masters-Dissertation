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

        mailMessage.setTo("carrers.wales69@gmail.com");
        mailMessage.setSubject(subject);
        mailMessage.setText("You have a new message from " + name + ". Postcode: " + postcode + ". \nContent of the message: \n" +
                message);
        mailMessage.setFrom(fromEmail);

        javaMailSender.send(mailMessage);
    }

    public void sendRequest(String eventName, String eventDate, String eventTime, String eventNotes, String eventType, String guests){
        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("carrers.wales69@gmail.com");
        mailMessage.setSubject("Request for " + eventName);
        mailMessage.setText("You have a new request for " + eventName +
                "\nDate: " + eventDate +
                "\nTime: " + eventTime +
                "\nEvent type: " + eventType +
                "\nAdditional notes: " + eventNotes +
                "\nProposed guests: " + guests);
//        mailMessage.setFrom(); TODO: add from email e.g. session email. It will be necessary for contact purposes.

        javaMailSender.send(mailMessage);
    }

//    TODO: HTML email template.
//    @Autowired
//    private JavaMailSender emailSender;
//
//    @Autowired
//    private SpringTemplateEngine templateEngine;
//
//    public void sendRequest(String eventName, String eventDate, String eventTime, String eventNotes, String eventType, String guests) throws MessagingException {
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message,
//                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                StandardCharsets.UTF_8.name());
//
//
//        Context context = new Context();
//
//        String html = templateEngine.process("emailTemplate", context);
//
//        helper.setTo("carrers.wales69@gmail.com");
//        helper.setText(html, true);
//        helper.setSubject("Request for " + eventName);
//        helper.setFrom("krzysiek.rachwal@gmail.com"); //TODO: get session email address.
//
//        emailSender.send(message);
//    }
}
