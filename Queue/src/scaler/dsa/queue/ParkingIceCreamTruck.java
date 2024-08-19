package scaler.dsa.queue;

import java.util.ArrayList;

public class ParkingIceCreamTruck {

	public static void main(String[] args) {
		//int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
		//int B = 3;
		int[] A = {1, 2, 3, 4, 2, 7, 1, 3, 6};
		int B = 6;
		int[] slidingMaximum = slidingMaximum(A, B);
		for (int i = 0; i < slidingMaximum.length; i++) {
			System.out.print(slidingMaximum[i] + " ");
		}

	}

	public static int[] slidingMaximum(final int[] A, int B) {
		ArrayList<Integer> queue = new ArrayList<>();
		int[] ans = new int[A.length - B + 1];
		for (int i = 0; i < B; i++) {
			while (queue.size() > 0 && queue.get(queue.size()-1) < A[i]) {
				queue.remove(queue.size()-1);
			}
			queue.add(A[i]);
		}
		int i = 1;
		int j = B;
		int k = 0;
		while(j < A.length) {
			ans[k++] = queue.get(0);
			// Acquire
			while (queue.size() > 0 && queue.get(queue.size()-1) < A[j]) {
				queue.remove(queue.size()-1);
			}
			queue.add(A[j]);
			//release
			if (queue.get(0) == A[i-1]) {
				queue.remove(0);
			}
			i++;
			j++;
		}
		ans[k++] = queue.get(0);
		return ans;
	}

}
