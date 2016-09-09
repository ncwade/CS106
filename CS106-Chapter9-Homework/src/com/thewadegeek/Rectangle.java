package com.thewadegeek;

public class Rectangle implements Shape {
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}
	
	@Override 
	public double getPerimeter() {
		return 2.0 * (width + height);
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}

	@Override
	public boolean equals(Shape a) {
		boolean equal = false;
		if( a instanceof Rectangle) {
			equal = (((Rectangle) a).getHeight() == this.getHeight() && ((Rectangle) a).getWidth() == this.getWidth());
		}
		return equal;
	}
}
