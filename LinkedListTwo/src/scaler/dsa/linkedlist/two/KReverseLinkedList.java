package scaler.dsa.linkedlist.two;

public class KReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode reverseList(ListNode A, int B) {
		ListNode temp = A;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		temp = A;
		for (int i = 1; i <= size-B + 1; i+=B) {
			temp = reverseBetween(temp, i, i + B - 1);
		}
		return temp;
	}
    
	
	 public static ListNode reverseBetween(ListNode A, int B, int C) {
		 ListNode head = A;
		 ListNode current = A;
		 ListNode first = null;
		 ListNode from = null;
		 ListNode to = null;
		 ListNode next = null;
		 int count = 0;
		 while (current != null) {
			 count += 1;
			 if (count < B) {
				 first = current;
			 }
			 if (count == B) {
				 from = current;
			 }
			 if (count == C) {
				 to = current;
				 next = to.next;
				 break;
			 }
			 current = current.next;
		 }
		 to.next = null;
		 reverse(from);
		 if (null != first) {
			 first.next = to;
		 } else {
			head = to; 
		 }
		 from.next = next;
		 return head;
	 }

	private static void reverse(ListNode from) {
		ListNode prev = from;
		ListNode curr = from.next;
		prev.next = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
	}
}
