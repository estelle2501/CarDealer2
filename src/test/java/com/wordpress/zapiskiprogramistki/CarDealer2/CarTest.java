package com.wordpress.zapiskiprogramistki.CarDealer2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CarTest {
	
	CarFacade facade = new CarConfiguration().carFacade();
	
	String carBrandAlfa = "Alfa Romeo";
	String carBrandToyota = "Toyota";
	CarDto carDtoAlfa = createCarDto(carBrandAlfa);
	CarDto carDtoToyota = createCarDto(carBrandToyota);
	
	@Test
	public void shouldAddCar() {
		
		facade.add(carDtoAlfa);
		
		assertEquals(carBrandAlfa, facade.show(carBrandAlfa).getBrand());
		
	}
	
	@Test
	public void shoudFindAllCars(){
		
		facade.add(carDtoAlfa);
		facade.add(carDtoToyota);
		
		List<CarDto> carDtoList = facade.findAll();	
		
		assertTrue(carDtoList.contains(carDtoAlfa));
		assertTrue(carDtoList.contains(carDtoToyota));
		
	}


	static private CarDto createCarDto(String carBrand) {
		
		return CarDto.builder()
				.brand(carBrand)
				.build();
	}

}
