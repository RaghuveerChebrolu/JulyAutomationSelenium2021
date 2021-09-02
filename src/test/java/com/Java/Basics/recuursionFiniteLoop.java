package com.Java.Basics;

public class recuursionFiniteLoop {
	static int count = 0;

	static void p() {
		count++;
		if (count <= 50) {
			System.out.println("hello " + count);
			p();
		}
	}

	public static void main(String[] args) {
		p();
	}
}