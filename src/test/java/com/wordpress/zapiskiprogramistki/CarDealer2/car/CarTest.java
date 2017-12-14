package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.data.domain.Page;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

public class CarTest {

	CarFacade carFacade = new CarConfiguration().carFacade();

	Brand carBrandAlfa = Brand.ALFA_ROMEO;
	Brand carBrandToyota = Brand.TOYOTA;
	
	CarDto carDtoAlfa = createCarDto(carBrandAlfa);
	CarDto carDtoToyota = createCarDto(carBrandToyota);

	@Test
	public void shouldAddCar() {

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

		carDtoAlfa = carFacade.add(carDtoAlfa);
		carDtoToyota = carFacade.add(carDtoToyota);

		Page<CarDto> carDtoPage = carFacade.findAll(null);

		assertTrue(carDtoPage.getContent().contains(carDtoAlfa));
		assertTrue(carDtoPage.getContent().contains(carDtoToyota));

	}

	@Test
	public void shoulDeleteCar() {

		carDtoAlfa = carFacade.add(carDtoAlfa);
		carDtoToyota = carFacade.add(carDtoToyota);

		try {
			carFacade.delete(carDtoAlfa.getId());
		} catch (CarNotFoundException e) {
			e.printStackTrace();
		}

		Page<CarDto> carDtoList = carFacade.findAll(null);

		assertFalse(carDtoList.getContent().contains(carDtoAlfa));
		assertTrue(carDtoList.getContent().contains(carDtoToyota));

	}
	
	@Test
	public void shouldThrowCarNotFoundException(){
	
		try {
			carFacade.findById(9);
		} catch (CarNotFoundException e) {
		assertEquals(e.getClass(), CarNotFoundException.class);
		}
		
	}

	static private CarDto createCarDto(Brand carBrand) {

		return CarDto.builder().brand(carBrand).build();
	}

}
