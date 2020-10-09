package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

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
	
	
	public MenuItems(String snackID, String snackName, double snackPrice, String snackType) {
		this.snackID = snackID;
		this.snackName = snackName;
		this.snackPrice = snackPrice;
		this.snackType = snackType;
		this.count = 5;
	}

	public String soldOut() {
		String soldOut = "";
		if(this.getCount() == 0) {
			soldOut = "SOLD OUT";
		}
		return soldOut;
	}
	
	

	


		

	
}
