package com.programs.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimplePatternMatch {

	public boolean isPatternMatching(String line) {

		Pattern ptn = Pattern.compile("\\d{2}$"); //$ - Matches the end of the line, ^ - Matches the beginning of line
		Matcher mtch = ptn.matcher(line);

		if (mtch.find())
			return true;
		return false;
	}

	public static void main(String args[]) {
		SimplePatternMatch spm = new SimplePatternMatch();
		System.out.println("Is 'ddfsa12' ends with min 2 digits? " + spm.isPatternMatching("ddfsa12"));
		System.out.println("Is 'ddfsa12adf1' ends with min 2 digits? " + spm.isPatternMatching("ddfsa12adf1"));
	}
}
