package com.thewadegeek;

public class Hexagon implements Shape {
	private double mSideLength;
	static private final double factor = 3 * Math.sqrt(3) / 2;
	
	public Hexagon(double sideLength) {
		this.mSideLength = sideLength;
	}

	@Override
	public double getArea() {
		return factor * this.mSideLength * this.mSideLength;
	}

	@Override
	public double getPerimeter() {
		return this.mSideLength * 6;
	}
	
	public double getSideLength() {
		return this.mSideLength;
	}

	@Override
	public boolean equals(Shape a) {
		boolean equal = false;
		if(a instanceof Hexagon){
			equal = (((Hexagon) a).mSideLength == this.mSideLength);
		}
		return equal;
	}

}
