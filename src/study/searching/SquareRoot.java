package study.searching;

public class SquareRoot {
	static int sqrt(int a) {
		if (a < 2) {
			return a;
		}
		int left = 0;
		int right = a;
		while (left < right) {
			int mid = left + (right - left) / 2;

			if (mid * mid == a) {
				return mid;
			} else if (mid * mid < a) {
				left = mid+1;
			} else {
				right = mid-1;
			}
			if(left==right)
				return mid;
		}
		return left;
	}

	static boolean isPerfectSquare(int a) {
		if (a==1) {
			return true;
		}
		int left = 0;
		int right = a;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid * mid == a) {
				return true;
			} else if (mid * mid < a) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		return false ;
	}

	static int arrangeCoins(int n) {
		if (n < 2) {
			return n;
		}

		int left = 0;
		int right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid * (mid+1)/2 ==n) {
				return mid;
			} else if (n > mid * (mid+1) / 2) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		return left;
	}

	public static void main(String[] args) {


		System.out.println("The square root of 5 is ---> " + arrangeCoins(5));
		System.out.println("The square root of 8 is ---> " + arrangeCoins(8));
	}
}
