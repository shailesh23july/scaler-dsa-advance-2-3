package scaler.dsa.stack.part.one;

import java.util.ArrayList;

public class EvaluateExpression {

	public static void main(String[] args) {
		//String[] A =   {"2", "1", "+", "3", "*"};
		//String[] A =   {"4", "13", "5", "/", "+"};
		String[] A = {"2","2","/"};
        System.out.println(evalRPN(A));
	}
	
	public static int evalRPN(String[] A) {
		ArrayList<Integer> stack = new ArrayList<>();
		int top = -1;
		for (int i = 0; i < A.length; i++) {
			String ch = A[i];
			if (ch != "+" && ch != "-" && ch != "*" && ch != "/" && ch != "%") {
				top++;
				push(Integer.parseInt(ch), stack );
			} else {
				int val2 = pop(top, stack);
				top--;
				int val1 = pop(top, stack);
				top--;
				int val3= operation(val1, val2, ch);
				top++;
				push(val3, stack );
			}
		}
		return peek(stack, top);
    }

	private static int peek(ArrayList<Integer> stack, int top) {
		return stack.get(top);
	}

	private static int operation(int val1, int val2, String ch) {
		if (ch.equals("*")) {
			return val1 * val2;
		} else if (ch.equals("+")) {
			return val1 + val2;
		} else if (ch.equals("-")) {
			return val1 - val2;
		} else if (ch.equals("/")) {
			return val1 / val2;
		} else if (ch.equals("%")) {
			return val1 % val2;
		}
		return -1;
	}

	private static int pop(int top, ArrayList<Integer> stack) {
		return stack.remove(top);
	}

	private static void push(int int1, ArrayList<Integer> stack) {
		stack.add(int1);
	}

}
