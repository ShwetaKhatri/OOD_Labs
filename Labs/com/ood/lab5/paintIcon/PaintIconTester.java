package com.ood.lab5.paintIcon;

import javax.swing.JFrame;

public class PaintIconTester {
	public static void main(String[] args) {

		PaintIcon paintIcon = new PaintIcon();
		paintIcon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paintIcon.setSize(400, 400);
		paintIcon.setVisible(true);
	}
}
