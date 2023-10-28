package study.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {

	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		ArrayList<ArrayList<Integer>> asList = 	permute(list);
		for(ArrayList<Integer> i : asList)
			System.out.println(i);

	}
	
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

}
