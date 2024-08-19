package scaler.dsa.queue;

import java.util.ArrayList;

public class PerfectNumbers {

	public static void main(String[] args) {
		System.out.println(solve(100000));

	}
	
	public static String solve(int A) {
		ArrayList<String> queue = new ArrayList<>();
		ArrayList<String> ansQueue = new ArrayList<>();
		String ans = "";
		int count = 0;
		int popCount = 0;
		enQueue("1", queue);
		enQueue("2", queue);
		while (popCount < A) {
			String pop = deQueue(queue);
			ansQueue.add(pop);
			String val1 = pop + "1";
			enQueue(val1, queue);
			String val2 = pop + "2";
			enQueue(val2, queue);
			popCount++;
		}
		ans = ansQueue.get(ansQueue.size()-1); 
		ans = ans+reve(ans);
		return ans;
	}
	
	public static void enQueue(String str, ArrayList<String> queue) {
		queue.add(str);
	}
	
	public static String deQueue(ArrayList<String> queue) {
		if (queue.size() == 0) {
			return "-1";
		}
		return queue.remove(0);
	}
	
	public static String reve(String str) {
		StringBuffer revstr = new StringBuffer();
		int i = str.length()-1;
		while (i >= 0) {
			revstr.append(str.charAt(i));
			i--;
		}
	   return revstr.toString();
	}

}
