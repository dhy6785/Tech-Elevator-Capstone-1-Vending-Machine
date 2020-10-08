package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class MenuItems extends Menu {

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

	public MenuItems(InputStream input, OutputStream output) {
		super(input, output);
	}

	String inputPath = "vendingmachine.csv";
	File inputFile = new File(inputPath);

	public String snackDisplay(String snackID , String snackName, int snackPrice, String snackType) throws FileNotFoundException {
		try(Scanner readCSV = new Scanner(inputFile)) {
			while(readCSV.hasNextLine()) {
				String currentLine = readCSV.nextLine();
				String[] splitLine = currentLine.split("|");
				for(String snack : allSnacks) {
					if(splitLine[0].equals("A4")) {
						
					}


				}


			}
			return null;
		}

	}
}
