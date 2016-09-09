package com.thewadegeek;

public class StudentAdvanceTicket extends Ticket {
	StudentAdvanceTicket(int number, int days) {
		super(number);
		if(days >= 10) {
			mTicketPrice = 15.0;
		} else {
			mTicketPrice = 20.0;
		}
	}
	
	public String toString() {
		return super.toString()+" (ID required)";
	}
}
