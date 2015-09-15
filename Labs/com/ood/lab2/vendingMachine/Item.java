package com.ood.lab2.vendingMachine;

/*
 * @author Shweta
 * This class represents a customized data structure that stores
 *  name,price and quantity of an item in vending machine
*/
class Item {
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	private String itemName;
	private int itemQuantity;
	private float itemPrice;
	
	@Override
	public boolean equals(Object obj) {
		Item item = (Item) obj;
		if(this.itemName.equalsIgnoreCase(item.itemName)) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return itemName;
	}
}

