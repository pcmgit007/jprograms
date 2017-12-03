package com.programs.strings;

public class Combinations {

	private static void printCombination(String prefix, String s) {
		if (s.length() > 0) {
			System.out.println(prefix + s.charAt(0));
			printCombination(prefix + s.charAt(0), s.substring(1));
			printCombination(prefix, s.substring(1));
		}
	}

	public static void main(String[] args) {
		printCombination("", "abcd");
	}

}
