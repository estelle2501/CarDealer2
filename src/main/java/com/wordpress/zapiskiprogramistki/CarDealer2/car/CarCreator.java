package com.wordpress.zapiskiprogramistki.CarDealer2.car;

public class CarCreator {

	public Car from(CarDto carDto, Integer id) {

		return Car.builder().id(id).brand(carDto.getBrand()).build();
	}

}
