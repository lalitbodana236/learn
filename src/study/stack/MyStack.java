package study.stack;

public class MyStack {
	public static void main(String[] args) throws Exception {
		TestStack stack = new TestStack(4);
		//System.out.println(stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		//System.out.println(stack.isEmpty());
		//System.out.println(stack.peek());
		//System.out.println(stack.size);
		//System.out.println(stack.pop());
		//System.out.println(stack.size);
		
		StackUsingLinkedList sl = new StackUsingLinkedList();
		sl.push(1);
		sl.push(2);
		sl.push(3);
		System.out.println("size : "+sl.size);
		System.out.println("pop : "+sl.pop());
		System.out.println("size : "+sl.size);
		sl.push(4);
		System.out.println("peak : "+sl.peak());
		System.out.println("size : "+sl.size);
		
	}
}
