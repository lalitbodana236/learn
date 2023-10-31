package study.stack;

import java.util.Stack;

public class PreviousSmallerElment {
		public static void main(String[] args) {
			StackUsingLinkedList sl = new StackUsingLinkedList();
			
			int[] arr = {4,10,5,18,3,12,7};
			int[] arr1 = {3,10,5,1,15,10,7,6};
			
			nextSmaller(arr1);
		}
		
		static void previousSmallerElement(int a[]) {
			Stack<Integer> s = new Stack<>();
			
			for(int i=0;i<a.length;i++) {
				while(!s.isEmpty() && s.peek()>=a[i]) {
					s.pop();
				}
				
				if(s.isEmpty()) {
					System.out.println(-1);
				}else
					System.out.println(s.peek());
				
				s.push(a[i]);
			}
		}
		
		static void prevSmaller(int a[]) {
			for (int i = 0; i < a.length; i++) {
		        boolean found = false;
		        for (int j = i - 1; j >= 0; j--) {
		            if (a[i] >= a[j]) {
		                System.out.print(a[j] + " ");
		                found = true;
		                break;
		            }
		        }
		        if (!found) {
		            System.out.print(-1 + " "); // No previous smaller element found.
		        }
		    }
		}
		
		static void nextSmaller(int a[]) {
		    for (int i = 0; i<a.length; i++) {
		        boolean found = false;
		        for (int j = i + 1; j < a.length; j++) {
		            if (a[i] >= a[j]) {
		                System.out.print(a[j] + " ");
		                found = true;
		                break;
		            }
		        }
		        if (!found) {
		            System.out.print(-1 + " "); // No next smaller element found.
		        }
		    }
		}
		
		
}
