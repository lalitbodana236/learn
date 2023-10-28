package study.array;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String s = "a good   example";
		int count=0;
		List<String> list= new ArrayList<>();
		String str="";
		for(char c : s.toCharArray()) {
			if(c==' ') {
				count++;
				if(count==1) {
					str=str.replace(" ", "");
					list.add(str);
				}
				str="";
			}else {
				count=0;
				str=str+c;
			}
			System.out.println(str);
			
		}
		list.add(str);
		System.out.println(list);
		for(int i=list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}

	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		String prefix = strs[0];

		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";
				}

			}
		}

		return prefix;
	}

}
