package study.array;

public class ReverseInteger {
	public static void main(String[] args) {
		double x=2.00000;
		System.out.println(1/2);
		int n=-1;
		double ans=1;
		while(n!=0) {
			if(n>0) {
				ans=ans*x;
			}else {
				ans=ans%2;
			}
			n--;
		}
		System.out.println(ans);
	}
	
	 public String multiply(String num1, String num2) {
	        Long d1 = Long.parseLong(num1);
	        Long d2 = Long.parseLong(num2);
	        return (d1 *d2)+"";
	    }
	
	public static int reverse(int x) {
        int reversed=0;
        while(x!=0){
            int rem= x%10;
            reversed = reversed * 10+rem;
            x/=10;
        }
        System.out.println(reversed);
       
        
        return reversed;
    }
}
