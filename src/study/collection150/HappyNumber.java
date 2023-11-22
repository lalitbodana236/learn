package study.collection150;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isHappy(int n) {
	      Set<Integer> seen = new HashSet<>();

	        while (n != 1 && !seen.contains(n)) {
	            seen.add(n);
	            n = square(n);
	        }
	        
	        return n == 1;
	    }

	    public int square(int num) {
	        
	        int ans = 0;
	        
	        while(num > 0) {
	            int remainder = num % 10;
	            ans += remainder * remainder;
	            num /= 10;
	        }
	        
	        return ans;
	    }
	

	public boolean isHappyRec(int n) {
		int sum=0;
		if(n==1) {
			return true;
		}else if(n==4) {
			return false;
		}
		else {
			while(n>0){
				int digit =n%10;
				sum+=digit*digit;
				n/=10;
			}

			return isHappyRec(n);
		}

	}
	
}
