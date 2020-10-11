package com.techelevator;

public class Transaction {

	private double moneyProvided;
	private int quarter = 25;
	private int dime = 10;
	private int nickel = 5;
	private double balance;
	private double totalCost;

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

			if (balance >= .25) {
				balance -= .25;
				counterQuarter++;
			}
			else if (balance >= .10) {
				balance -= .10;
				counterDime++;
			}
			else if (balance >= .05) {
				balance -= .05;
				counterNickel++;
			} else if (balance < .05) {
				break;
			}
		}
		System.out.printf("Your remaining balance: $" + "%.2f", balance);
		System.out.println("\nHere is your change:");
		System.out.println("Quarters: " + counterQuarter);
		System.out.println("Dimes: " + counterDime);
		System.out.println("Nickels: " + counterNickel);
	}
}
