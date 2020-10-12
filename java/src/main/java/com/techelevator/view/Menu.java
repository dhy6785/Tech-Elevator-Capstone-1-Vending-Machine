package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}


	
	public Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}
	
	public Object getMoneyFromUser(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		
		double amountTendered = 0;
		try {
			amountTendered = Double.parseDouble(userInput);
			if (amountTendered != amountTendered) {
				System.out.println("Whole bills only please");
			} else if (amountTendered != 10 && amountTendered != 5 && amountTendered != 2 && amountTendered != 1) {
				System.out.println("$1, $2, $5 or $10 bills only please");
			}
					
		} catch (NumberFormatException ex) {
			System.out.println("Not a valid bill. Please try again.");
			
		}
		return amountTendered;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}
}
