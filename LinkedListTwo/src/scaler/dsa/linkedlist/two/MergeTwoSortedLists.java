package scaler.dsa.linkedlist.two;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
