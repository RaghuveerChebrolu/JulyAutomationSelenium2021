package com.Java.Basics;

public class FirstProgram {
	public static int x = 10;// instance variable
	public static int y = 20;//// instance variable
	public static int z = 37;// static variable

	public static void main(String[] args) {
		System.out.println("He welcome to Java");

		int a = 30;// local variable
		int b = 40;// local variable
		int c = a + b;
		int v = x + y;
		float f = a;// widening
		float f1 = 3.45f;
		byte byt = (byte) a;
		boolean val = false;
		// byte :
		// -128,-127,.....0,1,2,.....127 =256 characters
		// 130
		// below is for OR operator
		// 0 is false and 1 is true
		// 0 1 =1
		// 1 0 =1
		// 0 0 =0
		// 1 1 =1

		// below is for & operator
		// 0 is false and 1 is true
		// 0 1 =0
		// 1 1 =1
		// 1 0 =0
		// 0 0 =0
		System.out.println(y < x && x < y);// &&The logical && operator doesn't
											// check second condition if first
											// condition is false. It checks
											// second condition only if first
											// one is true
		//The bitwise & operator always checks both conditions whether first condition is true or false.
		System.out.println(y < x & x < y);
		//The logical || operator doesn't check second condition if first condition is true. It checks second condition only if first one is false.
		System.out.println(a < b || y > x);
		//The bitwise | operator always checks both conditions whether first condition is true or false.
		System.out.println(a < b | y > x);
		System.out.println("C value : " + c);
		System.out.println("V: " + v);
		System.out.println(a - b);
		System.out.println(y / x);
		System.out.println(y % x);
		System.out.println(10 << 4);// 10 * 2 power 4 or 2^4
		System.out.println(20 >> 3);// 20/(2^3)=20/8=2
		System.out.println("Float value is : " + f);
		System.out.println("Typecasting float to int: " + (int) f1);// type
																	// casting
		System.out.println("overflow byte : " + byt);
		System.out.println("post increment:" + b++);
		System.out.println("pre increment:" + ++b);
		System.out.println("Pre decrement:" + --b);
		System.out.println("Post decrement:" + b--);
		System.out.println(a++ + ++a);//here a value is 32 + 30
		System.out.println(a);
		System.out.println("Below is the example for post decrement and pre decrement opearator");
		System.out.println(x-- + --x);
		System.out.println(~y);
		System.out.println(!val);
		
		//ternary operator
		//(test condition)?statement1:statement2
		System.out.println("Below is the out put for ternary operator");
		//a=30,b=40
		System.out.println(a>b?a:b);
		System.out.println(a<b?a:b);
		int q = 25;
		int r= 35;
		int s= 24;
		int t= 4;
		q+=5;//q=q+5 ---> 25+5=30
		r-=2;//r=r-2 -->35-2=33
		s*=3;//s=S*3 -->24*3=72
		t/=2;//t=t/2 -->4/2=2
		System.out.println("Assignment operator += "+ q);
		System.out.println("Assignment operator -= "+ r);
		System.out.println("Assignment operator *= "+ s);
		System.out.println("Assignment operator /= "+ t);
	}
}