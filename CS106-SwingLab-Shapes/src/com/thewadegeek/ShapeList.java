package com.thewadegeek;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("serial")
public class ShapeList extends ArrayList<Shape> {
	
	public void toTop(Point p) {
		int index = 0;
		boolean move = false;

		Iterator<Shape> iterator = super.iterator();
		while (iterator.hasNext()) {
			Shape shape = iterator.next();
			if(shape.contains(p)) {
				index = super.indexOf(shape);
				move = true;
				break;
			}
		}

		if(move) {
			Shape itemToMove = super.get(index);
			super.remove(index);
			super.add(0, itemToMove);
		}
	}
}
