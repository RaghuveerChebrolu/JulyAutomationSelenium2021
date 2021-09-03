package com.Java.OOPS.Concepts;

class overLoadingWithTypeArgumentsAmbiguity {
	void sum(int a, long b) {
		System.out.println("a method invoked");
	}

	void sum(long a, int b) {
		System.out.println("b method invoked");
	}

	public static void main(String args[]) {
		overLoadingWithTypeArgumentsAmbiguity obj = new overLoadingWithTypeArgumentsAmbiguity();
		//obj.sum(20, 20);// now ambiguity because int type is promoted to long which is used in both sum methods
	}
}

//Note : One type is not de-promoted implicitly for example double cannot be depromoted to any type implicitly.