package study.searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpellsAndPotions {

	public static void main(String[] args) {
		int[] spells = {13,22,21,13,11,9,13,35,7,38,10,10,38,19,3,16,13,24,16,27,20,24,32,5,16,35,24,2,25,32,20,22,22,3,35,39,27,26,25,21,27,40,15,17,24,40,35,27,20,40,9,35,27,19,15,34,35,37,17,40,8,3,33,39,29,22,30,1,37,2,16,30,32,31,24,6,34,26,36,4,21,2,29,31,3,27,6,24,40,18};
		int[] potions = {33,16,35,14,26,23,23,2,37,23,15,20,25,34,23,29,4,18,26,24,16,37,15,11,33,24,12,13,7,24,3,26,1,3,38,33,19,3,34,22,30,39,18,7,21,4,33,18,39,5,34,14,32,5,20,22,5,25,15};
		int success = 533;
		successfulPairs(spells,potions,success);
	}
	
	public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        LinkedHashMap<String,ArrayList<Integer>> map = new LinkedHashMap<>();
        int i=0;
        
        while(i<spells.length) {
        	for(int j =0; j<potions.length;j++) {
        		int index=j;
        		int outerIndex=i;
        		if(map.containsKey(i+""+spells[i])) {
        			map.computeIfPresent(i+""+spells[outerIndex], (k,v)->{
                		v.add(spells[outerIndex]*potions[index]);
                		return v;
                	});
        		}else {
        			
        			map.putIfAbsent(outerIndex+""+spells[outerIndex], new ArrayList<>());
        			map.get(outerIndex+""+spells[outerIndex]).add(spells[outerIndex]*potions[j]);
        		}
        	}
        	i++;
        }
        
//        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
//        		System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        
        int k=0;
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
        	long count = entry.getValue().stream().filter(val -> val >= success).count();
        	ans[k] =(int)count;
        	System.out.println(k+" "+count);
        	k++;
        }
        int[] l = {0,21,19,0,0,0,0,39,0,42,0,0,42,16,0,9,0,28,9,33,16,28,37,0,9,39,28,0,30,37,16,21,21,0,39,44,33,31,30,19,33,44,5,14,28,44,39,33,16,44,0,39,33,16,5,39,39,42,14,44,0,37,44,34,21,37,0,42,0,9,37,37,37,28,0,39,31,42,0,19,0,34,37,0,33,0,28,44,15,0};
      System.out.println(l.length +" "+ ans.length);
        // for(int a : ans) {
        //	System.out.print (" "+a);
       // }
        
        return ans;
    }

}
