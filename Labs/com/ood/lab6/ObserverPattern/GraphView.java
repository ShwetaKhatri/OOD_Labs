package com.ood.lab6.ObserverPattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GraphView  extends JPanel implements Observer {

	/**
	 * This class is an observer class repaints itself
	 * when subject sends a notification
	 * Logic on how to draw Bar Graph has been referenced from
	 * http://mathbits.com/MathBits/Java/Graphics/linegraphonly.htm 
	 */
	
	//Constants used in the program
	private static final long serialVersionUID = 1L;
	private static final int numberOfScores = 5;
	private static final int Xleft = 100;
	private static final int Xright = 300;
	private static final int Ytop = 100;
	private static final int Ybottom = 250;
	private static final int barWidth = 10;
	private JFrame frame;
	int totalX,totalY;
	int[] scores;
	private Subject subject;

	/*
	 * Constructor attaches itself to the subject
	 * @param title - title of frame window
	 * @param s - subject that notifies GraphView of
	 * changes in the data
	 */
	public GraphView(String title,Subject s) {
		subject = s;
		subject.attach(this);
		frame = new JFrame(title);
		drawGraph();	
	}

	// Detach itself from subject
	public void detach() {
		subject.detach(this);
	}
	
	/* Get scores entered by User in the text Fields and
	also compute the total of x and y co-ordinates.
	In case text field is empty assign 0 by default */
	
	private void getScores() {
		JTextField[] text = ((NumberView)subject).getTextFields();
		scores = new int[text.length];
		for(int i =0 ; i <scores.length;i++) {
			if(text[i].getText()!=null && !text[i].getText().equals("")) {
				scores[i] = Integer.parseInt(text[i].getText());
			}
			else {
				scores[i] = 0;
			}
			totalX = Xright - Xleft + 1;
			totalY = Ybottom - Ytop + 1;
		}
	}
	
	//Generates a Frame UI of BorderLayout with Graph as the center
	private void drawGraph() {
		frame.setSize(400, 600);
		frame.setLayout(new BorderLayout());
		frame.add(this,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
		g.setColor(Color.blue);
		drawAxes(g);
		int i, x, y, height, largestNumber, xIncrement, yIncrement;

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
			g.fillRect(x, y, barWidth, height);
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
	public void Update(Subject subjectToBeUpdated) {
		if(subjectToBeUpdated == subject) {
			frame.repaint();
		}

	}

}
