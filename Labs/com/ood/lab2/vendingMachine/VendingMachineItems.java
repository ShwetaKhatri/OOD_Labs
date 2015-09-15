package com.ood.lab2.vendingMachine;

import java.util.ArrayList;

/**
 * @author Shweta
 * This class maintains an inventory of all the items in the
 * Vending machine  
 *
 */
public class VendingMachineItems {

	private ArrayList<Item> items = new ArrayList<Item>();

	public ArrayList<Item> getItems() {
		if(items == null) {
			items = new ArrayList<Item>();
		}
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	/*
	 * Takes and item and checks whether it is in stock or not
	 * @param item - Item 
	 * @return boolean
	 */
	public boolean inStock(Item item) {
		if(item.getItemQuantity() == 0) {
			return false;
		}
		return true;
	}
	
	/*
	 * Returns an item based on selection
	 * @param - index of the Item selected
	 * @return - Item returned on that index
	 */
	public Item getItem(int index) {
		return items.get(index);
	}
	
	public Item getItem(String itemName) {
		Item itemMatched = new Item();
		for(Item item:items) {
			if(item.getItemName().equalsIgnoreCase(itemName)) {
				itemMatched = item;
			}
		}
		return itemMatched;
	}
	
	public int itemCount() {
		return items.size();
	}

	@Override
	public String toString() {
		String itemsInVendingMachine = "1. " + items.get(0).toString() + "\n";	;
		try{
			for(int i = 1; i < items.size() ; i++) {
				itemsInVendingMachine = itemsInVendingMachine + (i + 1) + ". " 
			     + items.get(i).toString()+ "\n";
			}
		}
		catch(Exception  ex) {
			System.out.println(Messages.emptyVendingMachine);
		}
		return itemsInVendingMachine;
	}
}
