package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.zapiskiprogramistki.CarDealer2.car.exception.CarNotFoundException;

@RestController
public class CarController {

	private CarFacade carFacade;

	public CarController(CarFacade carFacade) {
		this.carFacade = carFacade;
	}

	@GetMapping("cars/{id}")
	CarDto getCar(@PathVariable int id) throws CarNotFoundException {
		return carFacade.findById(id);
	}

	@GetMapping("cars")
	Page<CarDto> getCars(Pageable pageable) {
		return carFacade.findAll(pageable);
	}

	@PostMapping("cars")
	CarDto addCar(@RequestBody CarDto dto) {
		return carFacade.add(dto);
	}

	@DeleteMapping("cars/{id}")
	public CarDto deleteById(@PathVariable int id) throws CarNotFoundException {
		return carFacade.delete(id);
	}
}
