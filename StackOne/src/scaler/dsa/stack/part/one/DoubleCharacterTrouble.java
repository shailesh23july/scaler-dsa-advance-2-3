package scaler.dsa.stack.part.one;

import java.util.ArrayList;

public class DoubleCharacterTrouble {

	public static void main(String[] args) {
		String A = "";
		System.out.println(solve(A));

	}
	
	public static String solve(String A) {
		ArrayList<Character> stack = new ArrayList<>();
		StringBuilder ans = new StringBuilder();
		int top = -1;
		for (int i = 0; i < A.length(); i++) {
			Character c = A.charAt(i);
			Character peekCharacter = peek(stack, top);
			if (null == peekCharacter || c != peekCharacter) {
				top++;
				push(c, stack);
			} else if (c == peekCharacter) {
				pop(c, stack, top);
				top--;
			}
		}
		for (Character c : stack) {
			ans.append(c);
		}
		return ans.toString();
    }

	private static void pop(Character c, ArrayList<Character> stack, int top) {
		stack.remove(top);
	}

	private static void push(Character c, ArrayList<Character> stack) {
		stack.add(c);
	}

	private static Character peek(ArrayList<Character> stack, int top) {
		if (top < 0) {
			return null;
		}
		return stack.get(top);
		
	}

}
