package org.example.ichodinkov.controllers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Value("${upload.directory}")
    private String uploadDir;

    @GetMapping("/")
    public String home(){
        return "index.html";
    }


    @GetMapping("/services")
    public String getPrices(){
        return "services.html";
    }

    @GetMapping("/gallery")
    public String getGallery(){
        return "gallery.html";
    }

}
