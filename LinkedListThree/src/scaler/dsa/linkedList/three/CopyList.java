package scaler.dsa.linkedList.three;

import java.util.HashMap;

/*
Problem Description
You are given a linked list A
Each node in the linked list contains two pointers: a next pointer and a random pointer
The next pointer points to the next node in the list
The random pointer can point to any node in the list, or it can be NULL
Your task is to create a deep copy of the linked list A
The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
You should create a new linked list B, where each node in B has the same value as the corresponding node in A
The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)


Problem Constraints
0 <= |A| <= 106



Input Format
The first argument of input contains a pointer to the head of linked list A.



Output Format
Return a pointer to the head of the required linked list.



Example Input
Given list
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1
  


Example Output
   1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1 
*/

public class CopyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dummyHead = new RandomListNode(-1);
		HashMap<RandomListNode, RandomListNode> hm = new HashMap<>();
		RandomListNode temp = head;
		RandomListNode temp2 = dummyHead;
		while (temp != null) {
			RandomListNode nn = new RandomListNode(temp.label);
			hm.put(temp, nn);
			temp2.next= nn;
			temp = temp.next;
			temp2 = nn;
		}
		temp = head;
		while (temp!= null) {
			hm.get(temp).random = hm.get(temp.random);
			temp = temp.next;
		}
		dummyHead = dummyHead.next;
        return dummyHead;
	}

}
