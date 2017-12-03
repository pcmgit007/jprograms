package com.interviews.gt;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class UserMainCode {

	public int rotateWords(String input1, int input2) {
		
		List<String> originalInputList = getInputAsStringList(input1);
		List<String> rotatedInputList = getRotatedInputList(originalInputList, input2);
		
		return getCountOfUnrotated(originalInputList, rotatedInputList);
		//throw new UnsupportedOperationException("rotateWords(String input1, int input2");
	}
	
	private List<String> getInputAsStringList(String input1) {
		List<String> inputAsList = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(input1, " ");
		while(st.hasMoreTokens()) {
			inputAsList.add((String)st.nextElement());
		}
		
		System.out.println("Returning Orinal String as List::"+inputAsList);
		return inputAsList;
	}
	
	private List<String> getRotatedInputList(List<String> originalInputList, int input2) {
		List<String> rotatedList = new LinkedList<>();
		for(String strInList: originalInputList) {
			String currentString = strInList;
			if(strInList.length()<=input2) {
				rotatedList.add(currentString);
			} else {
				System.out.println("Second Part In the String::"+currentString.substring(input2, currentString.length()));
				System.out.println("First Part In the String::"+currentString.substring(0,input2));
				String rotatedString = currentString.substring(input2, currentString.length())+currentString.substring(0,input2);
				rotatedList.add(rotatedString);
			}
		}
		System.out.println("Returning Rotated Strings as List::"+rotatedList);
		return rotatedList;
	}
	
	private int getCountOfUnrotated(List<String> originalInputList, List<String> rotatedInputList) {
		int count = 0, i =0;
		
		while(i < originalInputList.size()) {
			if(originalInputList.get(i).equalsIgnoreCase(rotatedInputList.get(i)))
				count++;
			i++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		UserMainCode umc = new UserMainCode();
		String input = "Hello There adaada";
		
		System.out.println("The Result is::"+umc.rotateWords(input, 3));
	}
}
