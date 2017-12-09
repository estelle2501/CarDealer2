package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.wordpress.zapiskiprogramistki.CarDealer2.dealer.exception.DealerNotFoundException;

public class InMemoryDealerRepository {

	private ConcurrentHashMap<Integer, Dealer> dealerMap = new ConcurrentHashMap<>();

	Dealer save(Dealer dealer) {

		dealerMap.put(dealer.dto().getId(), dealer);
		return dealer;
	}

	Dealer findById(int id) throws DealerNotFoundException {
		
		Dealer foundDealer = dealerMap.get(id);
		
		if(foundDealer==null){
			throw new DealerNotFoundException("No dealer-entry found with id: " + id);
		}
		
		return foundDealer;
	}

	List<Dealer> findAll() {
		return dealerMap.values().stream().collect(Collectors.toList());
	}

	public void delete(int id) {
		dealerMap.remove(id);
	}

}
