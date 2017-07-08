package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryCarRepository {

	private ConcurrentHashMap<Integer, Car> map = new ConcurrentHashMap<>();

	 Car save(Car car) {
		map.put(car.dto().getId(), car);
		return car;
	}

	List<Car> findAll() {

		List<Car> carList = map.values().stream().collect(Collectors.toList());

		return carList;
	}

	void delete(int id) {
		map.remove(id);

	}

	Car findById(int id) {
		return map.get(id);
	}
}
