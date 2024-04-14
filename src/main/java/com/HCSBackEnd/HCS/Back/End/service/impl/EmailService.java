package com.HCSBackEnd.HCS.Back.End.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private JavaMailSender javaMailSender;
    private String defaultEmailAddress;

    public EmailService(JavaMailSender javaMailSender,
                        @Value("${spring.mail.username}") String defaultFromAddress) {
        this.javaMailSender = javaMailSender;
        this.defaultEmailAddress = defaultFromAddress;
    }

    @Async
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(defaultEmailAddress);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
    }
}
