package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import java.util.List;
import java.util.stream.Collectors;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

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

	public CarDto delete(int id) throws CarNotFoundException {
		
		Car car = carRepository.findById(id);
		
		CarDto deletedCar = car.dto();
		carRepository.delete(deletedCar.getId());
		
		return deletedCar;

	}

	public CarDto findById(int id) throws CarNotFoundException {

		Car car = carRepository.findById(id);

		return car.dto();
	}

}
