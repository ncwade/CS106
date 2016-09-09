package com.thewadegeek;

/*
 * Question 5: "this" and "super" both reference members of the class. "this" is used to reference variables or method defined locally, "super" is used to reference inherited methods.
 * Question 6: No to the private members, yes for the method.
 */

public class Student {
	private String name;
	private int age;
	
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

}
