package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import com.wordpress.zapiskiprogramistki.CarDealer2.Address;
import com.wordpress.zapiskiprogramistki.CarDealer2.car.CarDto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DealerDto {
	
	private int id;
	private String name;
	private String surname;
	private Address address;

}
