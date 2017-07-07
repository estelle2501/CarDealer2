package com.wordpress.zapiskiprogramistki.CarDealer2;

class CarConfiguration {

	CarFacade carFacade() {
		
		return new CarFacade(new InMemoryCarRepository(), new CarCreator());
	}

}
