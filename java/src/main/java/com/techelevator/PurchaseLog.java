package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PurchaseLog {
	
	String path = "Log.txt";
	File audit = new File(path);
	
	public PurchaseLog() {
		String path = "Log.txt";
		
	}
	
	public void snackEntry(String snackName, String snackID, double cost, double balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		purchaseLog.append(date + " Purchased " + snackName + " " + snackID + " $" + cost + " Balance: $" + balance);
		PrintWriter writer = new PrintWriter(new FileOutputStream(audit, true));
		writer.println(purchaseLog.toString());
		writer.close();
	}
	
	public void cashEntry(String added, double balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		purchaseLog.append(date + " Money Feed: $" + added + " Balance: $" + balance);
		PrintWriter writer = new PrintWriter(new FileOutputStream(audit, true));
		writer.println(purchaseLog.toString());
		writer.close();
	}
	
	public void changeEntry(double balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		purchaseLog.append(date + " Remaining Balance: $" + balance);
		PrintWriter writer = new PrintWriter(new FileOutputStream(audit, true));
		writer.println(purchaseLog.toString());
		writer.close();
	}
}
