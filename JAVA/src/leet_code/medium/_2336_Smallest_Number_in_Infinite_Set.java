package leet_code.medium;

import java.util.PriorityQueue;

public class _2336_Smallest_Number_in_Infinite_Set {
	static class SmallestInfiniteSet {
		static PriorityQueue<Integer> q;
		static int next;

		public SmallestInfiniteSet() {
			q = new PriorityQueue<>();
			next = 1;
		}

		public int popSmallest() {
			if (q.isEmpty()) {
				return next++;
			}
			int value = q.poll();
			return value;
		}

		public void addBack(int num) {
			if (num < next && !q.contains(num)) {
				q.add(num);
			}
		}
	}

}
