package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

@RestController
public class CarController {

	@Autowired
	private CarFacade carFacade;

	public CarController(CarFacade carFacade) {
		this.carFacade = carFacade;
	}

	@GetMapping("cars/{id}")
	CarDto getCar(@PathVariable int id) throws CarNotFoundException {
		return carFacade.findById(id);
	}

	@GetMapping("cars")
	List<CarDto> getCars() {
		return carFacade.findAll();
	}
	
	@PostMapping("cars")
	CarDto addCar(@RequestBody CarDto dto){
		return carFacade.add(dto);		
	}

}
