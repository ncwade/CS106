package com.thewadegeek;
/*
 * Exercise 5
 */

public abstract class Ticket {
	private int mTicketNumber;
	protected double mTicketPrice;
	
	Ticket(int number) {
		mTicketNumber = number;
		mTicketPrice = 0;
	}
	
	public double getPrice() {
		return mTicketPrice;
	}
	
	public String toString() {
		return "Number: "+mTicketNumber+", Price: "+mTicketPrice;
	}
}
