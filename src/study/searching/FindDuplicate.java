package study.searching;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicate {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        
        for (int num : nums) {
            map.computeIfPresent(num, (k, v) -> v + 1);
            map.putIfAbsent(num, 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if(entry.getValue()<2)
        		System.out.println(entry.getKey() + " " + entry.getValue());
        }
	}

}
