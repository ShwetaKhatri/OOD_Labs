package com.ood.lab6.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	private List<Observer> observers;
	
	public Subject() {
		observers = new ArrayList<Observer>();
	}
	
	/*
	 * @param observer, new observer to be attached to
	 * the list of observers
	 */
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	/*
	 * @param onserver, observer to be detached from the
	 * list of observers
	 */
	public void detach(Observer observer) {
		try{
			observers.remove(observer);
		}
		catch(NullPointerException ex) {
			ex.printStackTrace();
		}
	}
	/*
	 * Notifies all the observers in the list that 
	 * subject has changed
	 */
	public void notifyObservers() {
		for(Observer observer:observers) {
			observer.Update(this);
		}
	}
	

}
