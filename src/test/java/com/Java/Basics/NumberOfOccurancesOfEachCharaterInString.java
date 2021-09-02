package com.Java.Basics;

import java.util.HashMap;

public class NumberOfOccurancesOfEachCharaterInString {

	public static void main(String[] args) {
		String str = "LearningJava on march 26";
		char[] chArr = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		// checking for each character inside char array
		for (char ch : chArr) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}

		}
		System.out.println(map);
	}

}
