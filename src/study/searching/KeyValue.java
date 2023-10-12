package study.searching;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyValue {
	public static void main(String[] args) {
		TimeMap obj = new TimeMap();
		obj.set("foo","bar",1);
		String param_2 = obj.get("foo",1);
		System.out.println(param_2);

		String param_3 = obj.get("foo",3);
		System.out.println(param_3);

		obj.set("foo","bar2",4);
		String param_4 = obj.get("foo",4);
		System.out.println(param_4);

		String param_5 = obj.get("foo",5);
		System.out.println(param_5);
	}
}
class Pair{
	String value;
	int timestamp;
	public Pair(String value,int timestamp) {
		this.value=value;
		this.timestamp=timestamp;
	}
}

class TimeMap {
	HashMap<String,ArrayList<Pair>> map ;
	public TimeMap() {
		map =new HashMap();
	}

	public void set(String key, String value, int timestamp) {
		
		map.computeIfPresent(key, (k,v)->{
			v.add(new Pair(value,timestamp) );
			return v;
		});
		map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
	}

	public String get(String key, int timestamp) {
		if(map.containsKey(key)){
			ArrayList<Pair> list = map.get(key);
			String cand = "";

			int left = 0;
			int right=list.size()-1;

			if(list.get(left).timestamp>timestamp) 
				return "";
			if(list.get(right).timestamp<=timestamp) 
				return list.get(right).value;

			while(left<=right) {
				int mid= left + (right-left)/2;

				if(list.get(mid).timestamp==timestamp) {
					return list.get(mid).value;
				}else if(list.get(mid).timestamp<timestamp) {
					cand = list.get(left).value;
					left=mid+1;
				}else
					right=mid-1;
			}

			return cand;
		}

		return "";
	}
}