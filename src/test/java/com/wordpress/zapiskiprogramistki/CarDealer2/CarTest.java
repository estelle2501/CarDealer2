package com.wordpress.zapiskiprogramistki.CarDealer2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {
	
	CarFacade facade = new CarConfiguration().carFacade();
	
	String carBrandAlfa = "Alfa Romeo";
	CarDto carDtoAlfa = createCarDto(carBrandAlfa);
	
	@Test
	public void shouldAddCar() {
		
		facade.add(carDtoAlfa);
		
		assertEquals(carBrandAlfa, facade.show(carBrandAlfa).getBrand());
		
	}


	static private CarDto createCarDto(String carBrand) {
		
		return CarDto.builder()
				.brand(carBrand)
				.build();
	}

}
