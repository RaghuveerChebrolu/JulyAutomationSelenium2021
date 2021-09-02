package com.Java.Basics;

class Student {
	/*
	 * note : instance variable names and local variables names are same ,
	 * so we are using this keyword
	 */
	int rollno; //instance variable
	String name;//instance variable
	float fee;//instance variable

	//below method is accepting local variables which are having same name as 
	//instance variables as arguments 
	Student(int rollno, String name, float fee) {
		this.rollno = rollno;
		this.name = name;
		this.fee = fee;
	}

	void display() {
		System.out.println(rollno + " " + name + " " + fee);
	}
}

public class thiskeyword {
	public static void main(String args[]) {
		Student s1 = new Student(111, "ankit", 5000f);
		Student s2 = new Student(112, "sumit", 6000f);
		s1.display();
		s2.display();
	}
}