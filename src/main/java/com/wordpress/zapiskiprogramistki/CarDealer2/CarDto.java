package com.wordpress.zapiskiprogramistki.CarDealer2;

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
	private String brand;

}
