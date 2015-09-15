/**
 * 
 */
package com.ood.lab2.vendingMachine;

/**
 * @author Shweta
 * Contains Messages Displayed in Vending Machine
 *
 */
public interface Messages {
	public final static String starterMsg = "Please enter your selection.";
	public final static String selected = "You selected :";
	public final static String totalCost = "Total Cost: ";
	public final static String emptyVendingMachine = "No items in vending machine";
	public final static String selectItem="Please enter the serial number of item you want to buy";
	public final static String invalidSelection = "Please enter correct code";
	public final static String proceedInstruction = "Do you want to proceed? Enter Y or N";
	public final static String addCoins = "Please add coins";
	public final static String itemAddedInVendingMachine = "Item added in Vending machine. Item Details";
	public final static String itemName = "Item Name : ";
	public final static String itemPrice = "Item Price : ";
	public final static String itemQuantity = "Item Quantity : ";
	public final static String displayItems = "Displaying Items in vending machine";
	public final static String transactionCanceled = "Transaction canceled";
	public final static String transactionSuccessful = "Transaction Succeeded";
	public final static String transactionFailed = "Transaction Failed";
	public final static String dispensingMoney = "Dispensing Remaining Balance:";
	public final static String dispensingProduct = "Dispensing Product";
	public final static String continueMessage = "Do you want to continue";
	public final static String insufficientMoneyInMoneyBox = "Insufficient money in money box.Dispensing coins.";
	public final static String yes = "yes";
	public final static String no = "no";
	public final static String itemNotPresent  = "Item not present in inventory.Please add an entry in the database first";
	public final static String insufficientCoinsAddedByUser = "Insufficient amount.Please add more coins.Remaining balance :";
    public final static String transactionCanceledDueToInsufficientFunds = transactionCanceled + "Due to insufficient funds";
	public static final String moneyInTheMoneyBox = "Money in the money box";
}

