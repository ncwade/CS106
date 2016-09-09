package com.thewadegeek;

public class Circle implements Shape {
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2.0 * Math.PI * radius;
	}
	
	public double getRadius() {
		return this.radius;
	}

	@Override
	public boolean equals(Shape a) {
		boolean equal = false;
		if( a instanceof Circle) {
			equal = (((Circle) a).getRadius() == this.getRadius());
		}
		return equal;
	}

}
