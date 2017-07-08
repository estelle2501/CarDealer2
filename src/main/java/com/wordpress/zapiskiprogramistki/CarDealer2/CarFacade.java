package com.wordpress.zapiskiprogramistki.CarDealer2;

import java.util.List;
import java.util.stream.Collectors;

public class CarFacade {

	private InMemoryCarRepository carRepository;
	private CarCreator carCreator;

	public CarFacade(InMemoryCarRepository carRepository, CarCreator carCreator) {
		this.carRepository = carRepository;
		this.carCreator = carCreator;
	}

	public CarDto add(CarDto carDto) {

		Car car = carCreator.from(carDto, CarIdGenerator.getNextId());
		car = carRepository.save(car);

		return car.dto();
	}

	public List<CarDto> findAll() {

		List<Car> carList = carRepository.findAll();

		List<CarDto> carDtoList = carList.stream().map(car -> car.dto())
				.collect(Collectors.toList());

		return carDtoList;
	}

	public void delete(int id) {

		carRepository.delete(id);

	}

	public CarDto findById(int id) {

		Car car = carRepository.findById(id);

		return car.dto();
	}

}
