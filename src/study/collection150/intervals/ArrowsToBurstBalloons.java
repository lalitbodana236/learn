package study.collection150.intervals;

import java.util.Arrays;

public class ArrowsToBurstBalloons {

	public static void main(String[] args) {
		int[][] points = {{10,16},{2,8},{1,6},{7,12}};
		System.out.println(findMinArrowShots(points));
		
		//int[][] points1 = {{1,2},{3,4},{5,6},{7,8}};
		//System.out.println(findMinArrowShots(points1));
	}

	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points,(a,b)->Integer.compare(a[1], b[1]));
		
		for(int[] j : points) {
			System.out.println(j[0]+" "+j[1]);
		}
		
		int ans=1;
		int[] in = points[0];
		for(int i=1;i<points.length;i++) {
			if(in[1]<points[i][0]) {
				ans++;
				in = points[i];
			}
		}
		
		return ans;
	}

}
