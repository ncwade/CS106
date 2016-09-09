package com.thewadegeek;

import java.util.Random;

public class Exercise17 {
	private class SequentialIncrementer implements Incrementable {
		private double value;

		public SequentialIncrementer() {
			this.value = 0;
		}
		
		@Override
		public void increment() {
			this.value += 1;
		}

		@Override
		public double getValue() {
			return this.value;
		}
		
	}
	
	private class RandomIncrementer implements Incrementable {
		private double value;
		Random rand = new Random();

		public RandomIncrementer() {
			this.value = rand.nextInt();
		}
		
		@Override
		public void increment() {
			this.value += rand.nextInt();
		}

		@Override
		public double getValue() {
			return this.value;
		}
		
	}
}
