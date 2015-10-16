package com.ood.lab5.car;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   A class for using buttons to change the size of an icon.
*/
public class ActionTester
{
   /**
      Allows the user to change the size of a car icon by pressing a button
      @param args unused
   */
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 20;

      JButton zoomInButton = new JButton("ZoomIn");

      zoomInButton.addActionListener(
         createZoomButtonListener(1.1));

      JButton zoomOutButton = new JButton("ZoomOut");

      zoomOutButton.addActionListener(
         createZoomButtonListener(0.9));


      icon = new CarIcon(100);
     // label = new JLabel(icon);

      frame.setLayout(new FlowLayout());

      frame.add(zoomInButton);
      frame.add(zoomOutButton);
      frame.add(label);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // frame.pack();
      frame.setSize(400,400);
      frame.setVisible(true);
   }

   /**
      Creates an action listener for a button that changes the width of
      an icon.  The
      @param factor the factor to multiply by to find the new width
   */
   public static ActionListener createZoomButtonListener(
      final double factor)
   {
      return new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               int newWidth = (int) (factor * icon.getIconWidth());
               if (newWidth < 10)
                  newWidth = 10;
               icon.setIconWidth(newWidth);
               label.repaint();
            }
         };
   }

   private static CarIcon icon;
   private static JLabel label;

}

