package com.Java.OOPS.Concepts;

/*Note:

The java instanceof operator is used to test whether the object is an instance of the 
specified type (class or subclass or interface).

The instanceof in java is also known as type comparison operator because it compares the instance with type. 
It returns either true or false. If we apply the instanceof operator with any variable that has null value, it returns false.

*/

class instanceOfClass {
	public static void main(String args[]) {
		instanceOfClass s = new instanceOfClass();
		System.out.println(s instanceof instanceOfClass);// true
	}
}