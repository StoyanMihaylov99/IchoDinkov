package org.example.ichodinkov.controllers;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @Value("${upload.directory}")
    private String uploadDir;


    @GetMapping("")
    public String getAdmin(){
        return "admin.html";
    }

    @GetMapping("/upload")
    public String indexAdmin() {
        return "/templates/upload.html";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("input-file") MultipartFile file, Model model) {
        if(file.isEmpty()){
            System.out.println("file is empty");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadDir + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);

            model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Failed to upload '" + file.getOriginalFilename() + "'");
        }
        return "redirect:/admin";
    }
}
