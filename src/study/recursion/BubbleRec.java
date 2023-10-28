package study.recursion;

public class BubbleRec {

	public static void main(String[] args) {
		int[] arr = {3,2,6,5,1,7,8,10,9};
		
		
		sortArray(arr,arr.length);
		

	}
	static boolean  isSwaped=false;
	static void sortArray(int[] arr,int n) {
		isSwaped=false;
		if(n==1) {
			return ;
		}
		System.out.println(" before ");
		for(int i : arr) {
			System.out.print(i+" ");
		}
		for(int i=0;i<n-1;i++) {
			if(arr[i]>arr[i+1]) {
				isSwaped=true;
				int temp = arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		if(!isSwaped)
			return ;
		sortArray(arr, n-1);
		
	}

}
