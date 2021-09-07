package com.Java.OOPS.Concepts;

class A123 {
	A123() {
		System.out.println("parent class constructor invoked");
	}
}

public class instanceInitializedBlock extends A123 {
	instanceInitializedBlock() {
		//super();
		System.out.println("child class constructor invoked");
	}

	{
		System.out.println("instance initializer block is invoked");
	}

	public static void main(String args[]) {
		instanceInitializedBlock b = new instanceInitializedBlock();
	}
}

/*Notes : 
Rules for instance initializer block :
	There are mainly three rules for the instance initializer block. They are as follows:
	The instance initializer block is created when instance of the class is created.
	The instance initializer block is invoked after the parent class constructor is invoked (i.e. after super() constructor call).
	The instance initializer block comes in the order in which they appear.*/