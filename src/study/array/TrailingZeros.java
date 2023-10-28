package study.array;

public class TrailingZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int findZero(int n) {
		int res=0;
		for(int i=5;i<=n;i=i*5) {
			res = res+n/i;
		}
		return res;
	}

}
