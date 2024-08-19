package scaler.dsa.stack.part.one;

import java.util.ArrayList;

public class Infix2Postfix {

	public static void main(String[] args) {
		// String A = "x^y/(a*z)+b";
		//String A = "a+b*(c^d-e)^(f+g*h)-i";
		String A = "a+b*(c+d*e)-h";
		System.out.println(solve(A));
	}

	public static String solve(String A) {
		ArrayList<String> stack = new ArrayList<>();
		int top = -1;
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			int ch = (int) A.charAt(i);
			if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
				ans.append((char) ch);
				System.out.println(ans.toString());
			} else {
				char c = (char) ch;
				int chPrecedance = precedanceRule(Character.toString(c));
				String topElement = peek(top, stack);
				if (null == topElement) {
					push(Character.toString(c), stack);
					top++;
				} else {
					int topElementPrecedence = precedanceRule(topElement);
					if (chPrecedance == 5) {
						while (topElementPrecedence != 4) {
							String pop = pop(top, stack);
							top--;
							ans.append(pop);
							topElement = peek(top, stack);
							topElementPrecedence = precedanceRule(topElement);
						}
						pop(top, stack);
						top--;
						continue;
					}
					if (chPrecedance > topElementPrecedence || topElementPrecedence == 4) {
						push(Character.toString(c), stack);
						top++;
					} else {
						while (topElementPrecedence >= chPrecedance && topElementPrecedence != 4) {
							String pop = pop(top, stack);
							top--;
							if (!pop.equals("(") && !pop.equals(")")) {
								ans.append(pop);
								System.out.println(ans.toString());
							}
							topElement = peek(top, stack);
							if (null == topElement) {
								break;
							}
							int t = precedanceRule(topElement);
							topElementPrecedence = t;
						}
						push(Character.toString(c), stack);
						top++;
					}
				}
			}
		}
		while (top >= 0) {
			String pop = pop(top, stack);
			top--;
			ans.append(pop);
		}
		return ans.toString();
	}

	public static int precedanceRule(String str) {
		if (str.equals(")")) {
			return 5;
		} else if (str.equals("(")) {
			return 4;
		} else if (str.equals("^")) {
			return 3;
		} else if (str.equals("*") || str.equals("/")) {
			return 2;
		} else if (str.equals("+") || str.equals("-")) {
			return 1;
		}
		return 0;
	}

	public static String peek(int top, ArrayList<String> stack) {
		if (top < 0) {
			return null;
		}
		return stack.get(top);
	}

	public static void push(String chString, ArrayList<String> stack) {
		stack.add(chString);
	}

	public static String pop(int top, ArrayList<String> stack) {
		return stack.remove(top);
	}

}
