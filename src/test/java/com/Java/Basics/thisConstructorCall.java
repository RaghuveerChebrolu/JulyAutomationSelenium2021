package com.Java.Basics;

class B {
	thisConstructorCall obj;

	B(thisConstructorCall obj) {
		this.obj = obj;
	}

	void display() {
		System.out.println(obj.data);// using data member of thisConstructorCall class
	}
}

public class thisConstructorCall {
	int data = 10;

	thisConstructorCall() {
		B b = new B(this);
		b.display();
	}

	public static void main(String args[]) {
		thisConstructorCall a = new thisConstructorCall();
	}
}