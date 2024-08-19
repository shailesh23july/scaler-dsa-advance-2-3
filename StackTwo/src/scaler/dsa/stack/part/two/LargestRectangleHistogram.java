package scaler.dsa.stack.part.two;

import java.util.ArrayList;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		//int[] A = {2, 1, 5, 6, 2, 3};
		int[] A = {90,58,69,70,82,100,13,57,47,18};
        System.out.println(largestRectangleArea(A));
	}
	
	public static int largestRectangleArea(int[] A) {
		int ans = Integer.MIN_VALUE;
		int[] leftSmallerElement = prevSmaller(A);
		int[] rightSmallerElement = nextSmaller(A);
		for (int i = 0; i < A.length; i++) {
			int width = rightSmallerElement[i] - leftSmallerElement[i] -1;
			int area = width * A[i];
			ans = ans > area ?ans: area; 
		}
		return ans;
    }
	
	public static int[] prevSmaller(int[] A) {
		int[] ans = new int[A.length];
		int top = -1;
		ArrayList<Integer> stack = new ArrayList<>();
		ans[0] = -1;
		top = push(stack, top, 0);
		for (int i = 1; i < A.length; i++) {
			while(stack.size() > 0 && A[i] <= A[peek(stack, top)]) {
				top = pop(stack, top);
			}
			if (stack.size() == 0) {
				ans[i] = -1;
				top = push(stack, top, i);
			} else {
				ans[i] = peek(stack, top);
				top = push(stack, top, i);
			}
		}
		return ans;
    }
	
	public static int[] nextSmaller(int[] A) {
		int[] ans = new int[A.length];
		int top = -1;
		ArrayList<Integer> stack = new ArrayList<>();
		ans[A.length-1] = A.length;
		top = push(stack, top, A.length-1);
		for (int i = A.length-2; i >= 0; i--) {
			while(stack.size() > 0 && A[i] <= A[peek(stack, top)]) {
				top = pop(stack, top);
			}
			if (stack.size() == 0) {
				ans[i] = A.length;
				top = push(stack, top, i);
			} else {
				ans[i] = peek(stack, top);
				top = push(stack, top, i);
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
