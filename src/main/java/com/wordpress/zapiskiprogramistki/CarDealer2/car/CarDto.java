package com.wordpress.zapiskiprogramistki.CarDealer2.car;
import java.util.Date;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
public class CarDto {

	private int id;
	private Brand brand;
	private int kilometerRange;
	private Date registrationDate;
	private CarColor color;
	private FuelType fuelType;
	private GearBox gearBox;

}
