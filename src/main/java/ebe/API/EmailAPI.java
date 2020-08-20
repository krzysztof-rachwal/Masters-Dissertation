package ebe.API;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailAPI {

    private JavaMailSender javaMailSender;

    public EmailAPI(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String fromEmail, String subject, String message) {

        var mailMessage = new SimpleMailMessage();

        mailMessage.setTo("carrers.wales69@gmail.com");
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom(fromEmail);

        javaMailSender.send(mailMessage);
    }
}
