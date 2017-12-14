package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CarConfiguration {

	CarFacade carFacade() {
		return carFacade(new InMemoryCarRepository());
	}

	@Bean
	CarFacade carFacade(CarRepository carRepository) {
		CarCreator carCreator = new CarCreator();
		return new CarFacade(carRepository, carCreator);
	}
}
