package com.Java.OOPS.Concepts;

class Animal {
	void eat() {
		System.out.println("eating...");
	}
}

class Dog extends Animal {
	void bark() {
		System.out.println("barking...");
	}
}

public class MultiLevelInheritance extends Dog {
	void weep() {
		System.out.println("weeping...");
	}

	public static void main(String args[]) {
		//using child class object we can access parent class methods
		MultiLevelInheritance d = new MultiLevelInheritance();
		d.weep();
		d.bark();
		d.eat();
	}
}