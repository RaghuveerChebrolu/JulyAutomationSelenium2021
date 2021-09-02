package com.Java.Basics;

public class RestrictionOfStaticMethod {
	static int a = 25; //able to access this as it is declared as static
	//int a = 25; //cannot access this variable as it is non static variable
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(a);
	}
/*note : There are two main restrictions for the static method. They are:
1. The static method can not use non static data member or call non-static method directly.
2. this and super cannot be used in static context.*/
}
