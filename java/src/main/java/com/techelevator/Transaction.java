package com.techelevator;

import java.io.IOException;

public class Transaction {

	private double quarter = .25;
	private double dime = .10;
	private double nickel = .05;
	private double balance;

	PurchaseLog pLog = new PurchaseLog();

	public Transaction() {

	}

	public double addMoney(double amountTendered) {
		balance += amountTendered;
		return balance;
	}

	public double balance() {
		return balance;
	}

	public double totalCost(double cost) {
		balance -= cost;
		return balance;
	}


	int counterQuarter = 0;
	int counterDime = 0;
	int counterNickel = 0;

	public void makeChange() {
		while(balance > 0.00) {

			if (balance >= quarter) {
				balance -= quarter;
				counterQuarter++;
			}
			else if (balance >= dime) {
				balance -= dime;
				counterDime++;
			}
			else if (balance >= nickel) {
				balance -= nickel;
				counterNickel++;
			} else if (balance < nickel) {
				break;
			}
		}
		
		System.out.printf("Your remaining balance: $" + "%.2f", balance);
		System.out.println("\nHere is your change:");
		System.out.println("Quarters: " + counterQuarter);
		System.out.println("Dimes: " + counterDime);
		System.out.println("Nickels: " + counterNickel);
		
		try {
			pLog.changeEntry(balance);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
