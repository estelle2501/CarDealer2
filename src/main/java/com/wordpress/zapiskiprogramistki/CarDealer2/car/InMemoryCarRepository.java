package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

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

	Car findById(int id) throws CarNotFoundException {
		
		Car foundCar = map.get(id);
		
		if (foundCar==null){
			throw new CarNotFoundException("No car-entry found with id: " + id);
		}
		
		return foundCar;
	}
}
