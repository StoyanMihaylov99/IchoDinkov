package org.example.ichodinkov.controllers;

import jakarta.mail.MessagingException;
import org.example.ichodinkov.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("")
    public String contact(){
        return "contact.html";
    }

    @PostMapping("")
    @ResponseBody
    public RedirectView submitForm(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             @RequestParam("message") String message,
                             @RequestParam("phone") String phone) throws MessagingException {

        emailService.sendEmail(name,email,message,phone);

        return new RedirectView("/", true);

    }
}
