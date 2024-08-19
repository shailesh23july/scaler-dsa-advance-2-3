package scaler.dsa.linkedlist.two;

public class AddTwoNumbersAsLists {

	public static void main(String[] args) {
		ListNode l10 = new ListNode(9);
		ListNode l11 = new ListNode(9);
		ListNode l12 = new ListNode(1);
		l10.next = l11;
		l11.next = l12;
		
		ListNode l20 = new ListNode(1);
		addTwoNumbers(l10, l20);

	}

	public static ListNode addTwoNumbers(ListNode A, ListNode B) {
		ListNode temp1 = A;
		ListNode temp2 = B;
		ListNode dummyHead = new ListNode(-1);
		ListNode temp3 = dummyHead;
		int carry = 0;
		while (temp1 != null && temp2 != null) {
			int sum = temp1.val + temp2.val + carry;
			carry = sum / 10;
			ListNode nn = new ListNode(sum % 10);
			temp3.next = nn;
			temp3 = nn;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		while (temp1 != null) {
			int sum = temp1.val + carry;
			carry = sum / 10;
			ListNode nn = new ListNode(sum % 10);
			temp3.next = nn;
			temp3 = nn;
			temp1 = temp1.next;
		} 
		while(temp2 != null) {
			int sum = temp2.val + carry;
			carry = sum / 10;
			ListNode nn = new ListNode(sum % 10);
			temp3.next = nn;
			temp3 = nn;
			temp2 = temp2.next;
		}
		if (carry > 0) {
			ListNode nn = new ListNode(carry);
			temp3.next = nn;
		}
		return dummyHead.next;
	}

}
