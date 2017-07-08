package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class CarTest {

	CarFacade facade = new CarConfiguration().carFacade();

	String carBrandAlfa = "Alfa Romeo";
	String carBrandToyota = "Toyota";

	@Test
	public void shouldAddCar() {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);

		carDtoAlfa = facade.add(carDtoAlfa);

		assertEquals(carBrandAlfa, facade.findById(carDtoAlfa.getId())
				.getBrand());

	}

	@Test
	public void shoudFindAllCars() {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);
		CarDto carDtoToyota = createCarDto(carBrandToyota);

		carDtoAlfa = facade.add(carDtoAlfa);
		carDtoToyota = facade.add(carDtoToyota);

		List<CarDto> carDtoList = facade.findAll();

		assertTrue(carDtoList.contains(carDtoAlfa));
		assertTrue(carDtoList.contains(carDtoToyota));

	}

	@Test
	public void shoulDeleteCar() {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);
		CarDto carDtoToyota = createCarDto(carBrandToyota);

		carDtoAlfa = facade.add(carDtoAlfa);
		carDtoToyota = facade.add(carDtoToyota);

		facade.delete(carDtoAlfa.getId());

		List<CarDto> carDtoList = facade.findAll();

		assertFalse(carDtoList.contains(carDtoAlfa));
		assertTrue(carDtoList.contains(carDtoToyota));

	}

	static private CarDto createCarDto(String carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}

}
