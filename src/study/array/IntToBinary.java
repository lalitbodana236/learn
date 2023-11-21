package study.array;

import java.util.HashMap;
import java.util.Map;

public class IntToBinary {

	public static void main(String[] args) {
		countHomogenous("abbcccaa");
	}
	
	public static int countHomogenous(String s) {
	       Map<String,Integer>map = new HashMap<>();
	       for(char c : s.toCharArray()){
	           if(map.containsKey(c+"")){
	               map.computeIfPresent(c+"", (k,v)->+v+1);
	           }else {
	        	   map.put(c+"", 1);
	           }
	       }
	       System.out.println(map);
	       int sum=0;
	       for(Map.Entry<String, Integer> entry : map.entrySet()) {
	    	   sum+=entry.getValue();
	       }
	      return sum; 
	}

}
