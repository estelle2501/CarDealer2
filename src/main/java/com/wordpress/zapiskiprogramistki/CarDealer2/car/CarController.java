package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
	
	@Autowired
	private CarFacade carFacade;
	
	 public CarController(CarFacade carFacade) {
		this.carFacade = carFacade;
	}
	
	@GetMapping("cars/{id}")
	CarDto getCar(@PathVariable int id){
		return carFacade.findById(id);
	}
	
}
