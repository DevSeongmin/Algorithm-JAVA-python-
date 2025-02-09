package leet_code.medium;

import java.util.Arrays;

public class _334_Increasing_Triplet_Subsequence {
	class Solution {
		public boolean increasingTriplet_MySolve(int[] nums) {

			int l = nums.length;

			long[] check = new long[4];

			Arrays.fill(check, Long.MAX_VALUE);
			check[0] = Long.MIN_VALUE;

			for (int num : nums) {

				for (int i =1; i <= 3; i++) {

					if (check[i-1] == Long.MAX_VALUE) break;

					if (num > check[i-1]) {
						check[i] = Math.min(check[i], num);
					}
				}
			}

			return check[3] == Long.MAX_VALUE ? false : true;
		}

		public boolean increasingTriplet(int[] nums) {

			int l = nums.length;

			int small = Integer.MAX_VALUE;
			int big = Integer.MAX_VALUE;

			for (int num : nums) {
				if (small >= num) {
					small = num;
					continue;
				}

				if (big >= num) {
					big = num;
					continue;
				}

				return true;
			}

			return false;
		}
	}
}
