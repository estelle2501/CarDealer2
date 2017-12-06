package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DealerConfiguration {

	@Bean
	public DealerFacade carFacade() {
		return new DealerFacade(new DealerCreator(),
				new InMemoryDealerRepository());
	}

}
