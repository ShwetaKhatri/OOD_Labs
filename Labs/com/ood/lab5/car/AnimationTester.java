package com.ood.lab5.car;

import javax.swing.*;


/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
	
   public static void main(String[] args)
   {
	   
      MovingShape frame = new MovingShape();     
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
     
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
