package com.wordpress.zapiskiprogramistki.CarDealer2.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.wordpress.zapiskiprogramistki.CarDealer2")
@SpringBootApplication
public class ApplicationConfig {

	public static void main(String[] args) {

		SpringApplication.run(ApplicationConfig.class, args);

	}

}
