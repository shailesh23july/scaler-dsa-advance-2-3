package scaler.dsa.linked.list.part.one;

public class ReverseLinkListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode reverseBetween(ListNode A, int B, int C) {
		ListNode b_prev = findKthNode(A, B-1);
		ListNode b_node = b_prev.next;
		ListNode c_node = findKthNode(A, C);
		ListNode c_next = c_node.next;
		b_prev.next = c_node;
		b_node.next = c_next;
		return A;
    }
	
	public static ListNode findKthNode(ListNode A, int B) {
		if (B <= 1) {
			return A;
		}
		ListNode temp = A;
		for (int i = 1; i < B; i++) {
			temp = temp.next;
			
		}
		return temp;
	}

}
