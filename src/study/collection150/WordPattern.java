package study.collection150;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> cMap = new HashMap();
        Map<String, Character> sMap = new HashMap();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (cMap.containsKey(ch)) {
                if (!cMap.get(ch).equals(word)) {
                    return false;
                }
            } else {
            	cMap.put(ch, word);
            }
            
            System.out.println(cMap);

            if (sMap.containsKey(word)) {
                if (sMap.get(word) != ch) {
                    return false;
                }
            } else {
            	sMap.put(word, ch);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println("Does s1 follow the pattern? " + wordPattern(pattern1, s1));

        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println("Does s2 follow the pattern? " + wordPattern(pattern2, s2));

        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println("Does s3 follow the pattern? " + wordPattern(pattern3, s3));

        String pattern4 = "abba";
        String s4 = "dog dog dog dog";
        System.out.println("Does s4 follow the pattern? " + wordPattern(pattern4, s4));
    }


}
