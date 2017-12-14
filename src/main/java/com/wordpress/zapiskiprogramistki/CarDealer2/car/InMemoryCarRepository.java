package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class InMemoryCarRepository implements CarRepository {

	private ConcurrentHashMap<Integer, Car> map = new ConcurrentHashMap<>();
	
	@Override
	 public Car save(Car car) {
		map.put(car.dto().getId(), car);
		return car;
	}

	@Override
	public Car findOne(Integer id) {
		return map.get(id);		
	}

	@Override
	public void delete(Integer id) {
		map.remove(id);
		
	}

	@Override
	public Page<Car> findAll(Pageable pageable) {
		return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
	}
}
