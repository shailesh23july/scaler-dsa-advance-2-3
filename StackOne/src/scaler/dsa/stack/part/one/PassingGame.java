package scaler.dsa.stack.part.one;

public class PassingGame {
	
	
	public static void main(String[] args) {
		int A = 10;
		int B = 23;
		int[] C = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
		System.out.println(solve(A, B, C));
	}
	
	 public static int solve(int A, int B, int[] C) {
		 int[] stack = new int[A+1];
		 int top = -1;
		 top = push(B, top, stack);
		 for (int i = 0; i < C.length; i++) {
			 if (C[i] != 0) {
				 top = push(C[i], top, stack); 
			 } else {
				 top = pop(top, stack);
			 }
		 }
		 return peek(top, stack);
	 }

	private static int peek(int top, int[] stack) {
		return stack[top];
	}

	private static int pop(int top, int[] stack) {
		stack[top] = 0;
		top--;
		return top;
	}

	private static int push(int id, int top, int[] stack) {	
		top++;
		stack[top] = id;
		return top;
	}

}
