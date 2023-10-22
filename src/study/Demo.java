package study;

import java.util.HashMap;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
		int palindromes = countSubstrings("aaa");
		System.out.println(palindromes);
		
		 //palindromes = countSubstrings("aaa");
		System.out.println(palindromes);

	}

	public static int countSubstrings(String s) {
		int totalPalindromes = 0;

		//		for(int i =0;i<s.length();i++){
		//			String str="";
		//			for(int j=i;j<s.length();j++){
		//				str=str+s.charAt(j);
		//				if(isPalindrome(str)) {
		//					System.out.println(str);
		//					totalPalindromes++;
		//				}
		//			}
		//		}

		HashMap<String,Boolean> map = new HashMap<>();
		int first=0;
		int second=first;
		String checkStr="";
		while(first<s.length()) {
			if(second>=s.length()) {
				checkStr="";
				first++;
				second=first;
			}else {
				//System.out.println("indxe "+second);
				checkStr=checkStr+s.charAt(second);
				if(map.containsKey(checkStr) && map.get(checkStr)==true) {
					totalPalindromes++;
					
				}
				if(isPalindrome(checkStr)) {
					map.put(checkStr, true);
					
					totalPalindromes++;
				}
				second++;
			}

		}
		return totalPalindromes;
	}

	public static boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true; 
	}


}
