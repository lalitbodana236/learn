package study.collection150.intervals;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {
		int[] rating = {1,0,2};
		System.out.println(candy(rating));
		
		
		int[] r1 = {1,2,87,87,87,2,1};
		System.out.println(candy(r1));


	}

	public static int candy(int[] ratings) {
		int n = ratings.length;
        if (n <= 1) return n;
		int[] candies = new int[n];
		Arrays.fill(candies, 1);
		int ans=0;
		
		for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
		
		for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
		
		for(int i : candies) {
			ans+=i;
		}
		return ans;
	}

}
