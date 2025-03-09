package leet_code.medium;

import java.util.PriorityQueue;

public class _2462_Total_Cost_to_Hire_K_Workers {
	class Cost {
		int idx, value;
		boolean isFront;

		public Cost(int idx, int value, boolean isFront) {
			this.idx = idx;
			this.value = value;
			this.isFront = isFront;
		}
	}

	class Solution {
		public long totalCost(int[] costs, int k, int candidates) {
			PriorityQueue<Cost> pq = new PriorityQueue<>(
				(a,b) -> a.value == b.value ? Integer.compare(a.idx, b.idx) : Integer.compare(a.value, b.value)
			);

			int n = costs.length;
			int frontIdx = 0;
			int backIdx = n - 1;

			for (int i = 0; i < candidates && frontIdx <= backIdx; i++)
				pq.offer(new Cost(frontIdx, costs[frontIdx++], true));

			for (int i = 0; i < candidates && frontIdx <= backIdx; i++)
				pq.offer(new Cost(backIdx, costs[backIdx--], false));

			long answer = 0;

			for (int hired = 0; hired < k; hired++) {
				Cost cost = pq.poll();
				answer += cost.value;

				if (frontIdx <= backIdx) {
					if (cost.isFront)
						pq.offer(new Cost(frontIdx, costs[frontIdx++], true));
					else
						pq.offer(new Cost(backIdx, costs[backIdx--], false));
				}
			}

			return answer;
		}
	}

}
