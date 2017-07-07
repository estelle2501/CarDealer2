package com.wordpress.zapiskiprogramistki.CarDealer2;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCarRepository {

	private ConcurrentHashMap<String, Car> map = new ConcurrentHashMap<>();

	public Car save(Car car) {
		map.put(car.dto().getBrand(), car);
		return car;
	}

	public Car findByBrand(String carBrand) {
		return map.get(carBrand);
	}

}
