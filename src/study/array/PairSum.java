package study.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PairSum {

	public static void main(String[] args) {
		int n =5,sum= 4;


		int[] arr = {2 ,-6 ,2, 5, 2 }; 
		List<int[]> pair = pairSum(arr,sum);
		for(int[] ans : pair) {
			for(int i : ans) {
				System.out.print(i+" ");
			}
		}


	}
	
	 public static List<int[]> pairSumOptimised(int[] arr, int s) {
	       List<int[]> result = new ArrayList<>();
	       Arrays.sort(arr); // sorting in asscending order 

	       for(int i =0; i<arr.length; i++){
	           for(int j =i+1; j<arr.length; j++){
	               if(arr[i]+arr[j]==s){
	                   int res[] = new int[2];
	                   res[0]=arr[i];
	                   res[1]=arr[j];
	                   result.add(res);
	               }
	           }
	       }
	       return result;
	    }

	public static List<int[]> pairSum(int[] arr, int s) {
		List<int[]> result = new ArrayList<>();
        Set<Integer> set = new HashSet();

        for (int num : arr) {
            int complement = s - num;

            if (set.contains(complement)) {
                int[] pair = {complement, num};
                result.add(pair);
            }

            set.add(num);
        }

        return result;
	}

}
