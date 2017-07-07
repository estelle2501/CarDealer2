package com.wordpress.zapiskiprogramistki.CarDealer2;

public class CarCreator {

	public Car from(CarDto carDto) {
		
		return Car.builder()
				.brand(carDto.getBrand())
				.build();
	}

}
