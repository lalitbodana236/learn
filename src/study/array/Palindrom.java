package study.array;

public class Palindrom {

	public static void main(String[] args) {
		System.out.println(palindrom("racecare"));
		System.out.println(palindrom(12345));

	}
	
	static boolean palindrom(int num) {
		int temp=num;
		int res=0;
		
		while(temp>0) {
			int rem = temp%10;
			res=res*10+rem;
			temp/=10;
		}
		System.out.println(res);
		return true;
	}
	
	static boolean palindrom(String s) {
		int start=0;
		int end=s.length()-1;
		while(start<=end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			
			start++;
			end--;
		}
		return true;
	}

}
