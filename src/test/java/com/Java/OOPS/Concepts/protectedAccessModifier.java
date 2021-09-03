package com.Java.OOPS.Concepts;

import com.Java.Programs.B224455;

/*using inhertence
protected method which is located in another package is accessable*/

class ProtectedAccessModifier extends B224455 {
	public static void main(String args[]) {
		ProtectedAccessModifier obj1234 = new ProtectedAccessModifier();
		System.out.println("using inhertence");
		obj1234.msgThroughInherit();
	}
}