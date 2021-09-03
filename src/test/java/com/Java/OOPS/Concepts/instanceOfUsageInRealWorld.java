package com.Java.OOPS.Concepts;

interface Printable {
}

class ABC1274 implements Printable {
	public void a() {
		System.out.println("a method");
	}
}

class B53634 implements Printable {
	public void b() {
		System.out.println("b method");
	}
}

class Call {
	static void invoke(Printable p) {// upcasting
		if (p instanceof ABC1274) {
			ABC1274 a = (ABC1274) p;// Downcasting
			a.a();
		}
		if (p instanceof B53634) {
			B53634 b = (B53634) p;// Downcasting
			b.b();
		}

	}
}// end of Call class

public class instanceOfUsageInRealWorld {
	public static void main(String args[]) {
		Printable p = new B53634();//upcasting
		//Call c = new Call();
		//c.invoke(p);
		Call.invoke(p);
	}
}