package com.ood.lab6.Solution2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GraphView extends JComponent implements Observer  {

	/**
	 * Draws a bar graph based on values entered by user
	 * in text fields of Frame drawn by NumberView Class
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Subject subject;
	private static final int numberOfScores = 5;
	private static final int Xleft = 100;
	private static final int Xright = 300;
	private static final int Ytop = 100;
	private static final int Ybottom = 250;
	private static final int barWidth = 10;
	private JTextField[] textFields;
	int totalX,totalY;
	int[] scores;
	Rectangle2D rectangleBounds[];
	private Point mousePoint;
	private String mousePressedYCordinate;

	public GraphView(Subject s) {
		frame = new JFrame("Graph View");
		subject = s;
		textFields = ((DataModel)subject).getTextFields();;
		drawFrame();
		rectangleBounds = new Rectangle2D[NumberOfTextFields.NO_OF_TEXT_FIELD];
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent ev) {
				mousePoint = ev.getPoint();
				double minDistance = getDistance(mousePoint, rectangleBounds[0]);
				int translatingRectIndex = -1;
				for(int i = 0; i < rectangleBounds.length;i++) {
					if(rectangleBounds[i].contains(mousePoint)) {
						translatingRectIndex = i;
						break;
						}
					else {
						double distance = getDistance(mousePoint,rectangleBounds[i]); 
						if(minDistance > distance);
						minDistance =  distance;
						translatingRectIndex = i;
					}
				}
				if(translatingRectIndex!=-1) {
					mousePressedYCordinate = Integer.toString((int)mousePoint.getY()/20);
					textFields[translatingRectIndex].setText(mousePressedYCordinate);
					update(textFields);
					subject.notifyObservers();
				}
			}
		});
	}

	private double getDistance(Point point,Rectangle2D rectangle) {
		Point rectangleCord = new Point();
		rectangleCord.setLocation(rectangleCord.getLocation());
		return Math.abs(point.distance(rectangleCord));
	}

	private void drawFrame() {
		frame.add(new JLabel("Displaying bar Graph"));
		frame.add(this);
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void getScores() {	
		scores = new int[textFields.length];
		for(int i =0 ; i <scores.length;i++) {
			if(textFields[i].getText()!=null && !textFields[i].getText().equals("")) {
				scores[i] = Integer.parseInt(textFields[i].getText());
			}
			else {
				scores[i] = 0;
			}
			totalX = Xright - Xleft + 1;
			totalY = Ybottom - Ytop + 1;
		}
	}
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;				
		getScores();
		g2.setColor(Color.BLACK);
		g2.drawString("y axis", 170, 290);
		drawBarGraph(g2);
	}

	/*
	 * Draws a bar graph based on value provided in text fields 
	 * by user
	 */
	private void drawBarGraph(Graphics2D g) {
		int i, x, y, height, largestNumber, xIncrement, yIncrement;
		g.setColor(Color.blue);
		drawAxes(g);

		//Compute the x and y increments
		largestNumber = findLargest (scores);
		xIncrement = totalX /numberOfScores;
		if (largestNumber ==0)
			yIncrement = 0;
		else
			yIncrement = totalY / largestNumber;

		//Draw the bars
		for(i=0; i < numberOfScores; i++)
		{
			x = getXCoordinate(i+1, xIncrement);
			y = getYCoordinate(scores[i], yIncrement);
			x = x - barWidth / 2;
			height = Ybottom - y + 1;
			Rectangle2D.Double rectangle = 
					new Rectangle2D.Double(x, y, barWidth, height);
			g.fillRect(x,y,barWidth,height);
			rectangleBounds[i] = rectangle;
		}

		//Label x - axes with grade choices
		String [ ] label = {"A", "B", "C", "D", "F"};
		for(i=1; i<= numberOfScores; i++)
			g.drawString(label[i-1], 100+ i*xIncrement, 270);

		//Label y - axes with quantity of each grade
		int topy;
		if(largestNumber%10==0)
			topy=largestNumber;
		else
			topy=(largestNumber/10+1)*10;

		//i=i+5 controls y value label -- adjust for size of data
		for (i=0; i<=topy; i=i+5)
		{
			g.drawString(String.valueOf(i), 70, Ybottom-i*yIncrement+5);
		}
	}

	//Determining x coordinate
	public int getXCoordinate(int i, int xIncrement)
	{
		return Xleft + xIncrement *i;
	}
	//Determining y coordinate
	public int getYCoordinate(int numStudents, int yIncrement)
	{
		return Ybottom - yIncrement * numStudents;
	}
	//Finding the largest value in the array
	public int findLargest(int [ ] a)
	{
		int i;
		int loc = 0;
		for(i=1; i<a.length; i++)
			if(a[i]>a[loc])
				loc = i;
		return a[loc];
	}


	// Draws x and y axis
	private void drawAxes(Graphics2D g2) {
		g2.drawLine(Xleft, Ytop, Xleft, Ybottom);
		g2.drawLine(Xleft, Ybottom, Xright, Ybottom);
	}
	@Override
	public void update(JTextField[] data) {	
		frame.repaint();

	}
}
