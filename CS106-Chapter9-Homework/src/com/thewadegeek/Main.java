package com.thewadegeek;

public class Main {
	/*
	 * 	Expected Output:
	 	squid
		creature 1
		tentacles
		
		BIG!
		spout
		creature 2
		
		ocean-dwelling
		creature 1
		creature 2
		
		ocean-dwelling
		warm-blooded
		creature 2

	 */
	private static void exercise14() {
		SeaCreature[] elements = {new Squid(), new Whale(), new SeaCreature(), new Mammal()};
		
		for (int i = 0; i < elements.length; i++) {
			System.out.println(elements[i]);
			elements[i].method1();
			elements[i].method2();
			System.out.println();
		}
	}
	
	/*
	 * Expected Output
		Bay 1 Pond 2 
		Ocean 2 
		Lake 3 Ocean 2 
		
		Pond 1 
		Pond 2 
		Pond 3 
		
		Pond 1 
		Pond 2 
		Lake 3 Pond 2 
		
		Bay 1 Pond 2 
		Bay 2 
		Lake 3 Bay 2 
	 */
	private static void exercise16() {
		Pond[] ponds = {new Ocean(), new Pond(), new Lake(), new Bay()};
		
		for(Pond p : ponds) {
			p.method1();
			System.out.println();
			p.method2();
			System.out.println();
			p.method3();
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {
		exercise14();
		exercise16();
	}

}
