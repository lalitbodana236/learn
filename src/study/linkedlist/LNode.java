package study.linkedlist;

public class LNode {
	
	public int data;
	
	public LNode next;
	
	public LNode random;
	
	public LNode(int data) {
		this.data = data;
		 next = null;
	}

	@Override
	public String toString() {
		return "LNode [data=" + data + "]";
	}
	
	
}
