package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;


public class DealerFacade {

	private DealerCreator dealerCreator;
	private InMemoryDealerRepository dealerRepository;

	public DealerFacade(DealerCreator dealerCreator, InMemoryDealerRepository dealerRepository) {
		this.dealerCreator = dealerCreator;
		this.dealerRepository = dealerRepository;
	}

	public DealerDto add(DealerDto dealerDto) {

		Dealer dealer = dealerCreator.from(dealerDto,
				DealerIdGenerator.getNextId());
		dealer = dealerRepository.save(dealer);
		return dealer.dto();
	}

	public DealerDto findById(int id) {
		
		return dealerRepository.findById(id).dto();
	}

}
