package com.Java.OOPS.Concepts;

interface Printable1234 {
	void print();
}

interface Showable123 extends Printable1234 {
	void show();
}

class interfaceExtendAnotherInterface implements Showable123 {
	public void print() {
		System.out.println("Hello");
	}

	public void show() {
		System.out.println("Welcome");
	}

	public static void main(String args[]) {
		interfaceExtendAnotherInterface obj = new interfaceExtendAnotherInterface();
		obj.print();
		obj.show();
	}
}