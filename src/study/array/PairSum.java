package study.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PairSum {

	public static void main(String[] args) {
		int n =5,sum= 5;
		int[] arr = {1, 2, 3, 4, 5}; 
		List<int[]> pair = pairSum(arr,sum);
		for(int[] ans : pair) {
			for(int i : ans) {
				System.out.print(i+" ");
			}
		}


	}
	
	 public static List<int[]> pairSum(int[] arr, int s) {
		 List<int[]> pair = new ArrayList();
		 Set<int[]> set = new TreeSet<>();
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i=0;i<arr.length;i++) {
	        	int comp= s-arr[i];
	        	if(map.containsKey(comp)) {
	        		//pair.add(new int[] {map.get(comp),arr[i]});
                 // pair.add(new int[]{comp,arr[i]});
                  set.add(new int[]{comp,arr[i]});
                  
	        	}
	        	map.put(arr[i], arr[i]);
	        }
	        return new ArrayList(set);
	    }

}
