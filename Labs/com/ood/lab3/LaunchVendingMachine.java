package com.ood.lab3;

public class LaunchVendingMachine {
	
	//TestCases
	public static void testListItems() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine machine = new VendingMachine();
		VendingMachineUI ui = new VendingMachineUI(machine);
		ui.doMain();
	}

}
