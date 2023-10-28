package study.stack;

import java.util.Stack;

public class TraverseTheInfix {
	public static void main(String[] args) {
		String str = "a+b*(d+e)";
		System.out.println(str);
		infix(str);
	}
	
	static void infix(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()) {
			if(c=='(' || c=='*' || c=='/' || c=='+' || c=='-') {
				stack.push(c);
			}else if(c==')') {
				System.out.print(c);
				while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
				}
			}else {
				System.out.print(c+" ");
			}
		}
	}
}
