package study.array;

public class CuntVowelPermutation {
	public int countVowelPermutation(int n) {
		int MOD = 1000000007;

		// Create a 2D array to store counts of valid strings ending with each vowel character at each position.
		// Rows represent vowel characters: 'a', 'e', 'i', 'o', 'u'.
		// Columns represent positions in the string.
		long[][] dp = new long[5][n];

		// Initialize base cases for each vowel character at the first position.
		for (int i = 0; i < 5; i++) {
			dp[i][0] = 1;
		}

		for (int position = 1; position < n; position++) {
			// 'a' can only be followed by 'e'.
			dp[0][position] = dp[1][position - 1];

			// 'e' can be followed by 'a' or 'i'.
			dp[1][position] = (dp[0][position - 1] + dp[2][position - 1]) % MOD;

			// 'i' can be followed by any vowel except 'i'.
			dp[2][position] = (dp[0][position - 1] + dp[1][position - 1] + dp[3][position - 1] + dp[4][position - 1]) % MOD;

			// 'o' can be followed by 'i' or 'u'.
			dp[3][position] = (dp[2][position - 1] + dp[4][position - 1]) % MOD;

			// 'u' can only be followed by 'a'.
			dp[4][position] = dp[0][position - 1];
		}

		// Calculate the total count of valid strings by summing the counts for each vowel character at the last position.
		long totalCount = 0;
		for (int i = 0; i < 5; i++) {
			totalCount = (totalCount + dp[i][n - 1]) % MOD;
		}

		return (int) totalCount;
	}
}
