package scaler.dsa.linkedlist.two;

public class ReverseLinkListIII {

	public static void main(String[] args) {
		ListNode l10 = new ListNode(1);
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(3);
		l10.next = l11;
		l11.next = l12;
        ListNode head = reverseBetween(l10, 2, 3);
        System.out.println();

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
