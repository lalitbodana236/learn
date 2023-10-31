package study.recursion;

import java.util.ArrayList;
import java.util.List;

public class SortedVowelStrings {

	public static void main(String[] args) {
		int n = 2; // Change n to the desired value
		int count = countSortedVowelStringsRec(n);
		System.out.println("Number of sorted vowel strings of length " + n + ": " + count);

	}
	
	public static int countSortedVowelStringsRec(int n) {
       // int count = 0;
		List<String> list =new ArrayList<>();
      
        StringBuilder current = new StringBuilder();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        countSortedVowelStringsHelper(n, 0, current, vowels,list);
        System.out.println(list.size());
        for(String s : list) {
        	System.out.println(s);
        }
        return list.size();
    }
	
	private static void countSortedVowelStringsHelper(int n, int index, StringBuilder current, char[] vowels, List<String> list) {
        if (index == n) {
            // Check if the current string is sorted
            if (isSorted(current.toString())) {
            	list.add(current.toString());
            }
            return;
        }

        for (char vowel : vowels) {
            current.append(vowel);
            countSortedVowelStringsHelper(n, index + 1, current, vowels,list);
            current.deleteCharAt(current.length() - 1);
        }
    }

    private static boolean isSorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
	
	
	//by loop
	public static int countSortedVowelStrings(int n) {
		// Create a 2D array to store the counts
		int[][] dp = new int[n + 1][5];

		// Initialize the base case
		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}
		
		// Fill the DP array
        for (int len = 2; len <= n; len++) {
            for (int vowel = 0; vowel < 5; vowel++) {
                for (int prevVowel = vowel; prevVowel < 5; prevVowel++) {
                    dp[len][vowel] += dp[len - 1][prevVowel];
                }
            }
        }
		

     // Calculate the total count by summing the counts for all vowels
        int totalCount = 0;
        for (int vowel = 0; vowel < 5; vowel++) {
            totalCount += dp[n][vowel];
        }

        return totalCount;
	}

}

class CountWrapper {
    int count;
}
