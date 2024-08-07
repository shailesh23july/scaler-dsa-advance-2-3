package scaler.dsa.linkedList.three;

public class FlattenALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode  flatten(ListNode root) {
		ListNode l1 = root.down;
		root = root.next;
		while (root != null) {
			ListNode l2 = root.down;
			merge(l1, l2);
		}
		return null;
	}

	private static void merge(ListNode l1, ListNode l2) {
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode head = null;
		while(temp1 != null && temp2 != null) {
			if (temp1.val < temp2.val) {
				ListNode nn = new ListNode(temp1.val);
			}
		}
		
	}

}
