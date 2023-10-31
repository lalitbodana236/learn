package study.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        int n = 3; // Change n to the desired value.
        int k = 3; // Change k to the desired value.
        String result = getPermutation(n, k);
        System.out.println(result);
    }

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];

        // Initialize the numbers and factorial array.
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial[i] = i == 1 ? 1 : i * factorial[i - 1];
        }
        for (int i = 1; i <= n; i++) {
        	System.out.println("fact "+ factorial[i] );
        }

        StringBuilder result = new StringBuilder();
        k--; // Adjust k to 0-based index.

        for (int i = 1; i <= n; i++) {
            int index = k / (n - i == 0 ? 1 : factorial[n - i]); // Handle factorial of 0.
           System.out.println("index "+index+" "+numbers.get(index));
            result.append(numbers.get(index));
            numbers.remove(index);
            k -= index * (n - i == 0 ? 1 : factorial[n - i]); // Handle factorial of 0.
        }

        return result.toString();
    }
}
