package com.wordpress.zapiskiprogramistki.CarDealer2;

public class CarCreator {

	public Car from(CarDto carDto, int id) {

		return Car.builder().id(id).brand(carDto.getBrand()).build();
	}

}
