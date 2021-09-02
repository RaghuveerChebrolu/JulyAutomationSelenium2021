package com.Java.Basics;

class ABCD {
	ABCD() {
		this(9);//// this () calls the parameterized constructor of the class
		System.out.println("hello a");
	}

	ABCD(int x) {
		System.out.println(x);
	}
}

public class thisCallsParameterizedConstructor {
	public static void main(String args[]) {
		ABCD a = new ABCD();
	}
}