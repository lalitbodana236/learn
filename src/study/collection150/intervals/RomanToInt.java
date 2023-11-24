package study.collection150.intervals;

public class RomanToInt {

	public static void main(String[] args) {

		//System.out.println(romanToInt("III"));
		
		System.out.println(intToRoman(14));
	}
	
	public static String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};
        
        System.out.println((num%1000)/100+" "+(num%100)/10 +" "+ num%10);
        
        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }

	public static int romanToInt(String s) {
		int roman=0;
		for(int i=0;i<s.length();i++) {
			int s1 = value(s.charAt(i));
			if(i+1<s.length()) {
				int s2=value(s.charAt(i+1));
                if(s1>=s2)
                    roman+=s1;
                else 
                    roman=roman-s1;
			}else {
				roman+=s1;
			}
		}
		return roman;
	}
	
	
	public static int value(char r) {
		if(r=='I') 
            return 1;
        if(r=='V') 
            return 5;
        if(r=='X') 
            return 10;
        if(r=='L') 
            return 50;
        if(r=='C') 
            return 100;
        if(r=='D') 
            return 500;
        if(r=='M') 
            return 1000;
        return -1;
	}

}
