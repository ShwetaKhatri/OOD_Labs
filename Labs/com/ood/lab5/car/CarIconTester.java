package com.ood.lab5.car;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class CarIconTester {
	public static void showMessageDialog(
			Component parent,
			Object message,
			String title,
			int messageType,
			Icon anIcon) {
		JOptionPane.showMessageDialog(parent, message,title,messageType,anIcon);
	}

	public static void main(String[] args) {
		Icon icon = new CarIcon(200);
		CarIconTester.showMessageDialog(null, //parent window
				"Car Icon Demo", // message to be displayed
				"Shweta Shweta", // Window title
				JOptionPane.INFORMATION_MESSAGE, //Type of panel
				icon);

	}

}
