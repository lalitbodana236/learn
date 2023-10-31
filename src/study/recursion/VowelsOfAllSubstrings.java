package study.recursion;

import java.util.ArrayList;
import java.util.List;

public class VowelsOfAllSubstrings {

	public static void main(String[] args) {
		String word = "abc";
		generatePermutations(word);

	}
	
	  public static void generatePermutations(String n) {
	        List<String> permutations = new ArrayList<>();
	        StringBuilder currentPermutation = new StringBuilder();
	        boolean[] used = new boolean[n.length()];

	        generatePermutationsHelper(n, used, currentPermutation, permutations);
	        for(String s : permutations) {
	        	System.out.println(s);
	        }

	   
	    }
	  
	  private static void generatePermutationsHelper(String n, boolean[] used, StringBuilder currentPermutation, List<String> permutations) {
	    	if (currentPermutation.length() == n.length()) {
	    		if(currentPermutation.toString().contains("a"))
	    			permutations.add(currentPermutation.toString());
	            return;
	        }
	        

	        for (int i = 0; i < n.length(); i++) {
	            if (!used[i]) {
	                currentPermutation.append(n.charAt(i)); // Add 1 to convert from 0-based to 1-based index
	             
	                used[i] = true;
	                generatePermutationsHelper(n, used, currentPermutation, permutations);
	                 used[i] = false;
	                //System.out.println("inside "+currentPermutation);
	                currentPermutation.deleteCharAt(currentPermutation.length() - 1);
	            }
	        }
	    }

}
