package com.programs.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchCaseInsensitive {
	public boolean isPatternMatching(String line) {
		Pattern ptn = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		Matcher match = ptn.matcher(line);
		if (match.find()) {
			return true;
		}
		return false;
	}

	public static void main(String a[]) {
		PatternMatchCaseInsensitive msp = new PatternMatchCaseInsensitive();
		System.out.println(msp.isPatternMatching("This line contains java, lets see"));
		System.out.println(msp.isPatternMatching("Here JAVA is in capital leters, lets see"));
		System.out.println(msp.isPatternMatching("Here C++ is in capital leters, lets see"));
	}
}
