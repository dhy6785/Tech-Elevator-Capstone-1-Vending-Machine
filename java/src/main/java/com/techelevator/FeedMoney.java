package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class FeedMoney extends Menu {
	
	private Transaction transaction;
	
	
	
	public FeedMoney(InputStream input, OutputStream output, Transaction transaction) {
		super(input, output);
		this.transaction = transaction;
	}
	
	public double getMoneyFromUser() {
		Scanner moneyScanner = new Scanner(System.in);
		double amountTendered = 0;
		
		
		
	}

	
}
