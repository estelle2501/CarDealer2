package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDealerRepository {

	private ConcurrentHashMap<Integer, Dealer> dealerMap = new ConcurrentHashMap<>();

	Dealer save(Dealer dealer) {

		dealerMap.put(dealer.dto().getId(), dealer);
		return dealer;
	}

	Dealer findById(int id) {
		return dealerMap.get(id);
	}

}
