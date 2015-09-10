package com.ood.lab2.vendingMachine;

/**
 * @author Shweta
 * VendingMachineUI is responsible for displaying information to 
 * the User on the Screen
 *
 */
public class VendingMachineUI {

	private String vendingMachineItems;
	
	public VendingMachineUI(String items) {
		vendingMachineItems = items;
	}
	/*
	 * Displays the items in vending machine
	 */
	public void displayVendingMachineItems() {
		System.out.println(vendingMachineItems);
	}
	
	public void displaySelection(Item item) {
		System.out.println(Strings.selected + item);
		System.out.println(Strings.totalCost + item.getItemPrice() +"$\n");
	}
	
	public void displayMessage(String message) {
		System.out.println(message);
	}
}
