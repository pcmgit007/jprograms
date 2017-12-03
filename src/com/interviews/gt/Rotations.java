package com.interviews.gt;

public class Rotations {

	public static String inp = "Hello my name is nayanika";

	public static void main(String[] args) {
		Rotations r = new Rotations();
		System.out.println(r.find("abcabc world", 3));

	}

	public int find(String sentence, int rot) {
		String[] splitted = sentence.split("\\s");

		int count = 0;
		for (String word : splitted) {
			if (word.length() > rot) {
				// System.out.println(rotate(word, rot));
				if (word.equals(rotate(word, rot))) {
					count = count + 1;
				}
			}
		}
		return count;
	}

	public String rotate(String word, int rot) {
		char[] rotWord = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			int j = (i + rot) % word.length();
			rotWord[j] = word.charAt(i);
			System.out.println("i Value::" + i + " j Value::" + j + " rotWord[j]::" + rotWord[j]);
		}

		System.out.println("Rotated Word..::" + String.valueOf(rotWord));
		return String.valueOf(rotWord);
	}
}
