package com.Java.OOPS.Concepts;

//Java program to demonstrate
//the concept of upcasting

//Animal657 Class
class Animal657 {
	String name;

	// A method to print the
	// nature of the class
	void nature() {
		System.out.println("Animal657");
	}
}

// A Fish class which extends the
// Animal657 class
class Fish extends Animal657 {
	String color;

	// Overriding the method to
	// print the nature of the class
	@Override
	void nature() {
		System.out.println("Aquatic Animal657");
	}
}

// Demo class to understand
// the concept of upcasting
public class upcasting {

	// Driver code
	public static void main(String[] args) {
		// Creating an object to represent
		// Parent p = new Child();
		Animal657 a = new Fish();

		// The object 'a' has access to
		// only the parent's properties.
		// That is, the colour property
		// cannot be accessed from 'a'
		a.name = "GoldFish";

		// This statement throws
		// a compile-time error
		// a.color = "Orange";

		// Creating an object to represent
		// Child c = new Child();
		Fish f = new Fish();

		// The object 'f' has access to
		// all the parent's properties
		// along with the child's properties.
		// That is, the colour property can
		// also be accessed from 'f'
		f.name = "Whale";
		f.color = "Blue";

		// Printing the 'a' properties
		System.out.println("Object a");
		System.out.println("Name: " + a.name);

		// This statement will not work
		// System.out.println("Fish1 Color" +a.color);

		// Access to child class - overriden method
		// using parent reference
		a.nature();

		// Printing the 'f' properties
		System.out.println("Object f");
		System.out.println("Name: " + f.name);
		System.out.println("Color: " + f.color);
		f.nature();
	}
}