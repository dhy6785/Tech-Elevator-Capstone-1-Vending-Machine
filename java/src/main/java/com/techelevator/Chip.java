package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;

public class Chip extends MenuItems {

	public Chip(String snackID, String snackName, double snackPrice, String snackType) {
		super(snackID, snackName, snackPrice, snackType);

	}

	public String dispenseMessage() {
		return "Crunch, Crunch, Yum!";
	}
	
}
