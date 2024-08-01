package scaler.dsa.linked.list.part.one;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		ListNode deleteDuplicates = deleteDuplicates(l1);
		System.out.println(deleteDuplicates);
	}
	
	public static ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        ListNode val = A;
        while (temp != null) {
        	if (null == temp.next || val.val != temp.next.val) {
        		 val.next = temp.next; 
        		 val = val.next;
        	}
            temp = temp.next;
        }
        return A;
    }

}
