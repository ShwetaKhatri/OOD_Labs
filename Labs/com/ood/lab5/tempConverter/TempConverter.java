package com.ood.lab5.tempConverter;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TempConverter extends JFrame {

	/** TempConverter converters given temperature from 
	 *  Celsius to Fahrenheit and vice versa
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pNorth;
	private JPanel pSouth;
	private JLabel lFahrenheit;
	private JLabel lCelsius;
	private JTextField tFahrenhite;
	private JTextField tCelsius;
	private JButton bConvertToF;
	private JButton bConvToC;
	private JButton bClear;
	
	// Constants
	private final static String FRAME_TITLE = "Shweta Shweta";
	private final static String FAHRENHEIT = "Fahrenheit";
	private final static String CELSIUS = "Celsius";
	private final static String CONVERT_TO_F = "ConvToF";
	private final static String CONVERT_TO_C = "ConvToC";
	private final static String CLEAR = "Clear";
	private final Font font;
	
	/*
	 * Initializes variables and calls helper
	 * methods for laying out the GUI of Temperature
	 * Converter
	 */
	public TempConverter() {
		super(FRAME_TITLE);
		font = new Font("Times New Roman", Font.BOLD,18);
		
		pNorth = new JPanel();
		pSouth = new JPanel();
		
		//Labels
		lFahrenheit = new JLabel(FAHRENHEIT);
		lCelsius = new JLabel(CELSIUS);
		
		//Text Fields
		tFahrenhite = new JTextField();
		tCelsius = new JTextField();
		
		//Initialize buttons and add Listeners
		ButtonListener listener = new ButtonListener();		
		
		bConvertToF = new JButton(CONVERT_TO_F);
		bConvToC = new JButton(CONVERT_TO_C);
		bClear = new JButton(CLEAR);
		bConvertToF.addActionListener(listener);
		bConvToC.addActionListener(listener);
		bClear.addActionListener(listener);
		
		setFont();
		addNorth();
		addSouth();
		
	}
	
	/*
	 * Sets font of displayed Strings
	 */
	private void setFont() {
		lFahrenheit.setFont(font);
		lCelsius.setFont(font);
		bConvertToF.setFont(font);
		bConvToC.setFont(font);
		bClear.setFont(font);
	}
	/*
	 * Creates Grid Layout that is added to North of
	 * super Border Layout
	 */
	private void addNorth() {
		pNorth.setLayout(new GridLayout(2, 2));
		pNorth.add(lFahrenheit);
		pNorth.add(tFahrenhite);
		pNorth.add(lCelsius);
		pNorth.add(tCelsius);
		add(pNorth,BorderLayout.NORTH);
	}
	/*
	 * Creates Grid Layout that is added to South of 
	 * super Border Layout
	 */
	private void addSouth() {
		pSouth.setLayout(new GridLayout(1,3));
		pSouth.add(bConvertToF);
		pSouth.add(bConvToC);
		pSouth.add(bClear);	
		add(pSouth,BorderLayout.SOUTH);
	
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			try{
				
				Float inputValue; 
				Float outputValue;
				
				if(event.getSource() == bConvertToF) {
					inputValue = Float.parseFloat(tCelsius.getText());
					outputValue = (float) ((inputValue * 1.8) + 32);
				    tFahrenhite.setText(outputValue.toString() + "F");
				}
				else if(event.getSource() == bConvToC) {
					inputValue = Float.parseFloat(tFahrenhite.getText());
					outputValue = (float) ((inputValue - 32) / 1.8);
					tCelsius.setText(outputValue.toString() + "C");
				}
				else if(event.getSource() == bClear) {
					tCelsius.setText("");
					tFahrenhite.setText("");
				}
				else {
					// NO-OP
				}
			
			}
			catch(ArithmeticException ex) {
				throw new ArithmeticException("Integer Range exceeded");
			}
			catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Please enter numbers in appropriate text field");
				throw new NumberFormatException("Please enter numbers only");
				
			}
		}
		
	}
	
}
