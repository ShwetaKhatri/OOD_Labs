package com.ood.lab6.Solution2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class DataModel implements Subject, NumberOfTextFields{

	private ArrayList<Observer> observers;
	private JTextField[] textFields;
	private int count;
	private TextFieldListener listener;

	public DataModel(){
		observers = new ArrayList<Observer>();
		count = NumberOfTextFields.NO_OF_TEXT_FIELD;
		textFields = new JTextField[count];
		listener = new TextFieldListener();
		initializeTextFields();
	}

	@Override
	public void attachObserver(Observer o) {
		if(o != null && !observers.contains(o)) {
			observers.add(o);
		}
	}

	@Override
	public void detachObserver(Observer o) {
		if(observers.contains(o)) {
			observers.remove(o);
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers) {
			o.update(textFields);
		}	
	}

	private class TextFieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(JTextField text : textFields) {
				if(e.getSource() == text) {
					notifyObservers();
				}
			}
		}
	}
	
	private void initializeTextFields() {
		for(int i = 0; i < count ; i++) {
			textFields[i] = new JTextField("10", 4);
			textFields[i].addActionListener(listener);
		}
	}
	public void setTextFields(JTextField[] textFields) {
		this.textFields = textFields;
	}
	
	public JTextField[] getTextFields() {
		return textFields;
	}

}
