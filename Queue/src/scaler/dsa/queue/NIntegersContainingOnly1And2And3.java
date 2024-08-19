package scaler.dsa.queue;

import java.util.ArrayList;

public class NIntegersContainingOnly1And2And3 {

	public static void main(String[] args) {
		int[] solve = solve(1);
        for (int i = 0; i < solve.length; i++) {
        	System.out.print(solve[i] + " ");
        }
	}

	public static int[] solve(int A) {
		int[] ans = new int[A];
		if(A == 1) {
			ans[0] = 1;
			return ans;
		} else if (A == 2) {
			ans[0] = 1;
			ans[1] = 2;
			return ans;
		}
		ArrayList<Integer> queue = new ArrayList<>();
		rearPush(queue, 1);
		rearPush(queue, 2);
		rearPush(queue, 3);
		int i = 3;
		int k = 0;
		while (i < A) {
			int frontval = frontPop(queue);
			ans[k++] = frontval;
			int val1 = (frontval * 10) + 1;
			rearPush(queue, val1);
			i++;
			if (i < A) {
				int val2 = (frontval * 10) + 2;
				rearPush(queue, val2);
				i++;
			}
			if (i < A) {
				int val3 = (frontval * 10) + 3;
				rearPush(queue, val3);
				i++;
			}
		}
		while(queue.size() > 0) {
			ans[k++] = frontPop(queue);
		}
		return ans;
	}

	public static int frontPop(ArrayList<Integer> queue) {
		return queue.remove(0);
	}

	public static void rearPush(ArrayList<Integer> queue, int val) {
		queue.add(val);
	}

}
