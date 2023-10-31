package study.linkedlist;

public class DuplicateLinkedList {
	
	void duplicate(LNode head) {
		LNode cur = head;
		while(cur!=null) {
			LNode temp = cur.next;
			cur.next=new LNode(cur.data);
			cur.next.next=temp;
			cur = temp;
		}
		cur=head;

		while(cur!=null) {
			if(cur.next!=null) {
				cur.next.random=(cur.random!=null) ? cur.random.next : null;
			}
			cur=cur.next.next;

			LNode org = head,copy=head.next;
			LNode temp = copy;

			while(org!=null) {
				org.next=org.next.next;
				copy.next=copy.next.next;
				org= org.next;
				copy=copy.next;
			}
			//return temp;
		}
		//return cur;
	}
}
