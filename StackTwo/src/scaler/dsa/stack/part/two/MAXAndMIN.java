package scaler.dsa.stack.part.two;

import java.util.ArrayList;

/*
Problem Description
Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format
The first and only argument given is the integer array A.



Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
*/

public class MAXAndMIN {

	public static void main(String[] args) {
		int[] A = {4, 7, 3, 8};
		//int[] A = {2, 5, 3, 4};
		int ans = 0;
		int[] leftSmallerElementIndex =  getLeftSmallerElementIndex(A);
		int[] rightSmallerElementIndex = getRightSmallerElementIndex(A);
		int[] leftBiggerElementIndex = getLeftBiggerElementIndex(A);
		int[] rightBiggerElementIndex = getRightBiggerElementIndex(A);
		for (int i = 0; i < A.length; i++) {
			int contri_as_max = (rightBiggerElementIndex[i] - i) * (i - leftBiggerElementIndex[i]);
			int contri_as_min = (rightSmallerElementIndex[i] - i) * (i - leftSmallerElementIndex[i]);
			ans += (contri_as_max - contri_as_min) * A[i];
		}
		System.out.println(ans);
	}
	
	public static int[] getRightBiggerElementIndex(int[] A) {
		  int[] ans = new int[A.length];
		  ArrayList<Integer> stack = new ArrayList<>();
		  int top = -1;
		  ans[A.length-1] = A.length;
		  top = push(stack, top, A.length -1);
		  for (int i = A.length -2; i >= 0; i--) {
			  while (stack.size() > 0 && A[i] >= A[peek(stack, top)]) {
				top = pop(stack, top);
			  }
			  if (stack.size() == 0) {
				  ans[i] = A.length;
				  top =push(stack, top, i);
			  } else {
				  ans[i] = peek(stack, top);
				  top =push(stack, top, i);
			  }
		  }
		  return ans;
		}
	
	public static int[] getLeftBiggerElementIndex(int[] A) {
		  int[] ans = new int[A.length];
		  ArrayList<Integer> stack = new ArrayList<>();
		  int top = -1;
		  ans[0] = -1;
		  top = push(stack, top, 0);
		  for (int i = 1; i < A.length; i++) {
			  while (stack.size() > 0 && A[i] >= A[peek(stack, top)]) {
				top = pop(stack, top);
			  }
			  if (stack.size() == 0) {
				  ans[i] = -1;
				  top =push(stack, top, i);
			  } else {
				  ans[i] = peek(stack, top);
				  top =push(stack, top, i);
			  }
		  }
		  return ans;
		}
	
	public static int[] getLeftSmallerElementIndex(int[] A) {
	  int[] ans = new int[A.length];
	  ArrayList<Integer> stack = new ArrayList<>();
	  int top = -1;
	  ans[0] = -1;
	  top = push(stack, top, 0);
	  for (int i = 1; i < A.length; i++) {
		  while (stack.size() > 0 && A[i] <= A[peek(stack, top)]) {
			top = pop(stack, top);
		  }
		  if (stack.size() == 0) {
			  ans[i] = -1;
			  top =push(stack, top, i);
		  } else {
			  ans[i] = peek(stack, top);
			  top =push(stack, top, i);
		  }
	  }
	  return ans;
	}

	public static int[] getRightSmallerElementIndex(int[] A) {
		  int[] ans = new int[A.length];
		  ArrayList<Integer> stack = new ArrayList<>();
		  int top = -1;
		  ans[A.length-1] = A.length;
		  top = push(stack, top, A.length -1);
		  for (int i = A.length -2; i >= 0; i--) {
			  while (stack.size() > 0 && A[i] <= A[peek(stack, top)]) {
				top = pop(stack, top);
			  }
			  if (stack.size() == 0) {
				  ans[i] = A.length;
				  top =push(stack, top, i);
			  } else {
				  ans[i] = peek(stack, top);
				  top =push(stack, top, i);
			  }
		  }
		  return ans;
		}
	
	private static int pop(ArrayList<Integer> stack, int top) {
		 stack.remove(top);
		 top--;
		 return top;
	}

	private static int peek(ArrayList<Integer> stack, int top) {
		return stack.get(top);
	}
	
	private static int push(ArrayList<Integer> stack, int top, int num) {
		 stack.add(num);
		 top++;
		 return top;
	}

}
