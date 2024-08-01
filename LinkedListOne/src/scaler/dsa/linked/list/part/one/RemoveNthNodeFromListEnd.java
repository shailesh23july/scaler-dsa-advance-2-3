package scaler.dsa.linked.list.part.one;

public class RemoveNthNodeFromListEnd {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		int B = 1;
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		//ListNode l4 = new ListNode(8);
		//ListNode l5 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		//l3.next = l4;
		//l4.next = l5;
		ListNode node = removeNthFromEnd(l1, B);
        System.out.println(node);

	}
	
	public static ListNode removeNthFromEnd(ListNode A, int B) {
		int l = findLength(A);
		if (l <= B) {
			return A.next;
		}
        int indexFromStart = l - B;
        ListNode prev = findPreviousNode(A, indexFromStart-1);
        ListNode curr = prev.next;
        if (null != curr) {
        	prev.next = curr.next;
        } else {
        	prev = null;
        }
        return A;
    }

    public static int findLength(ListNode A) {
        ListNode temp = A;
        int length = 0;
        while(null != temp) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static ListNode findPreviousNode(ListNode A, int indexFromStart) {
        ListNode temp = A;
        if (indexFromStart <= 0) {
            return A;
        }
        for (int i = 0; i < indexFromStart; i++) {
            temp = temp.next;
        }
        return temp;
    }

}
