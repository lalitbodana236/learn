package study.recursion;

public class Power {
	public static void main(String[] args) {
		int a=3,b=3;
		System.out.println(power(a,b));
	}

	private static int power(int a, int b) {
		if(b==0)
			return 1;
		if(b==1)
			return a;
		
		int ans = power(a,b/2);
		
		if(b%2==0) {
			return ans*ans;
		}
		else {
			return a * ans*ans;
		}
	}
}
