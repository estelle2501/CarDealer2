package com.wordpress.zapiskiprogramistki.CarDealer2.car;

public class CarIdGenerator {

	private static int carId = 0;

	private CarIdGenerator() {
	}

	public static int getNextId() {

		return carId++;
	}

}
