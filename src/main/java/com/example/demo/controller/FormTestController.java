package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class FormTestController {

    @GetMapping("/form_layouts.html")
    public String from_layouts() {

        return "form/form_layouts.html";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws Exception{

        if (!headerImg.isEmpty()) {
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\"+originalFilename));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = headerImg.getOriginalFilename();
                    photo.transferTo(new File("D:\\"+originalFilename));
                }
            }
        }

        return "index";
    }
}
