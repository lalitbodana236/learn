package study.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Modulo {

	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 10};
        int result = numFactoredBinaryTrees(arr);
        System.out.println(result);
	}
	
	
	public static int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1000000007;
        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n]; // Initialize with 1, representing each number as a single-node tree

        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.put(arr[i], i);
        }
        System.out.println(valueToIndex);

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int div = arr[i] / arr[j];
                    System.out.println(" i "+i +" j "+j +" "+ arr[i] +" "+ arr[j] +" div "+div);
                    if (valueToIndex.containsKey(div)) {
                    	 System.out.println(" i "+dp[i]+" j "+dp[j]+" "+ arr[i] + " "+ dp[valueToIndex.get(div)]);
                       // dp[i] = (dp[i] + dp[j] * dp[valueToIndex.get(div)]) % MOD;
                    	 dp[i] = dp[i] + dp[j];
                    }
                }
            }
        }

        long result = 0;
        for (long count : dp) {
            //result = (result + count) % MOD;
            result = result + count;
        }

        return (int) result;
    }
	
	public static void findFactors(int number, Map<Integer, ArrayList<Integer>> map) {
		ArrayList<Integer> list= new ArrayList<>();
		System.out.println();
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                list.add(i);
            }
        }
        map.put(number, list);
    }

}
