package com.wordpress.zapiskiprogramistki.CarDealer2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	
	CarFacade facade = new CarConfiguration().carFacade();
	
	String carBrand = "Alfa Romeo";
	CarDto alfa = createCarDto(carBrand);

	
	@Test
	public void shouldAddCar() {
		
		facade.add(alfa);
		
		assertEquals(alfa.getBrand(), facade.show(alfa.getBrand()).getBrand());
		
	}


	static private CarDto createCarDto(String carBrand) {
		
		return CarDto.builder()
				.brand(carBrand)
				.build();
	}

}
