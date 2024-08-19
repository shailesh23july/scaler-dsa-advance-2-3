package scaler.dsa.linkedlist.two;

public class ReverseLinkListII {

	public static void main(String[] args) {
		ListNode l10 = new ListNode(1);
		ListNode l11 = new ListNode(2);
		ListNode l12 = new ListNode(3);
		l10.next = l11;
		l11.next = l12;
        reverseBetween(l10, 2, 3);
	}
	
	 public static ListNode reverseBetween(ListNode A, int B, int C) {
		 ListNode prevB = null;
		 ListNode nextC = null;
		 ListNode temp = A;
		 int count = 1;
		 ListNode[] arr = new ListNode[C-B+1];
		 while (temp != null) {
			 if (count > 0 && count == B-1) {
				 prevB = temp;
			 }
			 if (count == C+1) {
				 nextC = temp;
			 }
			 count++;
			 temp = temp.next;
		 }
		 count = 1;
		 int k = 0;
		 temp = A;
		 while (temp != null) {
			 if (count >= B && count <= C) {
				 arr[k++] = temp;
			 }
			 temp = temp.next;
			 count++;
		 }
		 temp = A;
		 for (int i = arr.length-1; i > 0; i--) {
			 arr[i].next = arr[i-1];
		 }
		 if (null != prevB) {
			 prevB.next = arr[arr.length-1];
		 } else {
			 temp = arr[arr.length-1];
		 }
		 if (null != arr[0]) {
			 arr[0].next = nextC;
		 }
		 return temp;
	 }
	 
	 public static void findNodes(ListNode A, int B, int C) {
		 
	 }

}
