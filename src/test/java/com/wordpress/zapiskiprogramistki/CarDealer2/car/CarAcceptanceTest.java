package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarAcceptanceTest {

	String carBrandAlfa = "Alfa Romeo";
	String carBrandToyota = "Toyota";

	@Autowired
	CarFacade carFacade;

	@Test
	public void shouldGetCar() {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);

		carDtoAlfa = carFacade.add(carDtoAlfa);

	}

	static private CarDto createCarDto(String carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}
}
