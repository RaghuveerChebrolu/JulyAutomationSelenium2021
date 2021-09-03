package com.Java.Oops.Concepts;

class Animal987 {
	Animal987() {
		System.out.println("animal is created");
	}
}

class Dog835 extends Animal987 {
	Dog835() {
		super();  //if not given compiler will implicitly (internally) calls parent class constructor
		System.out.println("dog is created");
	}
}

public class superReferParentClassConstructor {
	public static void main(String args[]) {
		Dog835 d = new Dog835();
	}
}

/*Note : Note: super() is added in each class constructor automatically by 
compiler if there is no super() or this().*/