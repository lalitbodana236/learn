package study.math;

public class PowerOfAnyNumber {
	static long highest=1;
	public static void main(String[] args) {
		int base = 2; // Change this to the desired base number.

        long largestPower = 1;
        while (largestPower * base <= Integer.MAX_VALUE) {
            largestPower *= base;
        }
        highest=largestPower;
        System.out.println("The largest power of " + base + " within the 32-bit signed integer range is: " + largestPower);
        System.out.println(isPowerOfFour(256));
	}
	
	public static boolean isPowerOfTwo(int n) {
        return n > 0 && highest % n == 0;
    }
	
	public static boolean isPowerOfFour(int n) {
        return n > 0 && highest % n == 0;
    }
	
	public static boolean isPowerOfThree(int n) {
        return n > 0 && highest % n == 0;
    }
	
	public static boolean isPowerOfFive(int n) {
        return n > 0 && highest % n == 0;
    }
	
	public static boolean isPowerOfEleven(int n) {
        return n > 0 && highest % n == 0;
    }

}
