package org.example.ichodinkov.services;

import jakarta.mail.MessagingException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final String  EMAIL_RECEIVER = "stoqn.business@gmail.com";
    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public EmailService(MailSender mailSender, SimpleMailMessage templateMessage) {
        this.mailSender = mailSender;
        this.templateMessage = templateMessage;
    }

    private String emailFormatter(String name, String email, String text, String phoneNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(text)
                .append(System.lineSeparator())
                .append(name).append(System.lineSeparator())
                .append(email).append(System.lineSeparator())
                .append(phoneNumber);

        return sb.toString();
    }

    public void sendEmail(String name, String email, String message, String phoneNumber) throws MessagingException {
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(EMAIL_RECEIVER);
        msg.setText(emailFormatter(name, email, message, phoneNumber));
        try {
            this.mailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

