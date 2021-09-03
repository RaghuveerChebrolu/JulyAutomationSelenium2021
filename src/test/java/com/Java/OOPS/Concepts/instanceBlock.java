package com.Java.OOPS.Concepts;

class A98 {
	A98() {
		System.out.println("parent class constructor invoked");
	}
}

class instanceBlock extends A98 {
	instanceBlock() {
		//super();
		System.out.println("child class constructor invoked");
	}

	instanceBlock(int a) {
		super();
		System.out.println("child class constructor invoked " + a);
	}

	{
		System.out.println("instance initializer block is invoked");
	}

	public static void main(String args[]) {
		instanceBlock b1 = new instanceBlock();
		instanceBlock b2 = new instanceBlock(10);
	}
	/*Note : When evrr object is created 
	1. parent class contrustor is invoked
	2. Instance block is  invoked
	3.remaining code will be executed*/
}