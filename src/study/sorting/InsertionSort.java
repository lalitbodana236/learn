package study.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {8,4,1,5,9,2};
		sort(arr);

	}
	
	public static void sort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int temp =arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>temp) {
				SortingUtils.swap(arr, j, j+1);
				j--;
			}
			arr[j+1]=temp;
			SortingUtils.println(arr);
		}
	}

}
