package com.HCSBackEnd.HCS.Back.End.controller;

import com.HCSBackEnd.HCS.Back.End.service.impl.EmailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailTestingController {

    private final EmailService emailService;

    public EmailTestingController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/send-email")
    public String sentEmailTest() {
        emailService.sendEmail("manyuhasty@gmail.com", "Email Testing From Spring Boot",
                "This is email test");
        return "Email Sent";
    }


}
