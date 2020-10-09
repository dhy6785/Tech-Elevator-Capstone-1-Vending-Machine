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
		try {
			amountTendered = Double.parseDouble(moneyScanner.nextLine());
			if (amountTendered != amountTendered) {
				System.out.println("Whole bills only please");
			} else if (amountTendered != 10 && amountTendered != 5 && amountTendered != 2 && amountTendered != 1) {
				System.out.println("$1, $2, $5 or $10 bills only please");
			}
			transaction.addMoney(amountTendered);		
		} catch (NumberFormatException ex) {
			System.out.println("Not a valid bill. Please try again.");
			moneyScanner.close();
		}
		return amountTendered;
	}

	
}
