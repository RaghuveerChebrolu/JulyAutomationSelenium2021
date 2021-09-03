package com.Java.Oops.Concepts;

/*Super Keyword in Java
The super keyword in Java is a reference variable which is used to refer immediate parent class object.

Whenever you create the instance of subclass, an instance of parent class is created implicitly which is referred by super reference variable.

Usage of Java super Keyword
super can be used to refer immediate parent class instance variable.
super can be used to invoke immediate parent class method.
super() can be used to invoke immediate parent class constructor.
Usage of Java Super keyword
1.super is used to refer immediate parent class instance variable.

2.We can use super keyword to access the data member or field of parent class. 
3. It is used if parent class and child class have same fields.*/

class Animal1234 {
	String color = "white";
}

class Dog123 extends Animal1234 {
	String color = "black";

	void printColor() {
		System.out.println(color);// prints color of Dog class
		System.out.println(super.color);// prints color of Animal class
	}
}

public class superRefersImmediateparentClassInstanceVarible {
	public static void main(String args[]) {
		Dog123 d = new Dog123();
		d.printColor();
	}
}