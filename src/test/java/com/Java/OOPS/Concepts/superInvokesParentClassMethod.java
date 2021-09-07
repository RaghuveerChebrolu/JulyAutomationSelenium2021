package com.Java.OOPS.Concepts;

class Animal567 {
	void eat() {
		System.out.println("eating...");
	}
}

class Dog876 extends Animal567 {
	void eat() {
		System.out.println("eating bread...");
	}

	void bark() {
		System.out.println("barking...");
	}

	void work() {
		super.eat();
		bark();
		eat();
	}
}

public class superInvokesParentClassMethod {
	public static void main(String args[]) {
		Dog876 d = new Dog876();
		d.work();
	}
}