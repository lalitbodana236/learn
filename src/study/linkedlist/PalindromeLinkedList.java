package study.linkedlist;

public class PalindromeLinkedList {
	boolean palindrome(LNode head) {
		if(head==null) {
			return false;
		}
		
		LNode mid = middle(head);
		LNode last = TestLinkedList.reverseRec(mid.next);
		LNode cur = head;
		
		while(last!=null) {
			if(last.data !=cur.data) {
				return false;
			}
			last=last.next;
			cur=cur.next;
		}
		return true;
		
	}
	LNode middle(LNode head) {
		LNode slow = head;
		LNode fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
