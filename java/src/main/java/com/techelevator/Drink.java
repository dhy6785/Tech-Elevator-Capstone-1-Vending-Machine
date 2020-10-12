package com.techelevator;

public class Drink extends MenuItems {

	public Drink(String snackID, String snackName, double snackPrice, String snackType) {
		super(snackID, snackName, snackPrice, snackType);

	}

	public static String dispenseMessage() {
		return "Glug, Glug, Yum!";
	}

}
