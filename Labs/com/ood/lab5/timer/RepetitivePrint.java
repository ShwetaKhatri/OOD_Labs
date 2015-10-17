package com.ood.lab5.timer;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

public class RepetitivePrint {
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Shweta Shweta");
		final int DELAY = 1000; // 1000 milliseconds delay between action events
		
		final JTextField textField = new JTextField(40);
		frame.setLayout(new FlowLayout());
		
		frame.add(textField);
		frame.setSize(500,500);
		
		ActionListener listener = new ActionListener(){
			@Override
			    public void actionPerformed(ActionEvent e) {
				   textField.setText("Hello,World");
				}
		};
		
		
		Timer t = new Timer(DELAY, listener);
		t.start();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//frame.pack();
	}

	    
}

