package study.array;

public class LongestPalindrome {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int start = 0;
		int end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i); // Odd-length palindrome
			int len2 = expandAroundCenter(s, i, i + 1); // Even-length palindrome
			
			//System.out.println(len1+" "+len2);
			int maxLen = Math.max(len1, len2);
			System.out.println("max "+maxLen);
			if (maxLen > end - start) {
				
				start = i - (maxLen - 1) / 2;
				end = i + maxLen / 2;
				
				System.out.println("max inside "+maxLen +" "+start+" "+end);
			}
		}

		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		
	}

}
