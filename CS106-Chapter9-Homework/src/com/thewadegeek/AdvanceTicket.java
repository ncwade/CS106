package com.thewadegeek;

public class AdvanceTicket extends Ticket {
	AdvanceTicket(int number, int days) {
		super(number);
		if(days >= 10) {
			mTicketPrice = 30.0;
		} else {
			mTicketPrice = 40.0;
		}
	}
}
