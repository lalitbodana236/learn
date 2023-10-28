package study.array;

public class RotateArrayByK {
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};
		int k=3;
		int n = nums.length;
		    k = k % n; // Handle the case where k is larger than the array length

		    reverse(nums, 0, n - 1); // Reverse the entire array
		    for(int j : nums) {
		    	System.out.print(j+" ");
		    }
		    System.out.println();
		    reverse(nums, 0, k - 1); // Reverse the first k elements
		    for(int j : nums) {
		    	System.out.print(j+" ");
		    }
		    System.out.println();
		    reverse(nums, k, n - 1); // Reverse the remaining elements
		    for(int j : nums) {
		    	System.out.print(j+" ");
		    }
	}
	
	 private static void reverse(int[] nums, int start, int end) {
	        while (start < end) {
	            int temp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = temp;
	            start++;
	            end--;
	        }
	    }
	
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n; // Handle the case where k is larger than the array length

		for (int i = 0; i < k; i++) {
			rotateRightByOne(nums); // Rotate the array to the right by one position, 'k' times.
		}
		for(int j : nums){
			System.out.print(j +" ");
		}

	}

	public void rotateRightByOne(int[] nums) {
		int n = nums.length;
		if (n <= 1) {
			return; // No need to rotate if the array has 0 or 1 element.
		}

		int temp = nums[n - 1]; // Store the last element temporarily.

		for (int i = n - 1; i > 0; i--) {
			nums[i] = nums[i - 1]; // Shift elements to the right.
		}

		nums[0] = temp; // Put the last element at the beginning.
	}
}
