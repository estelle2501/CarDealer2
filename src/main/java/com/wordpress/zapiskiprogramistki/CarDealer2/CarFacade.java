package com.wordpress.zapiskiprogramistki.CarDealer2;


public class CarFacade {
	
	private InMemoryCarRepository carRepository;
	private CarCreator carCreator;
	

	public CarFacade(InMemoryCarRepository carRepository, CarCreator carCreator) {
		this.carRepository = carRepository;
		this.carCreator = carCreator;
	}

	public CarDto add(CarDto carDto) {
		
		Car car = carCreator.from(carDto);
		car = carRepository.save(car);
	
		return car.dto();			
	}

	public CarDto show(String carBrand) {
		
		Car car = carRepository.findByBrand(carBrand);
		
		return car.dto();
	}

}
