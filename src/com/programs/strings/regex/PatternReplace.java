package com.programs.strings.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternReplace {
	
	public String replaceWithPattern(String str, String replace) {
		Pattern ptn = Pattern.compile("\\s+");
		Matcher mtch = ptn.matcher(str);
		return mtch.replaceAll(replace);
	}
	
	public static void main(String a[]){
        String str = "My    name    is  kingkon.  ";
        PatternReplace mpr = new PatternReplace();
        System.out.println(mpr.replaceWithPattern(str, " "));
    }

}
