package com.javaPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class printingDulicatesinString {

	public static void main(String[] args) {
		printDuplicateCharacters("Hi How are you doing");
	}

	String str = "";

	public static void printDuplicateCharacters(String word) {
		char[] characters = word.toCharArray();
		// build HashMap with character and number of times they appear in
		// String
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (Character ch : characters) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}
		// Iterate through HashMap to print all duplicate characters of String
		Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
		System.out.printf("List of duplicate characters in String '%s' %n", word);
		for (Map.Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() >=1) {
				System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
			}
		}
	}

	/*
	 * for (int i = 0; i < str.length(); i++) { for (int j = i + 1; j <
	 * str.length(); j++) { if (str.charAt(i) == str.charAt(j)) { count++;
	 * System.out.println(str.charAt(i)+" : "+count);
	 * 
	 * } //System.out.println(str.charAt(i) + " : " + count); } }
	 */
}
