package com.ood.lab5.paintIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

public class MyIcon implements Icon {
	/*
	 * Creates an elliptical icon and fills it with the
	 *  color specified
	 */
	
	private Color color;

	public MyIcon(int iconSize) {
		size = iconSize;
	}
	
	public void setColor(Color colorToBeSet) {
		color = colorToBeSet;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D)g;
		Ellipse2D.Double ellipse = new Ellipse2D.Double(x,y,size,size);
		g2d.draw(ellipse);
		g2d.setColor(color);
		g2d.fill(ellipse);
	}

	private int size;

	@Override
	public int getIconHeight() {
		return size;
	}
	@Override
	public int getIconWidth() {
		return size;
	}
}
