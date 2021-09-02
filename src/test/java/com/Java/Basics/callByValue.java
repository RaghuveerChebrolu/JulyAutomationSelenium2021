package com.Java.Basics;

class callByValue {
	int data = 50;

	void change(int data) {
		data = data + 100;// changes will be in the local variable only
		System.out.println("data value locally is : "+ data);
	}

	public static void main(String args[]) {
		callByValue op = new callByValue();

		System.out.println("before change " + op.data);
		op.change(500);
		System.out.println("after change " + op.data);

	}
}