package scaler.dsa.linkedList.three;
/*
Q3. Intersection of Linked Lists
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description
Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
NOTE:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
The custom input to be given is different than the one explained in the examples. Please be careful.


Problem Constraints
0 <= |A|, |B| <= 106



Input Format
The first argument of input contains a pointer to the head of the linked list A.

The second argument of input contains a pointer to the head of the linked list B.



Output Format
Return a pointer to the node after which the linked list is intersecting.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = [6, 3, 4, 5]
Input 2:

 A = [1, 2, 3]
 B = [4, 5]


Example Output
Output 1:

 [3, 4, 5]
Output 2:

 []


Example Explanation
Explanation 1:

 In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point. 
Explanation 2:

 In the second example, the nodes don't have the same values, thus we can return None/Null. 

*/


public class IntersectionOfLinkedLists {
	/*
	 Idea:
	 1. Find the length of both intersecting LL individually.
	 2. Find difference 
	  
	 
	 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode getIntersectionNode(ListNode A, ListNode B) {
		int length_A = findLength(A);
		int lenght_B = findLength(B);
		ListNode ans = null;
		int diff = length_A > lenght_B ? length_A - lenght_B : lenght_B - length_A;
		if (length_A > lenght_B) {
			ListNode temp = extraNode(A, diff);
			ans = findIntersectingNode(temp, B);
			 
		} else {
			ListNode temp = extraNode(B, diff);
			ans = findIntersectingNode(temp, A);
		}
		return ans;
	}
	
	
	public static int findLength(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}
	
	public static ListNode extraNode(ListNode temp, int diff) {
		for (int i = 0; i < diff; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public static ListNode findIntersectingNode(ListNode A1, ListNode B1) {
		if (A1 == B1) {
			return A1;
		}
		while (A1 != null && B1 != null) {
			A1 = A1.next;
			B1 = B1.next;
			if (A1 == B1) {
				return A1;
			}
		}
		return null;
	}

}
