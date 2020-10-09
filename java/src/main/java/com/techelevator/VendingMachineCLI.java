package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "FeedMoney";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	//	private static final String[] PAY_OPTIONS = {"$1 Bill", "$2 Bill", "$5 Bill", "$10 Bill", "Return to Main Menu"};
	//	private static final String[] SELECT_PRODUCT_MENU = {"Return to Main Menu"};
	//	private static final String[] TRANSACTION_COMPLETE_MENU = {"Thank you for your purchase"};

	private Menu menu;
	private Menu purchaseMenu;

	public VendingMachineCLI(Menu menu, Menu purchaseMenu) {
		this.menu = menu;
		this.purchaseMenu = purchaseMenu;
	}

	
	
	public List<String[]> readInventory(String filePath) throws FileNotFoundException{
		File inventoryCSV = new File(filePath);
		List<String[]> snackSupply =  new ArrayList<>();
		try(Scanner inventoryReader = new Scanner(inventoryCSV)) {
			
			while(inventoryReader.hasNextLine()) {
				
				String line = inventoryReader.nextLine();
				String[] item = line.split("\\|");
				snackSupply.add(item);
			}
		}
		return snackSupply;
	}
	
	public void run() throws FileNotFoundException {
		
		String path = "vendingmachine.csv";
		List<String[]> readItems = readInventory(path);
		// make sure file exists
		
		
		
		while (true) {
			System.out.println("*********");
			System.out.println("MAIN MENU");
			System.out.println("*********");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				displayFullMenu();
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displayPurchaseMenu();
				// do purchase
			} else if (choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Have a nice day!");
			}
		}
	}

//	public void displayFullMenu() {
//		String menuSelection = "";
//		System.out.println(/*Print the full menu*/);
//		if (menuSelection.equals("Purchase")) {
//			displayPurchaseMenu();
//		}else if (menuSelection.equals("EXIT")) {
//			System.out.println("Have a nice day!");
//		}

	

	public void displayPurchaseMenu() {
		String purchaseMenuOption = "";
			if(purchaseMenuOption.equals("Feed Money")) {
				displayFeedMoneyMenu();
			}else if (purchaseMenuOption.equals("Select Product")) {
				displaySelectedProductMenu();
			}else if (purchaseMenuOption.equals("Finish Transaction")) {
				displayFinishTransactionMenu();
			}
		
	}

	public void displayFeedMoneyMenu() {

	}

	public void displaySelectedProductMenu() {
		//Requires dispense messages
	}

	public void displayFinishTransactionMenu() {

	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}


	//Purchase Action
	//Dispense Items: prints the item name, cost and money remaining.  Also returns message
	//After product is dispensed, machine updates balance and returns customer to the Purchase menu
}
