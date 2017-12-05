package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import java.util.Date;

import lombok.Builder;

@Builder
public class Car {

	private int id;
	private Brand brand;
	private int kilometerRange;
	private Date registrationDate;
	private CarColor color;
	private FuelType fuelType;
	private GearBox gearBox;

	CarDto dto() {

		return CarDto.builder().id(id).brand(brand)
				.kilometerRange(kilometerRange)
				.registrationDate(registrationDate).color(color)
				.fuelType(fuelType).gearBox(gearBox).build();
	}
}
