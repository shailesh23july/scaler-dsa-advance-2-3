package scaler.dsa.linkedlist.two;

public class MiddleElementOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static int solve(ListNode A) {
		 ListNode temp = A;
		 int size = 0;
		 while (temp != null) {
			 size++;
			 temp = temp.next;
		 }
		 return (size +1)/2;
	 }
	 
	 public static ListNode solve2(ListNode A) {
		 ListNode fast = A;
		 ListNode slow = A;
		 while (fast.next != null && fast.next.next != null) {
			 fast = fast.next.next;
			 slow = slow.next;
		 }
		 return slow;
	 }


}
