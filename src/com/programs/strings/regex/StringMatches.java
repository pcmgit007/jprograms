package com.programs.strings.regex;

public class StringMatches {
	public void isStringNumber(String number) {
		System.out.println(number.matches("(\\d+)"));
	}
	
	public static void main(String[] args) {
		StringMatches sm = new StringMatches();
		sm.isStringNumber("345");
		sm.isStringNumber("34we");
	}
}
