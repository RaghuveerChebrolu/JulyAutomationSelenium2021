package com.Java.OOPS.Concepts;

interface A453 {
	void a();
	void b();
	void c();
	void d();
}

abstract class B9873948 implements A453 {
	public void c() {
		System.out.println("I am c");
	}
	public void a() {
		System.out.println("I am a in parent class");
	}
}

class M extends B9873948 {
	public void a() {
		System.out.println("I am a");
	}

	public void b() {
		System.out.println("I am b");
	}

	public void d() {
		System.out.println("I am d");
	}
}

class AbstractClassRealTimeScenario {
	public static void main(String args[]) {
		A453 a = new M();//upcasting
		a.a();
		a.b();
		a.c();
		a.d();
	}
}