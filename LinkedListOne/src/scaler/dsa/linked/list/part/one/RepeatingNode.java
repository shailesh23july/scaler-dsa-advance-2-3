package scaler.dsa.linked.list.part.one;

import java.util.HashSet;

public class RepeatingNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode repeatingNode(ListNode A) {
		ListNode temp = A;
		HashSet<ListNode> hs = new HashSet<ListNode>();
		while (null !=temp && !hs.contains(temp)) {
			hs.add(temp);
			temp = temp.next;
		}
		return temp;
	}

}
