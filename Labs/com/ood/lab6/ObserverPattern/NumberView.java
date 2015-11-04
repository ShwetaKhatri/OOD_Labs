package com.ood.lab6.ObserverPattern;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberView extends Subject {

	/*
	 * Represents a Grid like structure that takes coordinates
	 * from user in tabular form
	 */

	private int noOfTextFields;
	private JTextField[] textFields;
	private JLabel[] labels;
	private TextChangeListener listener;
	private JFrame frame;
	private final Font font;
	
	public NumberView(int noOftxtFields) {
		noOfTextFields = noOftxtFields;
		frame  = new JFrame("Number View");
		textFields = new JTextField[noOfTextFields];
	    labels = new JLabel[noOfTextFields];
	    font = new Font("Times New Roman", Font.BOLD,18);
	    listener = new TextChangeListener();
	    drawNumberView();
	 	}
	
	private void drawNumberView() {
		initializeLabels();
		initializeTextFields();
		setFont();
		setListeners(listener);
		drawFrame();
	}

	/*
	 * Creates Frame
	 */
	
	public void drawFrame() {
		JLabel instructions = new JLabel("Please enter co-ordinates in the table");
		instructions.setFont(font);
		frame.setSize(400, 400);
		frame.setLayout(new BorderLayout());
		frame.add(instructions,BorderLayout.NORTH);
		frame.add(addTable(),BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	/*
	 * Assigns text to each label.
	 */
	private void initializeLabels() {
		labels[0] = new JLabel("A");
		labels[1] = new JLabel("B");
		labels[2] = new JLabel("C");
		labels[3] = new JLabel("D");
		labels[4] = new JLabel("E");
	}
	
	private void setFont() {
		for(int i =0;i< noOfTextFields; i++) {
			labels[i].setFont(font);
			textFields[i].setFont(font);
		}
	}
	
	private void initializeTextFields() {
		for(int i = 0; i<textFields.length;i++) {
			textFields[i] = new JTextField(4);
		}
	}
	
	private JPanel addTable() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 2));
		
		// Adding Row header "Space a b c"
		for(int i = 0; i < textFields.length ;i++) {
			panel.add(labels[i]);
			panel.add(textFields[i]);
		}
		return panel;
	}
	
	private void setListeners(TextChangeListener listener) {
		for(int i = 0; i<textFields.length;i++) {
			textFields[i].addActionListener(listener);
		}
	}
	
	private class TextChangeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			for(int i=0; i < textFields.length ;i++) {
				if(event.getSource().equals(textFields[i])) {
					notifyObservers();
				}
			}
		}
	}
	
	public JTextField[] getTextFields() {
		return textFields.clone();
	}
	
}
