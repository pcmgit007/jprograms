package com.programs.strings;

public class StringCompareEqualsMethod {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello";
		String s3 = new String("hello");

		System.out.println(s1.equals(s2));
		System.out.println(s2.equals(s3));
	}
}
