package com.ood.lab5.car;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class MovingShape extends JFrame{
	JLabel label;
	MoveableShape shape;
	public MovingShape()
	{

		shape  = new CarShape(0, 0, CAR_WIDTH);

		ShapeIcon icon = new ShapeIcon(shape,
				ICON_WIDTH, ICON_HEIGHT);

		label = new JLabel(icon);
		setLayout(new FlowLayout());
		add(label);
		TimerC tL = new TimerC();
		Timer t = new Timer(DELAY, tL);

		t.start();
	}


	class TimerC implements ActionListener
	{

		public void actionPerformed(ActionEvent event)
		{
			shape.translate(1, 0);
			label.repaint();
		}

	}
	final int DELAY = 100;
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;

}

