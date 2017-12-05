package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

public class CarTest {

	CarFacade carFacade = new CarConfiguration().carFacade();

	Brand carBrandAlfa = Brand.ALFA_ROMEO;
	Brand carBrandToyota = Brand.TOYOTA;

	@Test
	public void shouldAddCar() {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);

		carDtoAlfa = carFacade.add(carDtoAlfa);

		try {
			assertEquals(carBrandAlfa, carFacade.findById(carDtoAlfa.getId())
					.getBrand());
		} catch (CarNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void shoudFindAllCars() {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);
		CarDto carDtoToyota = createCarDto(carBrandToyota);

		carDtoAlfa = carFacade.add(carDtoAlfa);
		carDtoToyota = carFacade.add(carDtoToyota);

		List<CarDto> carDtoList = carFacade.findAll();

		assertTrue(carDtoList.contains(carDtoAlfa));
		assertTrue(carDtoList.contains(carDtoToyota));

	}

	@Test
	public void shoulDeleteCar() {

		CarDto carDtoAlfa = createCarDto(carBrandAlfa);
		CarDto carDtoToyota = createCarDto(carBrandToyota);

		carDtoAlfa = carFacade.add(carDtoAlfa);
		carDtoToyota = carFacade.add(carDtoToyota);

		try {
			carFacade.delete(carDtoAlfa.getId());
		} catch (CarNotFoundException e) {
			e.printStackTrace();
		}

		List<CarDto> carDtoList = carFacade.findAll();

		assertFalse(carDtoList.contains(carDtoAlfa));
		assertTrue(carDtoList.contains(carDtoToyota));

	}

	static private CarDto createCarDto(Brand carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}

}
