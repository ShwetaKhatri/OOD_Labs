package com.ood.lab6.Solution2;

public interface Subject {

	public void attachObserver(Observer o);
	
	public void detachObserver(Observer o);
	
	public void notifyObservers();
	
}
