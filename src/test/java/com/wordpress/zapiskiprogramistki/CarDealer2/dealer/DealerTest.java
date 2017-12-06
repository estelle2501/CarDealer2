package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DealerTest {

	DealerFacade dealerFacade = new DealerConfiguration().carFacade();

	String name = "John";
	String surname = "Smith";

	@Test
	public void shoudAddDealer() {
		DealerDto dealerDtoJohn = createDealerDto(name, surname);

		dealerDtoJohn = dealerFacade.add(dealerDtoJohn);

		assertEquals(dealerDtoJohn,
				dealerFacade.findById(dealerDtoJohn.getId()));

	}

	private DealerDto createDealerDto(String name, String surname) {
		return DealerDto.builder().name(name).surname(surname).build();
	}

}
