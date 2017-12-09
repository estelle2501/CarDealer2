package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import java.util.ArrayList;
import java.util.List;

import com.wordpress.zapiskiprogramistki.CarDealer2.dealer.exception.DealerNotFoundException;

public class DealerFacade {

	private DealerCreator dealerCreator;
	private InMemoryDealerRepository dealerRepository;

	public DealerFacade(DealerCreator dealerCreator,
			InMemoryDealerRepository dealerRepository) {
		this.dealerCreator = dealerCreator;
		this.dealerRepository = dealerRepository;
	}

	public DealerDto add(DealerDto dealerDto) {

		Dealer dealer = dealerCreator.from(dealerDto,
				DealerIdGenerator.getNextId());
		dealer = dealerRepository.save(dealer);
		return dealer.dto();
	}

	public DealerDto findById(int id) throws DealerNotFoundException {
		return dealerRepository.findById(id).dto();
	}

	public List<DealerDto> findAll() {
		List<Dealer> foundDealers = dealerRepository.findAll();

		List<DealerDto> foundDealerDtos = new ArrayList<>();

		for (Dealer d : foundDealers) {
			foundDealerDtos.add(d.dto());
		}

		return foundDealerDtos;
	}

	public DealerDto delete(int id) throws DealerNotFoundException {

		Dealer dealer = dealerRepository.findById(id);

		dealerRepository.delete(id);
		return dealer.dto();
	}

}
