package study.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		//int[]  nums = {-1,0,1,2,-1,-4};
		//int[]  nums1 = {0,0,0};
		int[] nums = {-1,2,1,-4};
		List<List<Integer>> list = threeSum(nums);
		for(List<Integer> i  : list) {
			System.out.println(i);
			
		}
	// [[-1,-1,2],[-1,0,1]]

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list= new ArrayList<>();
		int temp=0;
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				
				for(int k=j+1;k<nums.length;k++) {
					List<Integer> sumList= new ArrayList<>();
				
					int sum = nums[i]+nums[j]+nums[k];
					if(i!=j && i!=k && j!=k ) {
							if(temp<sum) {
								temp=sum;
							}
						System.out.println("sum "+temp);
						sumList.add(nums[i]);
						sumList.add(nums[j]);
						sumList.add(nums[k]);
						sort(sumList);
						if(!list.contains(sumList))
							list.add(sumList);
					}
				}
			}

		}
		
		return list;

	}
	
	static void sort(List<Integer> sumList) {
		for(int i=0;i<sumList.size();i++) {
			for(int j=i+1;j<sumList.size();j++) {
				if(sumList.get(i)>sumList.get(j)) {
					int temp = sumList.get(i);
					sumList.set(i, sumList.get(j));
					sumList.set(j, temp);
				}
			}
		}
	}

}
