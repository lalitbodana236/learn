package study.collection150.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> summary = summaryRanges(nums);

        System.out.println("Summary Ranges:");
        for (String range : summary) {
            System.out.println(range);
        }

	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> result =new ArrayList<>();
		if (nums == null || nums.length == 0) {
            return result;
        }
		
		int start = nums[0];
		int end = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i] == end+1) {
				end = nums[i];
			}else {
				result.add(getRange(start,end));
				start=nums[i];
				end=nums[i];
			}
		}
		
		result.add(getRange(start,end));
		return result;
	}
	
	private static String getRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }

}
