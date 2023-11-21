package study.collection150;

import study.sorting.SortingUtils;

public class RotateArray {

	public static void main(String[] args) {
		//Input: nums = [1,2,3,4,5,6,7], k = 3
		//		Output: [5,6,7,1,2,3,4]
		
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		rotate(nums,0,nums.length);
		SortingUtils.println(nums);
		rotate(nums,0,k);
		SortingUtils.println(nums);
		rotate(nums,k,nums.length);
		SortingUtils.println(nums);
	}
	
	static void rotate(int[] arr ,int s,int n) {
		int start=s;
		int end=n-1;
		while(start<end) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
			
		}
		
	}

}
