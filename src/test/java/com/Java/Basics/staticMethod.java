package com.Java.Basics;

class TeststaticMethod {
	int rollno;
	String name;
	static String college = "ITS";

	// static method to change the value of static variable
	static void change() {
		college = "BBDIT";
	}

	// constructor to initialize the variable
	TeststaticMethod(int r, String n) {
		rollno = r;
		name = n;
	}

	// method to display values
	void display() {
		System.out.println(rollno + " " + name + " " + college);
	}
}

// Test class to create and display the values of object
public class staticMethod {
	public static void main(String args[]) {
		TeststaticMethod.change();// calling change method
		// creating objects
		TeststaticMethod s1 = new TeststaticMethod(111, "Karan");
		TeststaticMethod s2 = new TeststaticMethod(222, "Aryan");
		TeststaticMethod s3 = new TeststaticMethod(333, "Sonoo");
		// calling display method
		s1.display();
		s2.display();
		s3.display();
	}
}