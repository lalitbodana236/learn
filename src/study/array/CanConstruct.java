package study.array;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

	public static void main(String[] args) {
		System.out.println(canConstructOptimised("a","b"));
		System.out.println(canConstructOptimised("aa","ab"));
		System.out.println(canConstructOptimised("aa","aab"));
		System.out.println(canConstructOptimised("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));

	}
	
	public static boolean canConstructOptimised(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];
        
        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            if (alphabets_counter[c-'a'] == 0) return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }

	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<String,Integer> noteMap = new HashMap<>();
		Map<String,Integer> magMap = new HashMap();
		for(char c : ransomNote.toCharArray()){
			if(noteMap.containsKey(c+"")){
				noteMap.computeIfPresent(c+"", (k,v)->v+1);
			}else {
				noteMap.put(c+"", 1);
			}

		}

		for(char c : magazine.toCharArray()){
			if(magMap.containsKey(c+"")){
				magMap.computeIfPresent(c+"", (k,v)->v+1);
			}else {
				magMap.put(c+"", 1);
			}

		}
		System.out.println(noteMap+" "+ magMap);
		
		for(Map.Entry<String,Integer> map : noteMap.entrySet()) {
			String key = map.getKey();
			Integer value = map.getValue();
			if (!magMap.containsKey(key) || magMap.get(key) < value) {
                return false;
            }
		}
		
		return true;
	}

}
