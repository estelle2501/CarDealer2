package com.wordpress.zapiskiprogramistki.CarDealer2;

import lombok.Builder;

@Builder
public class Car {

	private String brand;

	public CarDto dto() {

		return CarDto.builder().
				brand(brand).
				build();
	}

}
