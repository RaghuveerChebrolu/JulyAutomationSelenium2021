package com.javaPrograms;

public class StringBufferAndStringBuilderRevereString {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer("heloWorld");
		StringBuffer modifiedString = buffer.reverse();
		System.out.println(modifiedString);
		
		StringBuilder buffer1 = new StringBuilder("LearningJava");
		StringBuilder modifiedString1 = buffer1.reverse();
		System.out.println(modifiedString1);

	}

}
