package study.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PhoneKeyPad {

	public static void main(String[] args) {

		String digit = "23";
		List<String> combinations = letterCombinations(digit);
		for (String combination : combinations) {
			System.out.println(combination);
		}

	}

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.isEmpty()) {
			return result;
		}
		String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		generateCombinations(result, digits, mapping, 0, new StringBuilder());
		return result;
	}

	private static void generateCombinations(List<String> result, String digits, String[] mapping, int index, StringBuilder current) {
		System.out.println("Char "+current.toString());
		if (index == digits.length()) {
			result.add(current.toString());
			return;
		}

		String letters = mapping[digits.charAt(index) - '0'];
		System.out.println("letter "+letters);
		for (int i = 0; i < letters.length(); i++) {
			current.append(letters.charAt(i));
			generateCombinations(result, digits, mapping, index + 1, current);
			current.deleteCharAt(current.length() - 1);
		}
	}



}
