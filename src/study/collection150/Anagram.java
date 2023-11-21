package study.collection150;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram","nagaram"));
		System.out.println(isAnagram("rat","car"));

	}

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
	
	public boolean isAnagramOptimised(String s, String t) {
        if(s.length()!=t.length())return false;
       HashMap<Character,Integer> map=new HashMap<Character,Integer>();
       for(int i=0;i<s.length();i++){
           map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
           map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
       }
       
       for(int i=0;i<s.length();i++){
           if(map.get(s.charAt(i))!=0)
           return false;
       }
       return true;   
   }

	/*public static boolean isAnagram(String s, String t) {
		Map<Character,Character> sMap = new HashMap();
		Map<Character,Character> tMap = new HashMap();
		for(int i=0;i<s.length();i++) {
			Character char1 = s.charAt(i);
			Character char2 = t.charAt(i);

			if(sMap.containsKey(char1)) {
				if (!sMap.get(char1).equals(char2)) {
					return false;
				}
			}else {
				sMap.put(char1, char2);
			}

			if(tMap.containsKey(char2)) {
				if (!tMap.get(char2).equals(char1)) {
					return false;
				}
			}else {
				tMap.put(char2, char1);
			}


		}

		return true;
	}*/

}
