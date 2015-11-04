package com.ood.lab5.car;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Car implements Drawable {
	
	/*
	 * Represents a Car and its components
	 */
	private Rectangle2D.Double body;
    private Ellipse2D.Double frontTire;
    private Ellipse2D.Double rearTire;
    private Line2D.Double frontWindshield;
    private Line2D.Double roofTop;
    private Line2D.Double rearWindshield;
    
    /*
     *@param carBody
     *@param carFrontTire
     *@param carRearTire
     *@param carFrontWindshield
     *@param carRoofTop
     *@param carRearWindshield 
     */

    public Car(Rectangle2D.Double carBody,Ellipse2D.Double carFrontTire,
    		Ellipse2D.Double carRearTire, Line2D.Double carFrontWindshield,
    		Line2D.Double carRoofTop,Line2D.Double carRearWindshield) {
		body = carBody;
		frontTire = carFrontTire;
		rearTire = carRearTire;
		frontWindshield  = carFrontWindshield;
		roofTop  = carRoofTop;
		rearWindshield = carRearWindshield;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		      g2.draw(body);
		      g2.draw(frontTire);
		      g2.draw(rearTire);
		      g2.setColor(Color.red);
		      g2.draw(frontWindshield);
		      g2.draw(roofTop);
		      g2.draw(rearWindshield);	 
	}
}
