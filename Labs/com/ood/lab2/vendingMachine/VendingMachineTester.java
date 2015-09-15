package com.ood.lab2.vendingMachine;
/**
 * @author Shweta
 * This class is responsible for launching application
 * It stocks items in vending machine and executes the 
 * vending process
 *
 */
public class VendingMachineTester {

	private final static int[] itemsCount = {2,2,2};
	private final static String[] itemsName = {"Coke","Chips","Water"};
	private final static float[] itemsPrice = {2.50f,1.50f,2.00f};
	private static Item selectedItem;
	private static String continueVending;
	
	private static void launchApplication() {
		try{
			VendingMachine  vendingMachine = new VendingMachine();
			Operator operator = new Operator(vendingMachine);
			operator.stockNewItems(itemsName[0], itemsCount[0], itemsPrice[0]);
			operator.stockNewItems(itemsName[1], itemsCount[1], itemsPrice[1]);
			operator.stockNewItems(itemsName[2], itemsCount[2], itemsPrice[2]);
			do {
				vendingMachine.displayItem();
				System.out.println(Messages.selectItem);
				vendingMachine.getUserInput();
				if (vendingMachine.validateInput()) {
					selectedItem = vendingMachine.getItem();
				}
				else{
					System.out.println(Messages.invalidSelection);
					return;
				}
				System.out.println(Messages.selected + selectedItem.getItemName());
				System.out.println(Messages.totalCost + selectedItem.getItemPrice());
				System.out.println(Messages.addCoins);
			    vendingMachine.addCoins();
				System.out.println(Messages.proceedInstruction);
				String answer = vendingMachine.getKeyboardInput().next();
				if(answer.equalsIgnoreCase(Messages.yes) || answer.equalsIgnoreCase("y")) {
					vendingMachine.validateMoney();
					vendingMachine.dispenseItem(selectedItem);
					if(vendingMachine.transactionSuccessful()) {
						System.out.println(Messages.transactionSuccessful);			
					}
					else {
						System.out.println(Messages.transactionFailed);
					    return;
					}
				}
				else if(answer.equalsIgnoreCase(Messages.no) || answer.equalsIgnoreCase("n")) {
					System.out.println(Messages.transactionCanceled);
					System.out.println(Messages.dispensingMoney);
					System.out.println(vendingMachine.getMoneyBox().getCoinsAddedInThisSession());
					vendingMachine.getMoneyBox().dispenseMoney(vendingMachine.getMoneyBox().getMoneyInMoneyBox());
					System.out.println(Messages.moneyInTheMoneyBox + vendingMachine.getMoneyBox().getMoneyInMoneyBox());
				    return;
				}
				else {
					System.out.println(Messages.invalidSelection);
					return;
				}
				System.out.println(Messages.continueMessage);
				continueVending = vendingMachine.getKeyboardInput().next();
			}while(continueVending.equalsIgnoreCase("y"));
			System.out.println("Money in Money Box :" + vendingMachine.getMoneyBox().getMoneyInMoneyBox());
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchApplication();
	}
}
