package study.searching;

public class BinarySearch {
	public static void main(String[] args) {

		//	int[] nums = new int[] {1,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59};

		//System.out.println("Index of 37 is ---> " + binarySearch(nums, 37));
		//System.out.println("Index of 1 is ---> " + binarySearch(nums, 1));
		//System.out.println("Index of 59 is ---> " + binarySearch(nums, 59));
		//System.out.println("Index of 25 is ---> " + binarySearch(nums, 25));

		//	int[] nums1 = new int[] {1, 5, 8, 9, 11, 13, 15, 19, 21};

		//System.out.println("Index of 9 is ---> " + searchInsert(nums1, 9));
		//System.out.println("Index of 12 is ---> " + searchInsert(nums1, 12));
		//System.out.println("Index of -4 is ---> " + searchInsert(nums1, -4));
		//System.out.println("Index of 27 is ---> " + searchInsert(nums1, 27));

		//		int[] nums2 = new int [] {1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10 };
		//		System.out.println("Index ---> " + duplicateNumber(nums2));
		//		int[] nums3 = new int [] {1,1,2,3,4};
		//		System.out.println("Index ---> " + duplicateNumber(nums3));
		//		int[] nums4 = new int [] {1,2,3,4,5,5};
		//		System.out.println("Index ---> " + duplicateNumber(nums4));
		//		int[] nums5 = new int [] {1,1};
		//		System.out.println("Index ---> " + duplicateNumber(nums5));
		//		int[] nums6 = new int [] {1, 2, 3, 4, 5, 6, 6};
		//		System.out.println("Index ---> " + duplicateNumber(nums6));

		int[] nums1 = new int[] {1, 5, 8, 9, 11, 13, 15, 19, 21};
		int[] nums2 = new int[] {-8, -2, -1, 0, 2, 5, 8, 9};
		int[] nums3 = new int[] {-1, 0, 1, 2, 3, 4, 5, 6, 7, 9};
		int[] nums4 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		System.out.println("The fixed index is ---> " + fixedPoint(nums1));
		System.out.println("The fixed index is ---> " + fixedPoint(nums2));
		System.out.println("The fixed index is ---> " + fixedPoint(nums3));
		System.out.println("The fixed index is ---> " + fixedPoint(nums4));

	}

	static int binarySearch(int[] nums, int target){
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length;
		while (left<= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		if (nums[left] == target) {
			return left;
		}
		return -1;
	}

	static int  searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (mid>=nums.length || nums[mid] == target) {
				return mid;
			} else if ( nums[mid] < target) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		if (nums[left] >= target) {
			return left;
		}
		return right;
	}

	static int duplicateNumber(int[] nums) {
		int left = 0;
		int right = nums.length;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if(mid>=nums.length)
				return -1;


			if (mid-1>0 && nums[mid] == nums[mid - 1]) {
				return nums[mid];
			} else if (nums[mid] > mid) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}

		return nums[left];
	}

	static int fixedPoint(int[] nums) {
		int left = 0;
		int right = nums.length;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == mid && left < nums[left]) {
				return mid;
			} else if (nums[mid] < mid) {
				left = mid+1;
			} else {
				right = mid-1;
			}
		}
		if (nums[left] == left) {
			return left;
		}
		if (right>0 && right < nums.length && nums[right] == right) {
			return right;
		}

		return -1;
	}

}
