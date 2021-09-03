package com.Java.OOPS.Concepts;

class Animal123 {
	void eat113() {
		System.out.println("eating...");
	}
}

class Dog456 extends Animal123 {
	void bark887() {
		System.out.println("barking...");
	}
}

public class Hierarchial_Inheritance extends Animal123 {
	void meow() {
		System.out.println("meowing...");
	}

	public static void main(String args[]) {
		Hierarchial_Inheritance c = new Hierarchial_Inheritance();
		c.meow();
		c.eat113();
		//c.bark887();//Compile Time Error
	}
}