package com.techelevator;

public class Candy extends MenuItems {

	public Candy(String snackID, String snackName, double snackPrice, String snackType) {
		super(snackID, snackName, snackPrice, snackType);

	}

	public static String dispenseMessage() {
		return "Munch, Munch, Yum!";
	}
	
}
