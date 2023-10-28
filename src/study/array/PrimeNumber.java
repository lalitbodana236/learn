package study.array;

import java.util.Arrays;

public class PrimeNumber {

	public static void main(String[] args) {
		boolean[] bool = seiveOfEratoSthenes(20);
		int i=0;
		for(boolean b : bool) {
			if(b)
				System.out.println(i+" "+b);
			i++;
		}

		System.out.println(gcd(24,60));

		System.out.println(fastPower(3978432,5,1000000007));

	}


	static boolean[] seiveOfEratoSthenes(int n){
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;
		for(int i=2;i*i<=n;i++) {
			for(int j=2*i;j<=n;j+=i) {
				isPrime[j]=false;
			}
		}

		return isPrime;
	}

	static int gcd(int a,int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}

	static int fastPower(int a,int b) {
		int res = 1;
		while(b>0) {
			if((b&1)!=0) {
				res=res*a;
			}
			a=a*a;
			b=b>>1;
		}
		return res;
	}
	
	static long fastPower(long a,long b,int n) {
		long res = 1;
		while(b>0) {
			if((b&1)!=0) {
				res=(res * a % n)%n;
			}
			a=(a%n*a%n)%n;
			b=b>>1;
		}
		return res;
	}

}
