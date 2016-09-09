package com.thewadegeek;

public class UndergraduateStudent extends Student {
	private int year;
	
	public UndergraduateStudent(String name) {
		super(name, 18);
		year = 0;
	}
	
	public void setAge(int age) {
		super.setAge(age);
		year += 1;
	}
}
