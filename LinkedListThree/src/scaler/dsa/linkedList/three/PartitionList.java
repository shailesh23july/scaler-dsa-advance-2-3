package scaler.dsa.linkedList.three;

public class PartitionList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		partition(l1, 3);
	}
	
	public static ListNode partition(ListNode A, int B) {
		ListNode smallerPartitionHead = null;
		ListNode biggerPartitionHead = null;
		ListNode smallTempHead = null;
		ListNode bigTempHead = null;
		ListNode temp = A;
		while (temp != null) {
			ListNode nn = temp;
			temp = temp.next;
			nn.next = null;
			if (nn.val < B) {
				if (smallerPartitionHead == null) {
					smallerPartitionHead = CreatePartition(nn, smallerPartitionHead);
					smallTempHead = smallerPartitionHead;
				} else {
					smallTempHead = CreatePartition(nn, smallTempHead);
				}
				
			} else {
				if (biggerPartitionHead == null) {
					biggerPartitionHead = CreatePartition(nn, biggerPartitionHead);
					bigTempHead = biggerPartitionHead;
				} else {
					bigTempHead = CreatePartition(nn, bigTempHead);
				}
			}
			
		}
		if (smallerPartitionHead == null) {
			return biggerPartitionHead;
		}
		temp = smallerPartitionHead;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = biggerPartitionHead;
		return smallerPartitionHead;
    }

	private static ListNode CreatePartition(ListNode node, ListNode head) {
		ListNode temp = head;
		if (null == temp) {
			return node;
		}
		temp.next = node;
		node.next = null;
		return node;
	}

}
