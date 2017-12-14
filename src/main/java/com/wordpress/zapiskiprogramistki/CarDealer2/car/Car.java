package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	@Id
	private Integer id;
	private Brand brand;
	private Integer kilometerRange;
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
