package com.thewadegeek;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

@SuppressWarnings("serial")
public class Triangle extends Shape {
	private Polygon fillGon;
	private Polygon borderGon;
	
	public Triangle(int x, int y, int height, int width) {
		super("Triangle", x, y, height, width);
		int[] xPoints = {
			(this.mX + (this.mWidth/2)),
			(this.mX),
			(this.mX+this.mWidth)
		};
		int[] yPoints = {
			(this.mY),
			(this.mY + this.mHeight),
			(this.mY+this.mHeight)
		};
		borderGon = new Polygon(xPoints, yPoints, 3);
		
		int[] fillXPoints = {
			(this.mX + (this.mWidth/2)),
			(this.mX) + 3,
			(this.mX+this.mWidth) - 3
		};
		int[] fillYPoints = {
			(this.mY) + 6,
			(this.mY + this.mHeight) - 2,
			(this.mY + this.mHeight) - 2
		};
		fillGon = new Polygon(fillXPoints,fillYPoints,3);
	}

	@Override
	public boolean contains(int x, int y) {
		return this.contains(new Point(x,y));
	}
	
	@Override
	public boolean contains(Point p) {
		return borderGon.contains(p);
	}


	@Override
	public void paintComponent(Graphics g) {
		g.setColor(this.mBorderColor);
		g.fillPolygon(borderGon);
		g.setColor(this.mFillColor);
		g.fillPolygon(fillGon);
	}
}
