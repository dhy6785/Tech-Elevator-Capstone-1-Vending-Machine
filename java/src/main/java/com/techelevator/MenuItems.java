package com.techelevator;

public class MenuItems {

	//Private Members
	private String snackID;
	private String snackName;
	private double snackPrice;
	private String snackType;
	private int count;
	

	//Getters
	public String getSnackID() {
		return snackID;
	}
	public String getSnackName() {
		return snackName;
	}
	public double getSnackPrice() {
		return snackPrice;
	}
	public String getSnackType() {
		return snackType;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public MenuItems(String snackID, String snackName, double snackPrice, String snackType) {
		this.snackID = snackID;
		this.snackName = snackName;
		this.snackPrice = snackPrice;
		this.snackType = snackType;
		this.count = 5;
	}
	
}
