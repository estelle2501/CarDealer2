package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CarConfiguration {

	@Bean
	CarFacade carFacade() {
		
		return new CarFacade(new InMemoryCarRepository(), new CarCreator());
	}

}
