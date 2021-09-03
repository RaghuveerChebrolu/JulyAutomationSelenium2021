package com.Java.OOPS.Concepts;

class Employee {
	float salary = 40000; // parent class instance variable
}

public class singleInheritance extends Employee {
	int bonus = 10000;

	public static void main(String args[]) {
		// trying to access parent class variables by using child class object
		singleInheritance p = new singleInheritance();
		System.out.println("Programmer salary is:" + p.salary);
		System.out.println("Bonus of Programmer is:" + p.bonus);
	}
}