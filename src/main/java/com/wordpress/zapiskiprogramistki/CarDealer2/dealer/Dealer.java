package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import lombok.Builder;

import com.wordpress.zapiskiprogramistki.CarDealer2.Address;

@Builder
public class Dealer {

	private int id;
	private String name;
	private String surname;
	private Address address;

	DealerDto dto() {
		return DealerDto.builder().id(id).name(name).surname(surname)
				.address(address).build();

	}

}
