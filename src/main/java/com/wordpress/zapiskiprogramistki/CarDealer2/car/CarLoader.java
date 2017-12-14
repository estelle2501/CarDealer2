package com.wordpress.zapiskiprogramistki.CarDealer2.car;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CarLoader implements ApplicationListener<ContextRefreshedEvent> {

	private CarRepository carRepository;

	private Logger log = Logger.getLogger(CarLoader.class);

	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Car alfa = Car.builder().brand(Brand.ALFA_ROMEO).id(0)
				.color(CarColor.BLACK).gearBox(GearBox.MANUAL)
				.kilometerRange(150000).fuelType(FuelType.DIESEL).build();
		carRepository.save(alfa);

		log.info("Saved Alfa - id " + alfa.dto().getId());

	}

}
