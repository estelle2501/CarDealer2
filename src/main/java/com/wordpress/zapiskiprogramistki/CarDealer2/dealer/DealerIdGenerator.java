package com.wordpress.zapiskiprogramistki.CarDealer2.dealer;

public class DealerIdGenerator {

	private static int dealerId = 0;

	public static int getNextId() {
		return dealerId++;
	}
}
