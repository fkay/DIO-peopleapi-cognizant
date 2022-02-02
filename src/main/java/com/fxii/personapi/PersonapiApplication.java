package com.fxii.personapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PersonapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonapiApplication.class, args);
	}

	@Bean
	public static BCryptPasswordEncoder getBCryptPassword() {
		return new BCryptPasswordEncoder();
	}

}
