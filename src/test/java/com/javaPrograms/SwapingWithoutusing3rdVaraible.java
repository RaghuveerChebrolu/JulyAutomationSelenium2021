package com.javaPrograms;

public class SwapingWithoutusing3rdVaraible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =7;
		int b=9;
		//output :  b=7 , a=9;
		a=a+b; //step 1
		System.out.println(a);
		b=a-b;//step 2
		System.out.println("b:"+b);
		a=a-b;//step 3 
		System.out.println("a:"+a);
	}
}
