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

	private static final String FEED_ONE_DOLLAR = "$1 Bill";
	private static final String FEED_TWO_DOLLARS = "$2 Bill"; 
	private static final String FEED_FIVE_DOLLARS ="$5 Bill";
	private static final String FEED_TEN_DOLLARS = "$10 Bill";
	private static final String[] FEED_MENU_OPTIONS = {FEED_ONE_DOLLAR, FEED_TWO_DOLLARS, FEED_FIVE_DOLLARS, FEED_TEN_DOLLARS};
//	private static final String[] SELECT_PRODUCT_MENU = {"Return to Main Menu"};
	//	private static final String[] TRANSACTION_COMPLETE_MENU = {"Thank you for your purchase"};

	private Menu menu;
	Scanner productScanner = new Scanner(System.in);
	Transaction customerTransaction = new Transaction();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
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
			System.out.println("\n*********");
			System.out.println("MAIN MENU");
			System.out.println("*********");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				printInventory(readItems);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				while(true) {
					System.out.println("\n*************");
					System.out.println("PURCHASE MENU");
					System.out.println("*************");
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					
					if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						String feedChoice = (String) menu.getChoiceFromOptions(FEED_MENU_OPTIONS);
						if (feedChoice.equals(FEED_ONE_DOLLAR)) {
							customerTransaction.addMoney(1);
							System.out.printf("\nTotal Balance: $" + "%.2f", customerTransaction.balance());
							
						}else if (feedChoice.equals(FEED_TWO_DOLLARS)) {
							customerTransaction.addMoney(2);
							System.out.printf("Total Balance: $" + "%.2f", customerTransaction.balance());
							
						}else if (feedChoice.equals(FEED_FIVE_DOLLARS)) {
							customerTransaction.addMoney(5);
							System.out.printf("Total Balance: $" + "%.2f", customerTransaction.balance());
							
						}else if (feedChoice.equals(FEED_TEN_DOLLARS)) {
							customerTransaction.addMoney(10);
							System.out.printf("Total Balance: $" + "%.2f", customerTransaction.balance());
						}
						
					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						
						printInventory(readItems);
						productSelect(readItems);

						
					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						
						customerTransaction.makeChange();
						// Infinite loop at the moment. Have to fix
					}
				}
			
			} else if (choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				isRunning = false;
				System.out.println("Have a nice day!");
			}
		}
	}

	private static void printInventory(List<MenuItems> snackSupply) {

		for(MenuItems snack : snackSupply) {
			System.out.println(snack.getSnackID() + " " + snack.getSnackName() + " " + snack.getSnackPrice() + "  " + snack.getSnackType() + " | In Stock: " + snack.getCount());
		}

	}

	private void productSelect(List<MenuItems> snackSupply) {
		
		System.out.print("\nPlease select product ID >>> ");
		String productChoice = productScanner.nextLine();
		
		for(MenuItems snack : snackSupply) {

			if(snack != null && snack.getSnackID().equalsIgnoreCase(productChoice)) {
				
				System.out.println("You have chosen: " + snack.getSnackName());
				
				if(snack.getSnackType().equals("Candy")) {
					System.out.println(Candy.dispenseMessage());
				} else if(snack.getSnackType().equals("Chip")) {
					System.out.println(Chip.dispenseMessage());
				} else if(snack.getSnackType().equals("Gum")) {
					System.out.println(Gum.dispenseMessage());
				} else if(snack.getSnackType().equals("Drink")) {
					System.out.println(Drink.dispenseMessage());
				}
				
				customerTransaction.totalCost(snack.getSnackPrice());
				System.out.printf("Remaining balance: " + "%.2f", customerTransaction.balance());
				
			}
		}
	}
	



	
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
