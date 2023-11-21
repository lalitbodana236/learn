package study.array;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean isIsomorphicOptimised(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
	
	public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false;
                }
            } else {
                mapST.put(charS, charT);
            }

           
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false;
                }
            } else {
                mapTS.put(charT, charS);
            }
        }

        return true;
    }

}
