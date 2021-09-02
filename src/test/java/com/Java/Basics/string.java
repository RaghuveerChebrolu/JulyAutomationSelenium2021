package com.Java.Basics;

public class string {

	public static void main(String[] args) {
		String str="Automation";
		str.concat("Selenium");
		System.out.println(str);
		str=str.concat("Selenium");//explicitly changing 
		System.out.println(str);
		String s1="hello";
		String s2="helLo";
		String s3=new String("hello");
		String s4="helloworldkjava";
		System.out.println(s1.equals(s2));///verifies content
		System.out.println(s1.equalsIgnoreCase(s2));
		System.out.println(s1==s2);//verified reference
		System.out.println(s1.equals(s3));
		System.out.println(s1==s3);
		System.out.println(s1.compareTo(s3));//compare char length
		System.out.println(s1.compareTo(s4));
		System.out.println(s4.compareTo(s1));
		//Note: After a string literal, all the + will be treated as string concatenation operator.
		System.out.println(50+25+s1+" "+47+93);//
	}

}
