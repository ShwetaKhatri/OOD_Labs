package com.ood.lab5.car;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
	public static void showMessageDialog(
			Component parent,
			Object message,
			String title,
			int messageType,
			Icon anIcon) {
	JOptionPane.showMessageDialog(parent, message,title,messageType,anIcon);
	}
   public static void main(String[] args)
   {
	   
//      MovingShape frame = new MovingShape();     
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.pack();
//      frame.setVisible(true);
      
      Icon icon = new CarIcon(200);
      AnimationTester.showMessageDialog(null, //parent window
				"How is it going?", // message to be displayed
				"Message", // Window title
				JOptionPane.INFORMATION_MESSAGE, //Type of panel
				icon);
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
