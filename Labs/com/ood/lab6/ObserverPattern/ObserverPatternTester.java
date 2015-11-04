package com.ood.lab6.ObserverPattern;


public class ObserverPatternTester {
	private static final int noOfTextFields = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberView subject = new NumberView(noOfTextFields);
		GraphView frame = new GraphView("Graph View",subject);		

	}

}
