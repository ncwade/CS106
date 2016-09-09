package com.thewadegeek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public abstract class Shape extends JComponent {
	protected int mX;
	protected int mY;
	protected int mHeight;
	protected int mWidth;
	protected Color mBorderColor;
	protected Color mFillColor;
	private String mShapeName;
	
	public Shape(String name, int x, int y, int height, int width) {
		this.mShapeName = name;
		this.mX = x;
		this.mY = y;
		this.mHeight = height;
		this.mWidth = width;
		super.setPreferredSize(new Dimension(this.mHeight,this.mWidth));
		super.setBounds(0,0,900,800);
	}
	
	public void setX(int x) {
		this.mX = x;
	}

	public void setY(int y) {
		this.mY = y;
	}

	public void setWidth(int width) {
		this.mWidth = width;
	}

	public void setHeight(int height) {
		this.mHeight = height;
	}

	public void setBorder(Color c) {
		mBorderColor = c;
	}

	public void setBackground(Color c) {
		mFillColor = c;
	}
	
	@Override
	public abstract boolean contains(int x, int y);
	
	@Override
	public abstract boolean contains(Point p);

	@Override
    public abstract void paintComponent(Graphics g);
    
    @Override
    public String toString() {
    	return mShapeName;
    }
}
