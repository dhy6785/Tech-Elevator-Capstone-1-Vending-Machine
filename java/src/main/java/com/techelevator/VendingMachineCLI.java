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

	private Menu mainMenu;
	private static Menu purchaseMenu;

	public VendingMachineCLI(Menu mainMenu, Menu purchaseMenu) {
		this.mainMenu = mainMenu;
		this.purchaseMenu = purchaseMenu;
	}


	public List<MenuItems> readInventory(String filePath) throws FileNotFoundException{

		File inventoryCSV = new File(filePath);
		List<MenuItems> snackSupply =  new ArrayList<>();

		if (inventoryCSV.exists() == false) {
			System.out.println("File does not exist");
			System.exit(1);
		} else if (inventoryCSV.isFile() == false) {
			System.out.println("Input is not a file");
		}

		try(Scanner inventoryReader = new Scanner(inventoryCSV)) {

			while(inventoryReader.hasNextLine()) {

				String line = inventoryReader.nextLine();
				String[] item = line.split("\\|");
				MenuItems product = new MenuItems(item[0], item[1], Double.parseDouble(item [2]), item [3]);
				snackSupply.add(product);
			}
		}
		return snackSupply;
	}

	
	public void run() throws FileNotFoundException {

		String path = "vendingmachine.csv";
		List<MenuItems> readItems = readInventory(path);

		boolean isRunning = true;
		while (isRunning) {
			System.out.println("*********");
			System.out.println("MAIN MENU");
			System.out.println("*********");
			String choice = (String) mainMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				printInventory(readItems);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				displayPurchaseMenu();
				// do purchase
			} else if (choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				isRunning = false;
				System.out.println("Have a nice day!");
			}
		}
	}

	private static void printInventory(List<MenuItems> snackSupply) {

		for(MenuItems snack : snackSupply) {
			System.out.println(snack.getSnackID() + " " + snack.getSnackName() + " " + snack.getSnackPrice() + "  " + snack.getSnackType());
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

	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu, purchaseMenu);
		cli.run();
	}


	//Purchase Action
	//Dispense Items: prints the item name, cost and money remaining.  Also returns message
	//After product is dispensed, machine updates balance and returns customer to the Purchase menu
}
