package study.stack;

public class TestStack {
	int[] stack;
	int capacity;
	int top;
	int size;

	public TestStack(int capacity)
	{	
		this.capacity=capacity;
		top=-1;
		stack = new int[capacity];
		size=0;
	}

	void push(int data) throws Exception {
		if(top==capacity-1) {
			throw new Exception();
		}
		top++;
		stack[top]=data;
		size++;
	}

	public int pop() throws Exception {
		if(top==-1) {
			throw new Exception();
		}
		int res=stack[top];
		top--;
		size--;
		return res;
	}

	int peek() throws Exception {
		if(top==-1) {
			throw new Exception();
		}

		return stack[top];
	}

	boolean isEmpty() {
		return top==-1;
	}
	
}
