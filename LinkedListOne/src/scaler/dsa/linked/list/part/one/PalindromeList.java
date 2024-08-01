package scaler.dsa.linked.list.part.one;

import java.util.LinkedList;

public class PalindromeList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		//ListNode l4 = new ListNode(8);
		//ListNode l5 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		//l3.next = l4;
		//l4.next = l5;
        int lPalin = lPalin(l1);
        System.out.println(lPalin);
		

	}
	
	public static int lPalin(ListNode A) {
        int midIndex = findMidIndex(A);
        ListNode midNode = findpreviousNode(A, midIndex);
        ListNode p2Head = midNode.next;
        midNode.next = null;
        p2Head = reverseList(p2Head);
        ListNode p1Head = A;
        while (p2Head != null && p1Head != null) {
          if (p2Head.val != p1Head.val) {
              return 0;
          }
          p1Head = p1Head.next;
          p2Head = p2Head.next;
        }
        return 1;

    }

    public static int findMidIndex(ListNode A) {
    ListNode temp = A;
    int length = 0;
        while (temp != null) {
           length++;
           temp = temp.next;
        }
        if (length % 2 == 0) {
            return length/2 -1;
        }
        return length/2;
    }

     public static ListNode findpreviousNode(ListNode A, int C) {
    	 if (C < 0) {
    		 return A;
    	 }
        ListNode temp = A;
        for (int i = 0; i < C; i++) {
            if (null != temp.next) {
              temp = temp.next;
            } else {
                break;
            }  
        }
        return temp;
    }

    public static ListNode reverseList(ListNode A) {
       ListNode prev = null;
       ListNode curr = A;
       while (curr != null) {
         ListNode temp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = temp;  
       }
     return prev;
    }

}
