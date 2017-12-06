package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

public class DealerCreator {

	public Dealer from(DealerDto dealerDto, int id) {
		
		return Dealer.builder().id(id).name(dealerDto.getName())
				.surname(dealerDto.getSurname())
				.address(dealerDto.getAddress()).build();
	}
}
