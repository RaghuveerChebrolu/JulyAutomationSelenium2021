package com.Java.OOPS.Concepts;

class A2211 {
	//note : Private data members/methods are not visible/accessable out side of the class 
	
	private int data = 40;

	private void msg() {
		System.out.println("Hello java");
	}
}

public class privateAccessModifier {
	public static void main(String args[]) {
		A2211 obj = new A2211();
		//System.out.println(obj.data);// Compile Time Error
		//obj.msg();// Compile Time Error
	}
}
