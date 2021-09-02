package com.Java.Basics;

class Student234 {
	int rollno;
	String name, course;
	float fee;

	Student234(int rollno, String name, String course) {
		// Note :Rule: Call to this() must be the first statement in
		// constructor.
		this.rollno = rollno;
		this.name = name;
		this.course = course;
	}

	Student234(int rollno, String name, String course, float fee) {
		this(rollno, name, course);// reusing constructor
		this.fee = fee;
		// this(rollno, name, course);// Wrong way : Constructor call must be
		// the
		// first statement inside a constructor.
	}

	void display() {
		System.out.println(rollno + " " + name + " " + course + " " + fee);
	}
}

class thisConstructorCalls_chaining {
	public static void main(String args[]) {
		Student234 s1 = new Student234(111, "ankit", "java");
		Student234 s2 = new Student234(112, "sumit", "java", 6000f);
		s1.display();
		s2.display();
	}
}