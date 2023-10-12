package study.searching;

import java.util.Objects;

public class PivotElement {


	public static void main(String[] args) {
		int[] nums = {3,3,3,1};
		int pivot = findMin(nums);
		System.out.println("pivot "+pivot);
		if(nums[pivot]>nums[0])
			System.out.println("inner "+nums[0]);
		//System.out.println("outer "+ nums[pivot]); 

		int[] arr = {4,5,6,7,0,1,2};
		//System.out.println(findPivot(arr));

		int[] arr1 = {1,3,5,7};
		//System.out.println(arr1[findPivot(arr1)]);

		int[] arr2 = {1};
		//System.out.println(arr2[findPivot(arr2)]);

		int[] arr3 = {1,3,5,7,8};
		//System.out.println(arr3[findPivot(arr3)]);
	}

	static int findMin(int[] nums) {
		int start=0;
		int end=nums.length-1;
		while(start<end) {
			int mid=start + (end-start)/2;
			if(nums[mid]>nums[end]) {
				start= mid+1;
			}else {
				if(nums[mid]<nums[end]) {
					end=mid;
				}else
					end--;
			}

		}
		return end;

	}

	static int findPivot(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			System.out.println("mid "+mid);
			if(nums[mid] >= nums[0])
			{
				left = mid+1;
			}
			else{
				right = mid;
			}
		}
		return left;
	}



}
