package com.Java.OOPS.Concepts;

import com.Javabasics.B2244553;

/*using inhertence
protected method which is located in another package is accessable*/

public class protectedAccessModifier extends B2244553 {
	public static void main(String args[]) {
		protectedAccessModifier obj12354 = new protectedAccessModifier();
		System.out.println("using inhertence");
		obj12354.msgThroughInherit();
	}
}