package com.Java.OOPS.Concepts;

class Adder123 {
	static int add(int a, int b) {
		return a + b;
	}

	static double add(double a, double b) {
		return a + b;
	}
}

class overLoadingbyDifferentDataTypesWithDifferentArgumentTypes {
	public static void main(String[] args) {
		System.out.println(Adder123.add(11, 11));
		System.out.println(Adder123.add(12.3, 12.6));
		System.out.println(Adder123.add(12, 12));

	}
}
