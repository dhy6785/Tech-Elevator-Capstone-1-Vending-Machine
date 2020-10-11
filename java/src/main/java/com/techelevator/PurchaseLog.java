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
		File f = new File(path);
		
	}
	
	public void snackEntry(String snackName, String snackID, String cost, String balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		purchaseLog.append(date + " Purchased " + snackName + " " + snackID + " " + cost + " Balance" + balance);
		PrintWriter writer = new PrintWriter(new FileOutputStream(audit, true));
		writer.append(purchaseLog.toString());
		
	}
	
	public void cashEntry(String added, double balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		// need variable
		purchaseLog.append(date + " Cash tendered");
		PrintWriter writer = new PrintWriter(new FileOutputStream(audit, true));
		writer.append(purchaseLog.toString());
	}
	
	public void changeEntry(String change, String balance) throws IOException {
		Date date = java.util.Calendar.getInstance().getTime();
		StringBuilder purchaseLog = new StringBuilder();
		// need variable
		purchaseLog.append(date + " Change dispensed");
		PrintWriter writer = new PrintWriter(new FileOutputStream(audit, true));
		writer.append(purchaseLog.toString());
	}
}
