package com.thewadegeek;

public class Triangle implements Shape {
	private double a;
	private double b;
	private double c;
	
	Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double getArea() {
		double s = (a + b + c) / 2.0;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	@Override
	public double getPerimeter() {
		return (a+b+c);
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public double getC() {
		return c;
	}
	
	@Override
	public boolean equals(Shape a) {
		boolean equal = false;
		if( a instanceof Triangle) {
			equal = (((Triangle) a).getA() == this.getA()) &&
					(((Triangle) a).getB() == this.getB()) &&
					(((Triangle) a).getC() == this.getC());
		}
		return equal;
	}

}
