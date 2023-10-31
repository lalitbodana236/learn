package study.sorting;

public class SortingUtils {

	static void println(int[] a) {
		
		for(int i : a)
			System.out.print(i+" ");
		
		System.out.println(" ");
	}

	static void swap(int[] a,int first,int second) {
		int temp = a[first];
		a[first]=a[second];
		a[second]=temp;
	}

}
