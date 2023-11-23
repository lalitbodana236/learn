package study.collection150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		merge(intervals);
	}

	public int[][] mergefor(int[][] intervals) {
		List<int[]> result = new ArrayList<>();
		if (intervals.length <= 1)
			return intervals;

		Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

		int[] currentInterval = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			int[] nextInterval = intervals[i];
			if (currentInterval[1] >= nextInterval[0]) {
				currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
			} else {
				result.add(currentInterval);
				currentInterval = nextInterval;
			}
		}
		result.add(currentInterval);

		return result.toArray(new int[result.size()][]);
	}

	public static int[][] merge(int[][] intervals) {
		List<int[]> result = new ArrayList<>();
		int[] in = intervals[0];
		int i=1;

		while(i<intervals.length) {

			if(in[1]<intervals[i][0]) {
				result.add(in);
				in=intervals[i];
			}else {
				in[1] = Math.max(in[1], intervals[i][1]);
			}
			i++;
		}
		result.add(in);

		for(int[] j : result) {
			System.out.println(j[0]+" "+j[1]);
		}

		return result.toArray(new int[result.size()][])   ;
	}

























	/*public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length<=1)
            return intervals;

        Arrays.sort(intervals,(i1,i2)->i1[0]-i2[0]);
        int[] in = intervals[0];

        int i=1;
        while(i<intervals.length){
            if(in[1]<intervals[i][0]){

                result.add(in);
                in = intervals[i];
            }else{
                in[1]=Math.max(in[1],intervals[i][1]);
            }
            i++;
        } 
        result.add(in);
        return result.toArray(new int[result.size()][])   ;
    }*/

}
