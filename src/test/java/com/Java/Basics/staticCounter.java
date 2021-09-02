package com.Java.Basics;

public class staticCounter {

	// Java Program to illustrate the use of static variable which
	// is shared with all objects.
	//static int count = 0;// will get memory only once and retain its value
	int count = 0; //every time new reference is creates and memory is allocated
	staticCounter() {
		count++;// incrementing the value of static variable
		System.out.println(count);
	}

	public static void main(String args[]) {
		// creating objects
		staticCounter c1 = new staticCounter();
		staticCounter c2 = new staticCounter();
		staticCounter c3 = new staticCounter();
	}
}
