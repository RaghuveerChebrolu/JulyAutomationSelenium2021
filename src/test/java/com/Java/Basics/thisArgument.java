package com.Java.Basics;

class thisArgument {
	void m(thisArgument obj) {
		System.out.println("method is invoked");
	}

	void p() {
		m(this);
	}

	public static void main(String args[]) {
		thisArgument s1 = new thisArgument();
		s1.p();
	}
}