package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	
	private static final String[] PURCHASE_MENU = {"Feed Money", "Select Product", "Finish Transaction", "Return to Main Menu"};
	private static final String[] PAY_OPTIONS = {"$1 Bill", "$2 Bill", "$5 Bill", "$10 Bill", "Return to Main Menu"};
	private static final String[] SELECT_PRODUCT_MENU = {"Return to Main Menu"};
	private static final String[] TRANSACTION_COMPLETE_MENU = {"Thank you for your purchase"};
	
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		
		//snackStockMap.snackStock(getAllSnacks(), 5);
	}
	
	public void run() {
			while (true) {
			System.out.println("*********");
			System.out.println("MAIN MENU");
			System.out.println("*********");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayFullMenu();
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displayPurchaseMenu();
				// do purchase
			} else if (choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Have a nice day!");
			}
		}
	}
	
	public void displayFullMenu() {
		String menuSelection = "";
		System.out.println(/*Print the full menu*/);
			if (menuSelection.equals("Purchase")) {
				displayPurchaseMenu();
			}else if (menuSelection.equals("EXIT")) {
				System.out.println("Have a nice day!");
			}

	}
	
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
