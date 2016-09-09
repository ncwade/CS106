package com.thewadegeek;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;;

@SuppressWarnings("serial")
public class Ellipse extends Shape {
	private Ellipse2D.Double borderEllipse;
	private Ellipse2D.Double fillEllipse;
	
	public Ellipse(int x, int y, int height, int width) {
		super("Ellipse", x, y, height, width);
		borderEllipse = new Ellipse2D.Double(x,y,width,height);
		fillEllipse = new Ellipse2D.Double(x+2,y+2,width-4,height-4);
	}

	@Override
	public boolean contains(int x, int y) {
		return this.contains(new Point(x, y));
	}

	public boolean contains(Point p) {
		return borderEllipse.contains(p.getX(), p.getY());
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(this.mBorderColor);
		g2.fill(borderEllipse);
		g2.setColor(this.mFillColor);
		g2.fill(fillEllipse);
	}
}
