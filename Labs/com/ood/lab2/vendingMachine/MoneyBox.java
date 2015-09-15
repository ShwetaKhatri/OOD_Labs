package com.ood.lab2.vendingMachine;
/*
 * @author Shweta
 * Acts as a cashier
 */
public class MoneyBox {
  
	private static float existingMoney;
	private static float coinsAddedInThisSession;
    
    public void addMoney(float coinsAdded) {
    	coinsAddedInThisSession = coinsAddedInThisSession + coinsAdded;
    	existingMoney = existingMoney + coinsAdded;
    }
    
    public float getCoinsAddedInThisSession() {
    	return coinsAddedInThisSession;
    }
    
    public void resetCoinsAddedInThisSession() {
    	coinsAddedInThisSession = 0;
    }
    
    public float getMoneyInMoneyBox() {
    	return existingMoney;
    }
    
    public float dispenseMoney(float balance) {
    	if(balance > existingMoney) {
    		System.out.println(Messages.insufficientMoneyInMoneyBox);
    		return balance;
    	}
    	existingMoney = existingMoney - balance;
    	return existingMoney;
    }
}
