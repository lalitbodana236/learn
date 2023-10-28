package study.recursion;

public class MergeSortRec {
	public static void main(String[] args) {
		int[] arr = {38,27,43,3,9,82,10};
		mergeSort(arr,0,arr.length-1);


	}

	static void mergeSort(int[] arr,int start,int end) {
		System.out.println();
		for(int i:arr)
			System.out.print(i +" ");
		if(start>=end) {
			return;
		}

		int mid = (start+end)/2;
		//left part sorting
		mergeSort(arr,start,mid);

		//right part sorting
		mergeSort(arr,mid+1,end);

		merge(arr,start,end);


	}

	private static void merge(int[] arr, int start, int end) {
		int mid = (start+end)/2;

		int len1= mid-start+1;//length of first half
		int len2=end-mid; //length of second half

		int[] first = new int[len1];
		int[] second= new int[len2];

		//copy values
		int mainArrayIndex=start;
		for(int i=0;i<len1;i++) {
			first[i]=arr[mainArrayIndex++];	
		}

		for(int i=0;i<len2;i++) {
			second[i]=arr[mainArrayIndex++];

		}

		//merge 2 sorted array
		int index1=0;
		int index2=0;
		mainArrayIndex=start;
		while(index1<len1 && index2<len2) {
			if(first[index1]<second[index2]) {
				arr[mainArrayIndex++]=first[index1++];
			}else {
				arr[mainArrayIndex++]=second[index2++];
			}
		}

		while(index1<len1) {
			arr[mainArrayIndex++]=first[index1++];
		}

		while(index2<len2) {
			arr[mainArrayIndex++]=second[index2++];
		}



	}
	//merge two sorted array	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//m=3
		//n=2;
		//j=4

		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;

		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}
	}

}


