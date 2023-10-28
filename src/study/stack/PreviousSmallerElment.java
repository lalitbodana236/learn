package study.stack;

import java.util.Stack;

public class PreviousSmallerElment {
		public static void main(String[] args) {
			StackUsingLinkedList sl = new StackUsingLinkedList();
			
			int[] arr = {4,10,5,18,3,12,7};
			
			previousSmallerElement(arr);
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
		
		
}
