package scaler.dsa.queue;

import java.util.ArrayList;

public class QueueUsingStacks {

	public static void main(String[] args) {
		QueueUsingStacks.UserQueue obj = new UserQueue();
		UserQueue.push(20);
		System.out.println(UserQueue.empty());
		System.out.println(UserQueue.peek());
		System.out.println(UserQueue.pop());
		System.out.println(UserQueue.empty());
		UserQueue.push(30);
		System.out.println(UserQueue.peek());
		UserQueue.push(40);
		System.out.println(UserQueue.peek());
		for(int i = 0; i < UserQueue.stack.size(); i++) {
			System.out.print(UserQueue.stack.get(i));
		}
	}

	public static class UserQueue {

		static ArrayList<Integer> stack;
		static ArrayList<Integer> helperStack;
		static int top;
		static int helperTop;

		/** Initialize your data structure here. */
		UserQueue() {
			UserQueue.stack = new ArrayList<>();
			UserQueue.helperStack = new ArrayList<>();
			UserQueue.top = -1;
			UserQueue.helperTop = -1;

		}

		/** Push element X to the back of queue. */
		static void push(int X) {
			if (UserQueue.empty()) {
				UserQueue.stack.add(X);
				UserQueue.top++;
			} else {
				while(UserQueue.stack.size() > 0) {
					int pop = UserQueue.pop();
					UserQueue.helperStack.add(pop);
					UserQueue.helperTop++;
				}
				UserQueue.stack.add(X);
				UserQueue.top++;
				while(UserQueue.helperStack.size() > 0) {
					int pop = UserQueue.helperStack.remove(UserQueue.helperTop);
					UserQueue.helperTop--;
					UserQueue.stack.add(pop);
					UserQueue.top++;
				}
			}

		}

		/** Removes the element from in front of queue and returns that element. */
		static int pop() {
			int element = UserQueue.stack.remove(UserQueue.top);
			UserQueue.top--;
			return element;
		}

		/** Get the front element of the queue. */
		static int peek() {
			return UserQueue.stack.get(UserQueue.top);
		}

		/** Returns whether the queue is empty. */
		static boolean empty() {
			return UserQueue.stack.size() == 0;
		}
	}

}
