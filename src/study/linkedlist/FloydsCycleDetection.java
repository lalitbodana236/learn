package study.linkedlist;

public class FloydsCycleDetection {
	LNode detectCycle(LNode head) {
		LNode slow = head;
		LNode fast = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast=fast.next.next;
			if(slow==fast) {
				return slow;
			}
		}
		return null;
	}
	
	LNode detectFirstNode(LNode head) {
		LNode meet = detectCycle(head);
		LNode start = head;
		while(start!=meet) {
			start = start.next;
			meet= meet.next;
		}
		return start;
	}
}
