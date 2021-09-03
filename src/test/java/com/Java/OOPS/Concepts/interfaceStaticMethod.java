package com.Java.OOPS.Concepts;

interface Drawable221 {
	void draw();

	static int cube(int x) {
		return x * x * x;
	}
}

class Rectangle112 implements Drawable221 {
	public void draw() {
		System.out.println("drawing rectangle");
	}
}

class interfaceStaticMethod {
	public static void main(String args[]) {
		Drawable221 d = new Rectangle112();
		d.draw();
		System.out.println(Drawable221.cube(3));
	}
}