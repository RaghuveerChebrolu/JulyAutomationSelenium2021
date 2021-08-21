package com.javaPrograms;

public class reverseEachWordInString {

	private static Object StringFormatter;

	public static void main(String[] args) {
		String str="Hi How are you doing?";
		String []words=str.split("\\s");
		 
		System.out.println(words[0]);
		System.out.println(words[1]);
		System.out.println(words[2]);
		System.out.println(words[3]);
		System.out.println(words[4]);
		
		int count =words.length;
		System.out.println(count);
		for (String word:words){
			StringBuilder obj = new StringBuilder(word);
			String reverseWord="";
			obj.reverse();
			reverseWord=reverseWord+obj.toString()+" ";
			System.out.println(reverseWord);
		}
		//System.out.println(StringFormatter.reverseWord(str));  
	}

}
