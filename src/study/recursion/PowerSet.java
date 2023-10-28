package study.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	//power set  set of all subset
	// 2^n
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		
				List<List<Integer>> list = subsetsWithoutRec(nums);
				for(List<Integer> i : list) {
					System.out.println(i+" ");
				}
			
		
		
	}
	
	public static List<List<Integer>> subsetsWithoutRec(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // Total number of subsets (2^n).
System.out.println("totalSubsets "+totalSubsets);
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            System.out.println();
            for (int j = 0; j < n; j++) {
            	System.out.print(i+" "+j +" "+((i & (1 << j)) != 0)+"  ");
                if ((i & (1 << j)) != 0) {
                	System.out.print(nums[j]+" ");
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> output = new ArrayList<>();
		int index=0;
		solve(nums,output,index,ans);
		return ans;
	}

	private void solve(int[] nums, List<Integer> output, int index, List<List<Integer>> ans) {
		//base case
		if(index==nums.length) {
			ans.add(new ArrayList<>(output));
			return ;
		}

		//exclude
		solve(nums, output, index+1, ans);

		///include;
		int element = nums[index];
		output.add(element);
		solve(nums, output, index+1, ans);

		// Backtrack by removing the current element from the output.
		output.remove(output.size() - 1);

	}

}
