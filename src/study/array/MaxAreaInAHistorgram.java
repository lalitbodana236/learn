package study.array;

import java.util.Stack;

public class MaxAreaInAHistorgram {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
		

	}
	
	public static int maxArea(int[] height) {
	    int left = 0;         // Left pointer starting from the beginning of the array
	    int right = height.length - 1;  // Right pointer starting from the end of the array
	    int maxArea = 0;

	    while (left < right) {
	        int h1 = height[left];
	        int h2 = height[right];
	        int h = Math.min(h1, h2);  // Determine the minimum height

	        int width = right - left;  // Calculate the width between the pointers
	        int area = h * width;     // Calculate the area
	        System.out.println(h+" "+ width+" ");
	        maxArea = Math.max(maxArea, area);  // Update max area if the current area is greater

	        // Move the pointer pointing to the shorter line towards the other pointer
	        if (h1 < h2) {
	            left++;
	        } else {
	            right--;
	        }
	    }

	    return maxArea;
	}
	
	
	static  int[] prevSmaller(int a[]) {
		int[] ps = new int[a.length];
		for (int i = 0; i < a.length; i++) {
	        boolean found = false;
	        for (int j = i - 1; j >= 0; j--) {
	            if (a[i] >= a[j]) {
	              //  System.out.print(a[j] + " ");
	                ps[i]=a[j];
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	           // System.out.print(-1 + " "); // No previous smaller element found.
	            ps[i]=-1;
	        }
	    }
		return ps;
	}
	
	static  int[] nextSmaller(int a[]) {
		int[]  ns = new int[a.length];
	    for (int i = 0; i<a.length; i++) {
	        boolean found = false;
	        for (int j = i + 1; j < a.length; j++) {
	            if (a[i] >= a[j]) {
	               // System.out.print(a[j] + " ");
	                found = true;
	                ns[i]=a[j];
	                break;
	            }
	        }
	        if (!found) {
	           // System.out.print(-1 + " "); // No next smaller element found.
	            ns[i]=-1;
	        }
	    }
	    return ns;
	}
	
	public static void area(int[] arr) {
		int[] ps = prevSmaller(arr);
		int[] ns = nextSmaller(arr);
		int maxAns=0;
		for(int i=0;i<arr.length;i++) {
			int cur = (ns[i]-ps[i]-1)*arr[i];
			maxAns = Math.max(maxAns, cur);
			System.out.println(maxAns);
		}
	}

	


}
