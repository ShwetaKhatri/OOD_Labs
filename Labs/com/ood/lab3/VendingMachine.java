package com.ood.lab3;

import java.lang.management.MemoryNotificationInfo;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Shweta
 * This class is responsible for listing items in a venfing machine,
 * validating selection and emptying the money box
 */
public class VendingMachine {
	/*
	 * VendingMachineItem is a customized data type that stores
	 * details about item in vending machine
	 */
	class VendingMachineItem{
		String itemName;
		float itemPrice;
		int itemQuantity;
		
		public VendingMachineItem(String name, float price, int quantity) {
			itemName = name;
			itemPrice = price;
			itemQuantity = quantity;
		}
	}
	public enum STATUS{
		SUCCESSFUL, FAILED;
	}

	// Defining global member variables

	private ArrayList<VendingMachineItem> items;
	public static STATUS status;  
	private static final int RESTOCK_QUANTITY = 10;
    private static MoneyBox moneyBox;
    private static VendingMachineItem selectedItem;
    private static final float MIN_SUFFICIENT_AMOUNT = 2.5f;
	
	public VendingMachine() {
		items = new ArrayList<VendingMachineItem>();
		moneyBox = new MoneyBox();
		addItemsInVendingMachine();
	}
	
	/*
	 * This method is responsible for displaying items in a vending machine
	 */
	public void listItems() {
		System.out.println("Items in vending machine are:");
		int serialNo = 0;
		for(VendingMachineItem item:items) {
			System.out.println(++serialNo + "." + item.itemName );
		}
	}
	
	
	/*
	 * This method whether the selection done by user is valid or not.Primarly
	 * it checks the following condition:
	 * 1. Serial number of the item selected is within items array
	 * 2. User input is a number
	 * @param index of item selected
	 * @return boolean, true if selection is valid else false
	 */
	public boolean validateInput(int selection) {
		int numberofItemsInVending = items.size();
		if(selection <= 0 || selection > numberofItemsInVending) {
			return false;
		}
		return true;
	}
	
	
	/*
	 * Vending machine comes with pre-defined items. This method is responsible for
	 * adding some default items in vending machine. It is called in constructor
	 */
	
	private void addItemsInVendingMachine() {
		VendingMachineItem mixedJuice = new VendingMachineItem("Mixed Juice",3.5f,10);
		VendingMachineItem orangeJuice = new VendingMachineItem("Orange Juice",3.5f,10);
		VendingMachineItem gatorade = new VendingMachineItem("Gatorade",3.5f,10);
		VendingMachineItem mangoJuice = new VendingMachineItem("Mango Juice",2.5f,10);
		VendingMachineItem water = new VendingMachineItem("Water",2.5f,10);
		VendingMachineItem coffee = new VendingMachineItem("Coffee",2.5f,10);
		items.add(mixedJuice);
		items.add(orangeJuice);
		items.add(gatorade);
		items.add(mangoJuice);
		items.add(water);
		items.add(coffee);		
	}

	/*
	 * @param - integer, menu item selected by user
	 */
	public void performAction(int selection,Scanner keyBoardInput) {
		switch(selection){
		case 1 : addCoins(keyBoardInput);break;
		case 2 : listItems();break;
		case 3 : System.out.println("Please enter the serial number of items you wish to purchase");
		selectItem(keyBoardInput);break;
		case 4 : emptyMoneyBox();break;
		case 5 : restockAndQuit();break;
		case 6 : quit();break;
		default://no-op
		}
	}

	private void quit() {
		System.out.println("Transaction finished");		
		float balance = moneyBox.getMoneyInMoneyBox() -  moneyBox.getCoinsAddedInThisSession();
		System.out.println("Dispensing balance :" + balance );
		System.exit(0);
	}

	private void restockAndQuit() {
		System.out.println("Restocking items");
		try{
			for(VendingMachineItem item:items) {
				item.itemQuantity = item.itemQuantity + RESTOCK_QUANTITY;
			}		
			System.out.println("Restock finished,exiting now");
             status = STATUS.SUCCESSFUL;			
		}
		catch(Exception ex) {
			status = STATUS.FAILED;
		}
		System.exit(0);
		
	}

	private void emptyMoneyBox() {
		moneyBox.dispenseMoney(moneyBox.getMoneyInMoneyBox());
	}
	
	private boolean inStock(VendingMachineItem item) {
		if(item.itemQuantity ==0) {
			return false;
		}
		return true;
	}
    /*
     * This function prompts user to select an item from vending machine.
     * After checking that the input is valid, it checks if the item is in stock 
     * or not.If the item is in stock and sufficient amount is added , it dispenses
     * the item and remaining balance, if the item is not in stock it requests user
     * to select another item and repeat the procedure
     * @param - Item code input form user
     */
	private void selectItem(Scanner keyBoardInput) {		
		int index = keyBoardInput.nextInt();
		if(!validateInput(index)) {
			// Check whether the selected item is present in vending machine or not
			System.out.println("Invalid selection,plese try again");
			status = STATUS.FAILED;
		}
		else {
			selectedItem = items.get(index);
		}
		System.out.println("You have selected " + selectedItem.itemName + ".Price of the item is :" + selectedItem.itemPrice);
		//Check if the item is in stock
		if(!inStock(selectedItem)) {
			System.out.println("Item out of stock.Please select some other item");
			status = STATUS.FAILED;
			selectItem(keyBoardInput);
		}
		if(moneyBox.getCoinsAddedInThisSession() < selectedItem.itemPrice) {
			status = STATUS.FAILED;
			addCoins(keyBoardInput);
		}
		// Dispense item and remaining balance
		if(status == STATUS.SUCCESSFUL) {
			 System.out.println("Dispensing item :" + selectedItem.itemName);
             selectedItem.itemQuantity--;
			 status = STATUS.SUCCESSFUL;
		}	
	}
	/*
	 * This function takes coins from user and handles the following cases
	 * Case 1 -  If sum of all the coins added in a session by user is less than 
	 * the minimum price allowed in vending machine for dispensing an item,
	 * than ask for more coins until the amount becomes equal or more 
	 * than the minimum sufficient amount
	 * Case 2 -  if sum of all the coins added in a session is greater than or equal to
	 * the minimum price allowed in vending machine for dispensing an item,then
	 * inform the vending machine system to dispense item when user selects option 3
	 * in the menu  by setting status as successful.
	 */
	private void addCoins(Scanner keyboardInput) {
		System.out.println("Please enter coins"); 
		float coinsAdded = Float.parseFloat(keyboardInput.next());
		moneyBox.addMoney(coinsAdded);
		float totalCoinsAddedInThisSession = moneyBox.getCoinsAddedInThisSession();
		System.out.println("Total amount added in this session " + totalCoinsAddedInThisSession);
		
		if(totalCoinsAddedInThisSession <  MIN_SUFFICIENT_AMOUNT) {
			float remainingAmount = MIN_SUFFICIENT_AMOUNT - totalCoinsAddedInThisSession;
			System.out.println("Insufficient amount.Please add " + remainingAmount + "$" );
			addCoins(keyboardInput);	
			status = STATUS.FAILED;
		}
		else if (totalCoinsAddedInThisSession >= MIN_SUFFICIENT_AMOUNT) {
			 System.out.println("Please select an item");
		     status = STATUS.SUCCESSFUL;
		     return;
		}
	}
}
