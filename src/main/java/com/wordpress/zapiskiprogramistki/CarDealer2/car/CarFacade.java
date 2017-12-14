package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;


@Transactional
public class CarFacade {

	private CarRepository carRepository;
	private CarCreator carCreator;

	public CarFacade(CarRepository carRepository, CarCreator carCreator) {
		this.carCreator = carCreator;
		this.carRepository = carRepository;
	}

	public CarDto add(CarDto carDto) {

		Car car = carCreator.from(carDto, CarIdGenerator.getNextId());
		car = carRepository.save(car);

		return car.dto();
	}

	public Page<CarDto> findAll(Pageable pageable) {
		
		return carRepository.findAll(pageable).map(car -> car.dto());


	}

	public CarDto delete(int id) throws CarNotFoundException {

		Car car = carRepository.findOne(id);

		CarDto deletedCar = car.dto();
		carRepository.delete(deletedCar.getId());

		return deletedCar;

	}

	public CarDto findById(int id){

		Car car = carRepository.findOneOrThrow(id);

		return car.dto();
	}

}
