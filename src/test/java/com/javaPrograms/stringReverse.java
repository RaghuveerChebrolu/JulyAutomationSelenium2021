package com.javaPrograms;

public class stringReverse {

	public static void main(String[] args) {

		String str = "LearingJava";
		char[] ch = str.toCharArray();
		/*
		 * System.out.println(ch[0]); System.out.println(ch[1]);
		 */
		int length = str.length() - 1;
		System.out.println(length);
		for (int i = length; i >= 0; i--) {
			System.out.println(ch[i]);

		}
	}

}
