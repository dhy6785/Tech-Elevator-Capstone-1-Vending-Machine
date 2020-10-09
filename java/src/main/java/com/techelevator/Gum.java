package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;

public class Gum extends MenuItems {
	
	public Gum(String snackID, String snackName, double snackPrice, String snackType) {
		super(snackID, snackName, snackPrice, snackType);
		
	}

	public String dispenseMessage() {
		return "Chew, Chew, Yum!";
	}
	
}
