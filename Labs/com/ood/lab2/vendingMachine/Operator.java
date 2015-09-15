package com.ood.lab2.vendingMachine;

public class Operator {
	
	private VendingMachine machine;
	
	public Operator(VendingMachine vendingMachine) {
		machine = vendingMachine;
	}

	public void stockNewItems(String itemsName, int itemsCount, float itemsPrice) {
		// TODO Auto-generated method stub
		Item item =  new Item();
		item.setItemName(itemsName);
		item.setItemQuantity(itemsCount);
		item.setItemPrice(itemsPrice);
		machine.getVendingMachineItems().getItems().add(item);
//		System.out.println(Messages.itemAddedInVendingMachine);
//		System.out.println(Messages.itemName + itemsName);
//		System.out.println(Messages.itemPrice + itemsPrice);
//		System.out.println(Messages.itemQuantity + itemsCount);
	}
	
	public void restockItem(String itemName, int itemCount) {
		Item item = machine.getItem(itemName);
		try{
			item.setItemQuantity(item.getItemQuantity() + itemCount);			
		}
		catch(Exception ex) {
			System.out.println(Messages.itemNotPresent);
		}		
	}
	
	public void emptyMoneyBox() {
		MoneyBox moneybox = machine.getMoneyBox();
		moneybox.dispenseMoney(moneybox.getMoneyInMoneyBox());
	}

}
