package com.ood.lab6.Solution2;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NumberView extends JFrame  implements Observer  {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField[] textFields;
	private JLabel[] labels;
	private Subject dataModel;
	private JFrame frame;
	
	public NumberView(Subject model) {
		dataModel = model; 
		textFields = ((DataModel) dataModel).getTextFields();
		frame= new JFrame("Number View");
		labels = new JLabel[textFields.length];
		displayNumberView();
	}
	
	private void displayNumberView() {
		frame.setLayout(new GridLayout(textFields.length,2, 4, 10));
		addTextFieldsToFrame();
		setFrameOperation();
	}

	private void addTextFieldsToFrame() {
		int i =0;
		char startChar = 'A';
		for(JTextField textFields : textFields){
			String labelString = String.valueOf(startChar++);
			labels[i] = new JLabel(labelString);
			frame.add(labels[i]);
			frame.add(textFields);
		}
	}
	
	private void setFrameOperation() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
		
	@Override
	public void update(JTextField[] data) {
		((DataModel) dataModel).setTextFields(data);
	//	repaint();
		
	}
}
