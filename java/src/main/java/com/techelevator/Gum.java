package com.techelevator;

public class Gum extends MenuItems {
	
	public Gum(String snackID, String snackName, double snackPrice, String snackType) {
		super(snackID, snackName, snackPrice, snackType);
		
	}

	public static String dispenseMessage() {
		return "Chew, Chew, Yum!";
	}
	
}
