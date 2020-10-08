package com.techelevator;

import java.io.File;
import java.util.Date;

public class PurchaseLog {

	String path = "Log.txt";
	File audit = new File(path);
	
	public void snackEntry(String snackName, String snackID, String cost, String balance) {
		Date date = java.util.Calendar.getInstance().getTime();
	}
	
	public void cashEntry() {
		Date date = java.util.Calendar.getInstance().getTime();
	}
	
	public void changeEntry() {
		Date date = java.util.Calendar.getInstance().getTime();
	}
}
