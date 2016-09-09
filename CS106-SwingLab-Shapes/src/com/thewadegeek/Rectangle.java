package com.thewadegeek;

import java.awt.Graphics;
import java.awt.Point;

@SuppressWarnings("serial")
public class Rectangle extends Shape {

	public Rectangle(int x, int y, int height, int width) {
		super("Rectangle", x, y, height, width);
	}
	
	@Override
	public boolean contains(int x, int y) {
		return this.contains(new Point(x,y));
	}
	
	@Override
	public boolean contains(Point p) {
		if(p.getX() >= this.mX && p.getX() <= this.mX + this.mWidth) {
			if(p.getY() >= this.mY && p.getY() <= this.mY + this.mHeight) {
				return true;
			}	
		}
		return false;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(this.mBorderColor);
		g.fillRect(this.mX, this.mY, this.mWidth, this.mHeight);
		g.setColor(this.mFillColor);
		g.fillRect(this.mX+3, this.mY+3, this.mWidth-6, this.mHeight-6);
	}

}
