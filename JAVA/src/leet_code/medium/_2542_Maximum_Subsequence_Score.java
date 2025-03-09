package leet_code.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2542_Maximum_Subsequence_Score {
	class Pair {
		int a, b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	class Solution {
		public long maxScore(int[] nums1, int[] nums2, int k) {

			int l = nums1.length;
			Pair[] pairArr = new Pair[l];

			for (int i = 0; i < l; i++) {
				pairArr[i] = new Pair(nums1[i], nums2[i]);
			}

			Arrays.sort(pairArr, (a,b) -> a.b == b.b ? Integer.compare(b.a, a.a) : Integer.compare(b.b, a.b));

			PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.a, b.a));

			long answer = 0;
			long minProduct = Long.MAX_VALUE;
			long sum = 0;

			for (Pair p : pairArr) {
				minProduct = Math.min(minProduct, p.b);
				sum += p.a;
				pq.add(p);

				if (pq.size() >= k) {
					answer = Math.max(answer, sum * minProduct);
					sum -= pq.poll().a;
				}
			}

			return answer;
		}
	}
}
