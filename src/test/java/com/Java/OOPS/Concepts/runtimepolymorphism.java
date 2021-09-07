package com.Java.OOPS.Concepts;

import java.util.GregorianCalendar;

class Bike {
	void run() {
		System.out.println("running");
	}
}

public class runtimepolymorphism extends Bike {
	void run() {
		System.out.println("running safely with 60km");
	}

	public static void main(String args[]) {
		long start = new GregorianCalendar().getTimeInMillis();
		Bike b = new runtimepolymorphism();// upcasting
		b.run();
		long end = new GregorianCalendar().getTimeInMillis();
		System.out.println("upcasting time:" + (end - start));
		long starttime = new GregorianCalendar().getTimeInMillis();
		runtimepolymorphism b2 = new runtimepolymorphism();
		b2.run();
		long endtime = new GregorianCalendar().getTimeInMillis();
		System.out.println("overriding time:" + (endtime - starttime));
		
		/*
		 * Note : Example of Java Runtime Polymorphism In this example, we are
		 * creating two classes Bike and runtimepolymorphism. runtimepolymorphism class extends Bike
		 * class and overrides its run() method. We are calling the run method
		 * by the reference variable of Parent class. Since it refers to the
		 * subclass object and subclass method overrides the Parent class
		 * method, the subclass method is invoked at runtime.
		 * 
		 * Since method invocation is determined by the JVM not compiler, it is
		 * known as runtime polymorphism.
		 */

	}
}