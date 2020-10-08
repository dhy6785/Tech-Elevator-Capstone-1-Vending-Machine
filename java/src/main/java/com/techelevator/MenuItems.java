package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class MenuItems {

	//Private Members
	private String snackID;
	private String snackName;
	private String snackPrice;
	private String snackType;
	private List<String> allSnacks = new ArrayList<String>();
	
	//Getters
	public String getSnackID() {
		return snackID;
	}
	public String getSnackName() {
		return snackName;
	}
	public String getSnackPrice() {
		return snackPrice;
	}
	public String getSnackType() {
		return snackType;
	}
	public List<String> getAllSnacks() {
		return allSnacks;
	}
	
	
}
