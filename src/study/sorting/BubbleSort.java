package study.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = {4,3,7,1,5};
		SortingUtils.println(a);
		sort(a);
		SortingUtils.println(a);
	}
	
	static void sort(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j+1]<arr[j]) {
					SortingUtils.swap(arr, j+1, j);
				}
				
			}
			SortingUtils.println(arr);
		}
	}
}
