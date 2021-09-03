package com.Java.OOPS.Concepts;

/*Abstraction is a process of hiding the implementation details and
showing only functionality to the user.*/

/*Ways to achieve Abstraction
There are two ways to achieve abstraction in java

Abstract class (0 to 100%)
Interface (100%)*/
abstract class Bank12345 {
	abstract int getRateOfInterest();
}

class SBI extends Bank12345 {
	int getRateOfInterest() {
		return 6;
	}
}

class PNB extends Bank12345 {
	int getRateOfInterest() {
		return 8;
	}
}

public class abstrctClassExample {
	public static void main(String args[]) {
		Bank12345 b;
		b = new SBI();
		System.out.println("Rate of Interest of SBI is: " + b.getRateOfInterest() + " %");
		b = new PNB();
		System.out.println("Rate of Interest of PNB is: " + b.getRateOfInterest() + " %");
	}
}