package scaler.dsa.stack.part.one;

import java.util.ArrayList;

public class BalancedParanthesis {

	public static void main(String[] args) {
      String A = "}}}";
      //solve(A);
      System.out.println(solve(A));
	}

	public static int solve(String A) {
		ArrayList<Character> stack = new ArrayList<>();
		Integer top = -1;
		for (int i = 0; i < A.length(); i++) {
			Character c = A.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				top++;
				push(c, stack);
			} else if (c == ')' || c == '}' || c == ']') {
				Character cc = pop(top, stack);
				if(null == cc) {
					return 0;
				}
				top--;
				if ((cc == '(' && c == ')')) {
					continue;
				} else if ((cc == '{' && c == '}')) {
					continue;
				} else if ((cc == '[' && c == ']')) {
					continue;
				} else {
					return 0;
				}
			}
		}
		if (stack.size() > 0) {
			return 0;
		}
		return 1;
	}

	private static Character pop(int top, ArrayList<Character> stack) {
		if(top < 0) {
			return null;
		}
		Character character = stack.remove(top);
		return character;
	}

	private static void push(char c, ArrayList<Character> stack) {
		stack.add(c);
	}

}
