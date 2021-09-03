package com.Java.OOPS.Concepts;

class Animal992 {
}

public class instanceOfClassInIsARelationShip extends Animal992 {// Dog inherits
																	// Animal

	public static void main(String args[]) {
		instanceOfClassInIsARelationShip d = new instanceOfClassInIsARelationShip();
		System.out.println(d instanceof Animal992);// true
		System.out.println(d instanceof instanceOfClassInIsARelationShip);// true
	}
}