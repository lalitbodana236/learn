package study.array;

public class BinarySearch {
	static boolean isSorted(int arr[],int size,int first,int second)
	{	
		 if (second == size) {
	            return true;
	        }
		if(arr[first]>arr[second])
			return false;
		
			
		return isSorted(arr, size,second,second+1);
			
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,7,4,5,6};
		System.out.println(isSorted(arr,arr.length,0,1));
		
		int arr1[] = {3,2,5,1,6};
		System.out.println(getSum(arr1,arr1.length,0));
		
		System.out.println(isBinarySeach(arr,0,arr.length,5));
	}
	
	static boolean isBinarySeach(int arr[],int start,int end,int target) {
		if(start>end)
			return false;
		int mid = start+(end-start)/2;
		if(arr[mid]==target)
				return true;
		if(arr[mid]<target) {
			return isBinarySeach(arr,mid+1,end,target);
		}
		return isBinarySeach(arr,start,mid-1,target);
	}
	
	static boolean isLinearSearch(int[] arr,int size,int index,int target) {
		if(index==size)
			return false;
		if(arr[index]==target)
			return true;
		return isLinearSearch(arr,size,index+1,target);
	}
	
	static int getSum(int[] arr,int size,int index) {
		if(size==0)
			return 0;
		if(size==1)
			return arr[0];
		
		 if (index == size) {
	            return 0;
	        }

		 return arr[index]+getSum(arr, size,index+1);
		 
	}
}
