package study.linkedlist;

import study.tree.Node;

public class TestLinkedList {
    static LNode root;

    // Insert method returns the new head
    static LNode insert(int data, LNode head, int pos) {
        LNode toAdd = new LNode(data);
        if (pos == 0) {
            toAdd.next = head;
            return toAdd; // Update the head to the new node
        } else {
            LNode prev = head;
            for (int i = 0; i < pos - 1 && prev != null; i++) {
                prev = prev.next;
            }
            if (prev == null) {
                System.out.println("Position is out of bounds.");
                return head; // Head remains the same
            }
            toAdd.next = prev.next;
            prev.next = toAdd;
            return head; // Head remains the same
        }
    }

    public static void main(String[] args) {
        LNode n1 = new LNode(10);
        LNode n2 = new LNode(20);
        LNode n3 = new LNode(30);

        LNode head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = null;

       // LNode temp = head;
        //while (temp != null) {
          //  System.out.print(temp.data + " ");
            //temp = temp.next;
        //}
       
      
       
     LNode reverseRecHead =    reverseRec(head);
        System.out.println();
        while (reverseRecHead != null) {
            System.out.print(reverseRecHead.data + " ");
            reverseRecHead = reverseRecHead.next;
        }

       /* for (int i = 0; i < 5; i++) {
            head = addElement(i, head); // Update the head
        }
        System.out.println();
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        // Delete the node at position 2
        head = delete(head, 2);
        System.out.println();
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }*/
    }

    // Updated addElement method to return the new head
    static LNode addElement(int data, LNode head) {
        LNode toAdd = new LNode(data);
        if (head == null) {
            return toAdd; // Return the new node as the head
        } else {
            LNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = toAdd;
            return head; // Head remains the same
        }
    }

    // Updated delete method to return the new head
    public static LNode delete(LNode head, int pos) {
        if (pos == 0) {
            return head.next; // Update the head
        }
        LNode prev = head;
        for (int i = 0; i < pos - 1; i++) {
            if (prev == null) {
                System.out.println("Position is out of bounds.");
                return head; // Head remains the same
            }
            prev = prev.next;
        }
        if (prev == null || prev.next == null) {
            System.out.println("Position is out of bounds.");
            return head; // Head remains the same
        }
        prev.next = prev.next.next;
        return head; // Head remains the same
    }
    
    public static LNode reverse(LNode head) {
    	LNode cur = head;
    	LNode prev = null;
    	while(cur!=null) {
    		LNode temp = cur.next;
    		cur.next = prev;
    		prev= cur;
    		cur=temp;
    	}
    
    	return prev;
    }
    
    public static LNode reverseRec(LNode head) {
    	if(head==null || head.next==null) {
    		return head;
    	}
    	LNode newHead = reverseRec(head.next);
    	LNode headNext = head.next;
    	headNext.next = head;
    	head.next = null;
    	return newHead;
    }
}
