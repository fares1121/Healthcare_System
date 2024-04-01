package com.HCSBackEnd.HCS.Back.End;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.HCSBackend.HCS.Back.End.security.mappers")
public class HcsBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcsBackEndApplication.class, args);
	}

}
