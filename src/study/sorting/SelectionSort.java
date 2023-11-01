package study.sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {4,1,9,2,3,6};
		sort(arr);
	}
	
	public static void sort(int[] arr) {
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int min = i ;
			
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min]) {
					min=j;
				}
			}
			
			if(min!=i) {
				SortingUtils.swap(arr, min, i);
			}
			
			SortingUtils.println(arr);
		}
	}
}


