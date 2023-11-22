package study.collection150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	public static void main(String[] args) {
		for(List<String> wordList : groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"})){
			System.out.println(wordList);
		}

	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String sorted = String.valueOf(characters);
            System.out.println("sorted "+sorted);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }

	/*public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ansList = new ArrayList<>();
		for(int i=0;i<strs.length;i++) {
			List<String> wordList= new ArrayList<>();
			for(int j=i;j<strs.length;j++) {
				if(isAnagram(strs[i], strs[j])) {
					wordList.add(strs[j]);
				}
			}
			ansList.add(wordList);
		}
		
		return ansList;
	}*/
	
	public static boolean isAnagram(String s, String t) {
		Map<Character,Integer> sMap = new HashMap();
		for(int i=0;i<s.length();i++) {
			Character char1 = s.charAt(i);
			sMap.computeIfPresent(char1, (k,v)->v+1);
			sMap.putIfAbsent(char1, 1);
		}
		
		for(Character c : t.toCharArray()) {
			if(sMap.containsKey(c) && sMap.get(c)>0) {
				sMap.computeIfPresent(c, (k,v)->v-1);
			}else {
				return false;
			}
		}

		return true;
	}

}
