package com.techelevator;

public class Chip extends MenuItems {

	public Chip(String snackID, String snackName, double snackPrice, String snackType) {
		super(snackID, snackName, snackPrice, snackType);

	}

	public static String dispenseMessage() {
		return "Crunch, Crunch, Yum!";
	}
	
}
