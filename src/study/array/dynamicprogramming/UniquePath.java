package study.array.dynamicprogramming;

import java.util.Arrays;

public class UniquePath {

	public static void main(String[] args) {
		int m = 3, n = 2;
		System.out.println(uniquePaths(m,n));

	}

	public static int uniquePaths(int m, int n) {
		int ans=0;
		
		boolean[][] path = new boolean[m][n];
		Arrays.fill(path, false);
		
		solve(0, 0, ans, path, "");

		return ans;
	}

	private static void solve(int i, int j, int ans, boolean[][] path, String string) {
		// TODO Auto-generated method stub
		
	}

}
