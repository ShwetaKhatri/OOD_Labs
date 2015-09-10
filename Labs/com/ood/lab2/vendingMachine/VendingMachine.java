package com.ood.lab2.vendingMachine;

import java.util.Scanner;

/*
 * @author Shweta
 * Responsibilities - Takes user input
 * Takes user coins
 * Dispenses product or coins 
 */
public class VendingMachine {
	
	private enum STATUS {
		FAIL,SUCCESSFUL;
	}
	private static VendingMachineItems vendingMachineItems;
	private static MoneyBox moneyBox;
    private int selection;
	private Scanner keyboardInput;
	private static STATUS transactionStatus;
	  
	public VendingMachine() {
		vendingMachineItems = new VendingMachineItems();
		moneyBox = new MoneyBox();
		selection = -1;
		keyboardInput = new Scanner(System.in);
		transactionStatus = STATUS.SUCCESSFUL;
	}

	public Scanner getKeyboardInput() {
		return keyboardInput;
	}

	public VendingMachineItems getVendingMachineItems() {
		return vendingMachineItems;
	}

	public MoneyBox getMoneyBox() {
		return moneyBox;
	}
	
	public void getUserInput() {
		selection = keyboardInput.nextInt();
	}
	
	public boolean validateInput() {
		int numberofItemsInVending = vendingMachineItems.itemCount();
		if(selection <= 0 || selection > numberofItemsInVending) {
			return false;
		}
		return true;
	}
	
	public Item getItem() {
		return vendingMachineItems.getItem(selection - 1 );
	}
	
	public Item getItem(String itemName) {
		return vendingMachineItems.getItem(itemName);
	}
	
	public void dispenseItem(Item selectedItem) {
		if(!vendingMachineItems.inStock(selectedItem)) {
			transactionStatus = STATUS.FAIL;
		    System.out.println("Item " + selectedItem + " is out of stock");
			return;
		}
		else {
			int itemQuantity = selectedItem.getItemQuantity();
			selectedItem.setItemQuantity(--itemQuantity);
			System.out.println(Messages.dispensingProduct + " " + selectedItem.getItemName());
			transactionStatus = STATUS.SUCCESSFUL;
		}
	}
	
	public boolean transactionSuccessful() {
		if (transactionStatus  == STATUS.FAIL) {
			return false;
		}
		return true;
	}

	public void addCoins() {
		float coins = keyboardInput.nextFloat();
		moneyBox.addMoney(coins);
	}
	
	public void validateMoney() {
		Item item = getItem();
		float itemPrice = item.getItemPrice();
		float moneyAddedByUser = moneyBox.getCoinsAddedInThisSession();;
		float remainingBalance;
		if(moneyAddedByUser == itemPrice) {
			remainingBalance = 0.0f;
			moneyBox.addMoney(moneyAddedByUser);
			moneyBox.resetCoinsAddedInThisSession();
			return;
		}
		else if(moneyAddedByUser < item.getItemPrice()) {
			remainingBalance = itemPrice - moneyAddedByUser;
			System.out.print(Messages.insufficientCoinsAddedByUser);
			System.out.println(remainingBalance);
		    addCoins();
			validateMoney();
		}
		else {
			remainingBalance = moneyAddedByUser - itemPrice;
			System.out.println(Messages.dispensingMoney +  remainingBalance);
			moneyBox.dispenseMoney(remainingBalance);
			moneyBox.resetCoinsAddedInThisSession();
			return;
		}
	}
	
	
   public void displayItem() {
	   System.out.println(Messages.displayItems);
	   System.out.println(vendingMachineItems.toString());
   }
} 