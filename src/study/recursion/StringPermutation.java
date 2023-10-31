package study.recursion;

import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {

//	public static void main(String[] args) {
//		ArrayList<Integer> list= new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		
//		//ArrayList<ArrayList<Integer>> asList = 	permute(list);
//		//for(ArrayList<Integer> i : asList)
//			//System.out.println(i);
//		getPermutation(123,2);
//
//	}
	
	static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> arr){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int index=0;
		solve(arr,ans,index);
		return ans;
	}

	private static void solve(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ans, int index) {
		if(index>=nums.size()) {
			ans.add(new ArrayList<>(nums));
			return;
		}
		
		for(int j=index;j<nums.size();j++) {
			int temp = nums.get(index);
			nums.set(index, nums.get(j));
			nums.set(j, temp);
			solve(nums, ans, index+1);
			
			 temp = nums.get(index);
			nums.set(index, nums.get(j));
			nums.set(j, temp);
			
		}
		
	}
	
		
	public static void main(String[] args) {
        int n = 3; // Change n to the desired value
        List<String> permutations = generatePermutations(n);
        printPermutations(permutations);
    }

    public static List<String> generatePermutations(int n) {
        List<String> permutations = new ArrayList<>();
        StringBuilder currentPermutation = new StringBuilder();
        boolean[] used = new boolean[n];

        generatePermutationsHelper(n, used, currentPermutation, permutations);

        return permutations;
    }

    private static void generatePermutationsHelper(int n, boolean[] used, StringBuilder currentPermutation, List<String> permutations) {
    	if (currentPermutation.length() == n) {
    		
    			permutations.add(currentPermutation.toString());
            return;
        }
        

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                currentPermutation.append(i + 1); // Add 1 to convert from 0-based to 1-based index
             
                used[i] = true;
                generatePermutationsHelper(n, used, currentPermutation, permutations);
                 used[i] = false;
                //System.out.println("inside "+currentPermutation);
                currentPermutation.deleteCharAt(currentPermutation.length() - 1);
            }
        }
    }

    public static void printPermutations(List<String> permutations) {
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

}
