package study.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequenceRec {
	public static void main(String[] args) {
        int n = 3; // Change n to the desired value.
        int k = 3; // Change k to the desired value.
        String result = getPermutation(n, k);
        System.out.println(result);
    }

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return findPermutation(numbers, k);
    }

    private static String findPermutation(List<Integer> numbers, int k) {
        int n = numbers.size();
        if (n == 0) {
            return "";
        }
        int factorial = calculateFactorial(n - 1);
        int index = (k - 1) / factorial;
        int num = numbers.remove(index);
        return num + findPermutation(numbers, k - index * factorial);
    }

    private static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
