package com.Java.OOPS.Concepts;

class A {
	void msg() {
		System.out.println("Hello");
	}
}

class B {
	void msg() {
		System.out.println("Welcome");
	}
}

public class multipleInheritance extends A//,B
{//suppose if it were  


	public static void main(String args[]) {
		multipleInheritance obj = new multipleInheritance();
		obj.msg();// Now which msg() method would be invoked?
	}
}