package com.thewadegeek;

public class Exercise1and2 {
	
	private class Employee {
		public int getHours() {
			return 40;
		}
		public double getSalary() {
			return 40000.0;
		}
		public int getVacationDays() {
			return 10;
		}
		public String getVacationForm() {
			return "Yellow";
		}
	}
	
	public class Marketer extends Employee {
		public double getSalary() {
			return 50000.0;
		}
		public void advertise() {
			System.out.println("Act now, while supplies last!");
		}
	}
	
	public class Janitor extends Employee {
		public int getHours() {
			return 80;
		}
		public double getSalary() {
			return 30000.0;
		}
		public int getVacationDays() {
			return 5;
		}
		public void clean() {
			System.out.println("Workin' for the man.");
		}
	}
}
