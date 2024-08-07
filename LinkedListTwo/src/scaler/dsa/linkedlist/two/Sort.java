package scaler.dsa.linkedlist.two;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static ListNode sortList(ListNode A) {
		 if (A == null || A.next == null) {
			 return A;
		 }
		 ListNode middle = middleNode(A);
		 ListNode head2 = middle.next;
		 middle.next = null;
		 
		 ListNode left = sortList(A);
		 ListNode right = sortList(head2);
		 ListNode ans = mergeTwoLists(left, right);
		 return ans;
	 }
	 
	 public static ListNode middleNode(ListNode A) {
		 ListNode fast = A;
		 ListNode slow = A;
		 while (fast.next != null && fast.next.next != null) {
			 fast = fast.next.next;
			 slow = slow.next;
		 }
		 return slow;
	 }
	 
	 public static ListNode mergeTwoLists(ListNode A, ListNode B) {
		 ListNode dummyHead = new ListNode(-1);
		 ListNode temp = dummyHead;
		 ListNode i = A;
		 ListNode j = B;
		 while (i != null && j != null) {
			 if (i.val <= j.val) {
				 temp.next = i;
				 i = i.next;
			 } else {
				 temp.next = j;
				 j = j.next;
			 }
			 temp = temp.next;
		 }
		 if (i != null) {
			 temp.next = i;
		 }
		 if (j != null) {
			 temp.next = j;
		 }
	     return dummyHead.next;
	 }

}
