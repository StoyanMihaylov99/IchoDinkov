package org.example.ichodinkov.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class ApplicationConfig {

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("stoqn.mihaylov7@gmail.com");
        mailSender.setPassword("zpye msyf mlea ymkf");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return mailSender;
    }

    @Bean
    public SimpleMailMessage templateMessage() {
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        templateMessage.setFrom("stoqn.mihaylov7@gmail.com");
        templateMessage.setSubject("Запитване");
        return templateMessage;
    }



}