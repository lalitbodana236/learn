package study.searching;

public class FindBitonic {
	static int findBitonicPoint(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			//if(mid > 0 && mid < nums.length-1) {
				if (nums[mid - 1] < nums[mid] &&  nums[mid + 1] < nums[mid]) {
					return mid;
				} 
			//}
			if (mid > 0 && nums[mid - 1] < nums[mid]) {
				left = mid+1;
			} else {
				right = mid;
			}


		}
		return -1;

	}
	
	static int binarySearch(int[] nums,int left,int right,int target) {
		while(left<=right) {
			int mid= left + (right-left)/2;
			if(nums[mid]==target) {
				return mid;
			}else if(nums[mid]<target) {
				left = mid+1;
			}else {
				right=mid-1;
			}
			
		}
		return -1;
	}
	
	 static int searchInBitonicArray(int[] nums, int target) {
		    int bitonicPoint = findBitonicPoint(nums);
		   System.out.println("bitonicPoint "+bitonicPoint);
		    int indexInLeftPart = binarySearch(nums, 0, bitonicPoint, target);
		    if (-1 != indexInLeftPart) {
		      return indexInLeftPart;
		    }
		    
		    int indexInRightPart = binarySearch(nums, bitonicPoint+1, nums.length-1, target); 
		    
		    if (-1 != indexInRightPart) {
		      return indexInRightPart;
		    }

		    return -1;
		  }

	public static void main(String[] args) {

	int[] nums1 = new int[] {-8, 1, 2, 3, 4, 5, -2, -3, -9};
		int[] nums2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		int[] nums3 = new int[] {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		//System.out.println("The peak index is ---> " + findBitonicPoint(nums1));
		//System.out.println("The peak index is ---> " + findBitonicPoint(nums2));
		//System.out.println("The peak index is ---> " + findBitonicPoint(nums3));
		
		
		 int[] nums = new int[] {-8, 1, 2, 3, 4, 5, -2, -3, -9};

		    System.out.println("Index of 5 is ---> " + searchInBitonicArray(nums, 5));
		    System.out.println("Index of 1 is ---> " + searchInBitonicArray(nums, 1));
		    System.out.println("Index of -9 is ---> " + searchInBitonicArray(nums, -9));
		    System.out.println("Index of -1 is ---> " + searchInBitonicArray(nums, -1));
	}
}
