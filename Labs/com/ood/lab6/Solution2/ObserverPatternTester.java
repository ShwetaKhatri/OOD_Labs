package com.ood.lab6.Solution2;

public class ObserverPatternTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject subject = new DataModel();
		Observer observer1 = new NumberView(subject);
		Observer observer2 = new GraphView(subject);
		subject.attachObserver(observer1);
		subject.attachObserver(observer2);		
	}
}
