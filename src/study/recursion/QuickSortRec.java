package study.recursion;

public class QuickSortRec {

	public static void main(String[] args) {
		int[] arr= {2,4,1,6,9};
		int n=5;
		quickSort(arr,0,n-1);


	}

	private static void quickSort(int[] arr, int start, int end) {
		System.out.println(" ");
		for(int i : arr)
			System.out.print(i+" ");
		if(start>=end) {
			return;
		}

		//partition
		int p=partition(arr,start,end);

		//left
		quickSort(arr, start, p-1);

		//right
		quickSort(arr, p+1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot =arr[start];
		int count=0;
		for(int i=start+1;i<=end;i++) {
			if(arr[i]<=pivot) {
				count++;
			}
		}

		//put pivot element at correct position
		int pivotIndex = start+count;

		int temp = arr[pivotIndex];
		arr[pivotIndex]=arr[start];
		arr[start]=temp;

		//make smaller elements lie before pivot & larger elements after pivot
		int i=start,j=end;
		while(i<pivotIndex && j>pivotIndex) {

			//move i++ till we find element greater than pivot element in left side
			while(arr[i]<pivot) {
				i++;
			}

			//move j-- till we find smaller elements than pivot in right side
			while(arr[j]>pivot) {
				j--;
			}

			//swap the values if found
			if(i<pivotIndex && j>pivotIndex) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j]=temp;

			}
			i++;
			j--;
		}



		return pivotIndex;
	}

}
