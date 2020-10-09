package com.techelevator;

public class Transaction {

	private double moneyProvided;
	private int quarter = 25;
	private int dime = 10;
	private int nickel = 5;
	private double balance;
	private double totalCost;
	
	public double addMoney(double amountTendered) {
		balance += amountTendered;
		return balance;
	}
	
	public double balance() {
		return balance;
	}
	
	public void totalCost(double cost) {
		balance -= cost;
	}
	
	int counterQuarter = 0;
	int counterDime = 0;
	int counterNickel = 0;
	
	public void makeChange() {
		while (balance >= 25) {
			balance -= 25;
			counterQuarter++;
		}
		while (balance >= 10) {
			balance -= 10;
			counterDime++;
		}
		while (balance >= 5) {
			balance -= 5;
			counterNickel++;
		}
		
	}
	
	
	
}
