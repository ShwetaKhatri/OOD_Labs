package com.ood.lab3;

import java.util.InputMismatchException;
import java.util.Scanner;


public class VendingMachineUI {
	
	private VendingMachine vendingMachine;
	private static Scanner keyboardInput;
	private static int selection;
	private final static String[] menu = {"1. Add coins",
			"2. List items",
			"3. Select items",
			"4. Empty",
			"5. Restock and Quit",
			"6. Quit"};

	public VendingMachineUI(VendingMachine machine) {
		vendingMachine = machine;
		keyboardInput = new Scanner(System.in);
	}

	/*
	 * This method takes user input and pass it to validateSelection 
	 */
	private void getUserSelection() {
			try{
				selection = keyboardInput.nextInt();
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
	}
	
	/*
	 * This method prints menu in the machine UI
	 */
	private void displayMenu() {
		System.out.println("Please make your selection");
		for(String menuItem:menu) {
			System.out.println(menuItem);
		}
	}
   /*
    * Displays vending machine Menu in an infinite loop 
    * Loop breaks when user enter 5 which is code for quit
   */
	public void doMain() {
		try{
			do{
				displayMenu();
				System.out.println("Please enter your selection");
				getUserSelection();
				if(selection <= 0 || selection > 6) {
					System.out.println("Invalid selection,try again");
				}
				else {
						vendingMachine.performAction(selection,keyboardInput);
				  	if(VendingMachine.STATUS.FAILED == VendingMachine.status) {
						System.out.println("Transaction failed");
						return;
					}
					//getUserSelection();
				}
			}while(selection != 5 || selection != 6);		
			keyboardInput.close();
		}
		catch(InputMismatchException ex) {
			System.out.println("Invalid entry, please enter a valid selection");
		}
	}
}
