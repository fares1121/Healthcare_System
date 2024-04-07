package com.HCSBackEnd.HCS.Back.End;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/doctor-login")
            .setViewName("forward:/doctor-login.html");

        registry.addViewController("/patient-login")
            .setViewName("forward:/patient-login.html");

        registry.addViewController("/create-doctor")
            .setViewName("forward:/create-doctor.html");

        registry.addViewController("/create-patient")
            .setViewName("forward:/create-patient.html");
    }


}

