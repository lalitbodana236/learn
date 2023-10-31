package study.recursion;

import java.util.ArrayList;

import study.linkedlist.LNode;

public class AddTwoNumber {

	public static void main(String[] args) {
		int[] l1 = {2,4}, l2 = {5,6,4,9};

		ArrayList<Integer> list = addTwoNumber(l1,l2);
		for(Integer i : list)
			System.out.println(i);

	}

	private static ArrayList<Integer> addTwoNumber(int[] l1, int[] l2) {
		int carry=0;
		ArrayList<Integer> list = new ArrayList<>();
		int i=0;
		int j=0;
		while(i<l1.length && j<l2.length) {
			int sum = l1[i]+l2[i];
			if(sum>9) {
				int rem = sum%10;
				list.add(rem+carry);
				carry=sum/10;
			}else {
				list.add(sum+carry);
				carry=0;
			}
			i++;j++;
		}
		while(i<l1.length) {
			list.add(l1[i]+carry);
			carry=0;
			i++;
		}

		while(j<l2.length) {
			list.add(l2[j]+carry);
			carry=0;
			j++;
		}
		return list;
	}

	public LNode addTwoNumbers(LNode l1, LNode l2) {
		LNode dummyHead = new LNode(0); // Dummy head node to simplify handling the result.
		LNode p = l1, q = l2, current = dummyHead;
	    int carry = 0;

	    while (p != null || q != null) {
	        int x = (p != null) ? p.data : 0;
	        int y = (q != null) ? q.data : 0;
	        int sum = x + y + carry;
	        carry = sum / 10; // Calculate the carry for the next iteration.
	        current.next = new LNode(sum % 10);
	        current = current.next;

	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }

	    if (carry > 0) {
	        current.next = new LNode(carry);
	    }

	    return dummyHead.next; // The actual result starts from the next node of the dummy head.
	}
	
	private LNode addLists(LNode l1, LNode l2, int carry) {
	    if (l1 == null && l2 == null) {
	        if (carry > 0) {
	            return new LNode(carry);
	        } else {
	            return null;
	        }
	    }

	    int x = (l1 != null) ? l1.data : 0;
	    int y = (l2 != null) ? l2.data : 0;
	    int sum = x + y + carry;

	    carry = sum / 10;
	    int digit = sum % 10;

	    LNode result = new LNode(digit);

	    if (l1 != null) l1 = l1.next;
	    if (l2 != null) l2 = l2.next;

	    result.next = addLists(l1, l2, carry);

	    return result;
	}

}
