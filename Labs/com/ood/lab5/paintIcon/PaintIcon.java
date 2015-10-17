package com.ood.lab5.paintIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintIcon extends JFrame {

	private JPanel buttons;
	private JButton bRed;
	private JButton bGreen;
	private JButton bBlue;
	private MyIcon icon;
	private JLabel label;
	private final static int ICON_SIZE = 200;

	public PaintIcon() {
		super("Shweta Shweta");
		icon = new MyIcon(ICON_SIZE);
		icon.setColor(Color.red);
		bRed = new JButton("Red");
		bGreen = new JButton("Green");
		bBlue = new JButton("Blue");

		buttons = new JPanel(new FlowLayout());
		buttons.add(bRed);
		buttons.add(bGreen);
		buttons.add(bBlue);

		// Adding Listeners
		ButtonListener b1 = new ButtonListener();
		bRed.addActionListener(b1);
		bGreen.addActionListener(b1);
		bBlue.addActionListener(b1);

		add(buttons,BorderLayout.SOUTH);
		label = new JLabel(icon);
		add(label,BorderLayout.CENTER);

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == bRed) {
				icon.setColor(Color.RED);
				label.repaint();
			}
			else if (event.getSource() == bGreen) {
				icon.setColor(Color.GREEN);
				label.repaint();
			}
			else if (event.getSource() == bBlue) {
				icon.setColor(Color.BLUE);
				label.repaint();
			}
			else {
				// No - op
			}
		}

	}

}
