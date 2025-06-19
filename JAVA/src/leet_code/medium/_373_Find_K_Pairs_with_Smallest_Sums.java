package leet_code.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _373_Find_K_Pairs_with_Smallest_Sums {

	class Solution {
		public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
			List<List<Integer>> answer = new ArrayList<>();
			if (nums1.length == 0 || nums2.length == 0) return answer;

			PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
			);

			for (int i = 0; i < Math.min(nums1.length, k); i++) {
				pq.add(new int[] {i, 0});
			}

			while (k-- > 0 && !pq.isEmpty()) {
				int[] cur = pq.poll();
				answer.add(List.of(nums1[cur[0]], nums2[cur[1]]));

				if (cur[1] + 1 < nums2.length) pq.add(new int[] {cur[0], cur[1] + 1});
			}

			return answer;
		}
	}

}
