package study.array;

import java.util.Arrays;

public class Klargest {

	public static void main(String[] args) {
		int size =5,k= 5;
		int[] arr = {0 ,10 ,1 ,2 ,2};
		//0 1 2 2 10
		int[] ans = Klargest(arr,size,k);
		for(int a : ans)
			System.out.print(a+" ");
		
		System.out.println();
		int size1 = 4,k1= 2;
		int[] arr1= {3, 4, 2, 1};
		int[] ans1 = Klargest(arr1,size1,k1);
		for(int a : ans1)
			System.out.print(a+" ");
		
		System.out.println();
		int size2 = 5,k2= 1;
		int[] arr2= {2, 2, 3, 3, 1};
		int[] ans2 = Klargest(arr2,size2,k2);
		for(int a : ans2)
			System.out.print(a+" ");
	}
	
	
	
	public static int[] Klargest(int[] a, int k, int n) {
        int[] ans = new int[n];
        Arrays.sort(a);

        int index = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (n <= 0 || k <= 0)
                break;

            ans[index] = a[i];
            n--;
            k--;
            index++;
        }
        Arrays.sort(ans);
        return ans;
    }
	
	 public static int[] KlargestOptimised(int[] a, int k, int n) {
	       Arrays.sort(a);
	        int[] res=new int[n];
	        int x=0;
	        for(int i=n-k;i<n;i++)
	        {
	            res[x++]=a[i];

	        }
	        return res;
	    }

}
