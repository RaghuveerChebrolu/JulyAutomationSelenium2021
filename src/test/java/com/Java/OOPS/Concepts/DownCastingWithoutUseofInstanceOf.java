package com.Java.OOPS.Concepts;

class Animal365723 {
}

public class DownCastingWithoutUseofInstanceOf extends Animal365723 {
	static void method(Animal365723 a) {
		DownCastingWithoutUseofInstanceOf d = (DownCastingWithoutUseofInstanceOf) a;// downcasting
		System.out.println("ok downcasting performed");
	}

	public static void main(String[] args) {
		Animal365723 a = new DownCastingWithoutUseofInstanceOf();
		DownCastingWithoutUseofInstanceOf.method(a);
	}
}

/*Note :
Let's take closer look at this, actual object that is referred by a, is an object of DownCastingWithoutUseofInstanceOf class. So if we downcast it, it is fine. But what will happen if we write:

Animal365723 a=new Animal365723();  
DownCastingWithoutUseofInstanceOf.method(a);  */
//Now ClassCastException but not in case of instanceof operator 