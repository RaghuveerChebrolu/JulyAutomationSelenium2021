package com.Java.Basics;

class ABC {
	ABC() {
		System.out.println("hello a");
	}

	ABC(int x) {
		this();// this () calls the constructor of the class
		System.out.println(x);
	}
}

public class thisCallsConstructor {
	public static void main(String args[]) {
		ABC a = new ABC(10);
	}
}