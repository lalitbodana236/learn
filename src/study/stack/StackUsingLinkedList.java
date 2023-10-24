package study.stack;

import study.linkedlist.LNode;

public class StackUsingLinkedList {
	LNode head;
	int size;

	public StackUsingLinkedList() {
		this.head = null;
		this.size = 0;
	}

	void push(int data) {
		LNode temp = new LNode(data);
		temp.next=head;
		size++;
		head=temp;
	}

	int peak() {
		if(head==null) {
			System.out.println("stack is empty ");
		}
		return head.data;
	}

	int pop(){

		if(head==null) {
			System.out.println("stack is overflow ");
		}

		int res = head.data;
		head =head.next;
		size--;
		return res;
	}

	boolean isEmpty() {
		return head==null;
	}

	int size() {
		return size;
	}

}
