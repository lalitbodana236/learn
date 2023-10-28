package study.recursion;

public class Palindrom {
	
	 static String swap(String str,int start,int end) {
		System.out.println("before swap : "+str);
		char[] cArray = str.toCharArray();
		char c = cArray[start];
		cArray[start] = cArray[end];
		cArray[end]=c;
		str = new String(cArray);
		System.out.println("after swap  : "+str);
		
		return str;
	}
	/**With custom swap function*/
	static String reverse(String str ,int start,int end) {
		if(start>=end) {
			return str;
		}
		str = swap(str,start,end);
		return reverse(str, start+1, end-1);
	}

	
	/**With StringBuilder reverse fucntion*/
	public static String reverseString(String str) {
		if (str == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
	}

	/**With custom substring login*/
	 private static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char firstChar = str.charAt(0);
        String remaining = str.substring(1);
        return reverse(remaining) + firstChar;
    }
	 
	 static boolean isPalindrome(String str,int start,int end) {
		 if(start>end) {
			 return true ;
		 }
		 if(str.charAt(start)!=str.charAt(end))
			 return false;
		
		return	 isPalindrome(str,start+1,end-1);
		 
	
			 
	 }

	 public static void main(String[] args) {
			String name = "boacdaob";
			System.out.println("final "+isPalindrome(name,0,name.length()-1));
		}
	

}
