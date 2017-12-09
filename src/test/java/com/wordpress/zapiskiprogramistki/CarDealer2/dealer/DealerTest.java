package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.wordpress.zapiskiprogramistki.CarDealer2.dealer.exception.DealerNotFoundException;

public class DealerTest {

	DealerFacade dealerFacade = new DealerConfiguration().carFacade();

	DealerDto dealerDtoJohn = createDealerDto("John", "Smith");
	DealerDto dealerDtoMark = createDealerDto("Mark", "Novak");

	@Test
	public void shoudAddDealer() {

		dealerDtoJohn = dealerFacade.add(dealerDtoJohn);

		try {
			assertEquals(dealerDtoJohn,
					dealerFacade.findById(dealerDtoJohn.getId()));
		} catch (DealerNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void shouldFindAllDealers() {

		dealerDtoJohn = dealerFacade.add(dealerDtoJohn);
		dealerDtoMark = dealerFacade.add(dealerDtoMark);

		List<DealerDto> foundDealerDtos = dealerFacade.findAll();

		assertTrue(foundDealerDtos.contains(dealerDtoJohn));
		assertTrue(foundDealerDtos.contains(dealerDtoMark));
	}

	@Test
	public void shouldDeleteDealer() {
		dealerDtoJohn = dealerFacade.add(dealerDtoJohn);
		dealerDtoMark = dealerFacade.add(dealerDtoMark);
		
		List<DealerDto> foundDealersDtos = dealerFacade.findAll();
		assertTrue(foundDealersDtos.contains(dealerDtoJohn));
		assertTrue(foundDealersDtos.contains(dealerDtoMark));
		
		try {
			dealerFacade.delete(dealerDtoJohn.getId());
		} catch (DealerNotFoundException e) {
			e.printStackTrace();
		}
		
		foundDealersDtos = dealerFacade.findAll();	
		
		assertTrue(foundDealersDtos.contains(dealerDtoMark));
		assertFalse(foundDealersDtos.contains(dealerDtoJohn));
		
	}
	
	@Test
	public void shouldThrowDealerNotFoundException(){
		
		try {
			dealerFacade.findById(9);
		} catch (DealerNotFoundException e) {
			assertEquals(e.getClass(), DealerNotFoundException.class);
		}
		
	}

	private DealerDto createDealerDto(String name, String surname) {
		return DealerDto.builder().name(name).surname(surname).build();
	}

}
