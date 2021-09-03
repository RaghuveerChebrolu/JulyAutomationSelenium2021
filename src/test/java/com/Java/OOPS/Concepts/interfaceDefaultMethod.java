package com.Java.OOPS.Concepts;


import com.Java.Oops.Concepts.*;
interface Drawable {
	void draw();

	default void msg123() {
		System.out.println("default method");
	}
}

class Rectangle implements Drawable {
	public void draw() {
		System.out.println("drawing rectangle");
	}
}

public class interfaceDefaultMethod {
	public static void main(String args[]) {
		Drawable d = new Rectangle();
		d.draw();
		d.msg123();
	}
}