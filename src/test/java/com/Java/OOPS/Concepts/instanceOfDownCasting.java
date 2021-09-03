package com.Java.OOPS.Concepts;

/*Downcasting with java instanceof operator
When Subclass type refers to the object of Parent class or object of interface(line 15), it is known as downcasting. 
If we perform it directly, compiler gives Compilation error(line 17). 
If you perform it by typecasting, ClassCastException is thrown at runtime. (line 18)
But if we use instanceof operator, downcasting is possible.*/

class parentclass123 {
}

public class instanceOfDownCasting extends parentclass123 {
	static void method(parentclass123 a) {
		if (a instanceof instanceOfDownCasting) {
			instanceOfDownCasting d = (instanceOfDownCasting) a;// downcasting
			System.out.println("ok downcasting performed");
			//instanceOfDownCasting obj = new parentclass123();//compile time error
			instanceOfDownCasting d1=(instanceOfDownCasting)new parentclass123();  
			//the above line Compiles successfully but java.lang.ClassCastException is thrown at runtime  
		}
	}

	public static void main(String[] args) {
		parentclass123 a = new instanceOfDownCasting(); //upcasting
		instanceOfDownCasting.method(a);
	}

}