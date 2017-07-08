package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import lombok.Builder;

@Builder
public class Car {

	private int id;
	private String brand;

	CarDto dto() {

		return CarDto.builder().id(id).brand(brand)
				.build();
	}

}
