package scaler.dsa.stack.part.two;

import java.util.ArrayList;

/*
Problem Description
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.



Problem Constraints
1 <= |A| <= 100000

-109 <= A[i] <= 109



Input Format
The only argument given is integer array A.



Output Format
Return the integar array G such that G[i] contains the nearest smaller number than A[i]. If no such element occurs G[i] should be -1.



Example Input
Input 1:

 A = [4, 5, 2, 10, 8]
Input 2:

 A = [3, 2, 1]


Example Output
Output 1:

 [-1, 4, -1, 2, 2]
Output 2:

 [-1, -1, -1]


Example Explanation
Explanation 1:

index 1: No element less than 4 in left of 4, G[1] = -1
index 2: A[1] is only element less than A[2], G[2] = A[1]
index 3: No element less than 2 in left of 2, G[3] = -1
index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
Explanation 2:

index 1: No element less than 3 in left of 3, G[1] = -1
index 2: No element less than 2 in left of 2, G[2] = -1
index 3: No element less than 1 in left of 1, G[3] = -1
*/

public class NearestSmallerElement {

	public static void main(String[] args) {
		//int[] A = {4, 5, 2, 10, 8};
		//int[] A = {3, 2, 1};
		//int[] prevSmaller = prevSmaller(A);
		int[] A = {4, 5, 2, 10} ;
		int[] nextGreater = nextGreater(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(nextGreater[i] + " ");
		}

	}
	
	public static int[] nextGreater(int[] A) {
		int[] ans = new int[A.length];
		int top = -1;
		ArrayList<Integer> stack = new ArrayList<>();
		ans[A.length-1] = -1;
		top = push(stack, top, A[A.length-1]);
		for (int i = A.length-2; i >= 0; i--) {
			while(stack.size() > 0 && A[i] >= peek(stack, top)) {
				top = pop(stack, top);
			}
			if (stack.size() == 0) {
				ans[i] = -1;
				//top = push(stack, top, A[i]);
			} else {
				ans[i] = peek(stack, top);
				//top = push(stack, top, A[i]);
			}
			top = push(stack, top, A[i]);
		}
		return ans;
    }
	
	public static int[] prevSmaller(int[] A) {
		int[] ans = new int[A.length];
		int top = -1;
		ArrayList<Integer> stack = new ArrayList<>();
		ans[0] = -1;
		top = push(stack, top, A[0]);
		for (int i = 1; i < A.length; i++) {
			while(stack.size() > 0 && A[i] <= peek(stack, top)) {
				top = pop(stack, top);
			}
			if (stack.size() == 0) {
				ans[i] = -1;
				top = push(stack, top, A[i]);
			} else {
				ans[i] = peek(stack, top);
				top = push(stack, top, A[i]);
			}
		}
		return ans;
    }
	
	public static int[] nextSmaller(int[] A) {
		int[] ans = new int[A.length];
		int top = -1;
		ArrayList<Integer> stack = new ArrayList<>();
		ans[0] = A.length;
		top = push(stack, top, A[A.length-1]);
		for (int i = A.length-2; i >= 0; i--) {
			while(stack.size() > 0 && A[i] <= peek(stack, top)) {
				top = pop(stack, top);
			}
			if (stack.size() == 0) {
				ans[i] = A.length;
				top = push(stack, top, A[i]);
			} else {
				ans[i] = peek(stack, top);
				top = push(stack, top, A[i]);
			}
		}
		return ans;
    }
	 
	public static int push(ArrayList<Integer> stack, int top, Integer num) {
		stack.add(num);
		top++;
		return top;
	}
	
	public static int pop(ArrayList<Integer> stack, int top) {
		stack.remove(top);
		top--;
		return top; 
	}
	
	public static Integer peek(ArrayList<Integer> stack, int top) {
		return stack.get(top); 
	}

}
