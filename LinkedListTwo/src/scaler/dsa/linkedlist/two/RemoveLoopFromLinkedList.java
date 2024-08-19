package scaler.dsa.linkedlist.two;

public class RemoveLoopFromLinkedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(6);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(8);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode solve = solve(n1);
		System.out.println();
	}
	
	public static ListNode solve(ListNode A) {
		ListNode fastPointer = A;
		ListNode slowPointer = A;
		boolean isCycleExist = false;
		while(fastPointer.next != null && fastPointer.next.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next; 
			if (slowPointer == fastPointer) {
				isCycleExist = true;
				break;
			}
		}
		if (isCycleExist == false) {
			return null;
		}
		ListNode i = A;
		ListNode j = slowPointer;
		while (i.next != j.next) {
			i = i.next;
			j = j.next;
		}
		j.next = null;
		return A;
    }
}

