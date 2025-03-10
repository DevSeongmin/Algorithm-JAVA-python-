package leet_code.medium;

import java.util.Arrays;

public class _875_Koko_Eating_Bananas {
	class Solution {
		public int minEatingSpeed(int[] piles, int h) {
			long left = 1;
			long right = Arrays.stream(piles).max().getAsInt();

			while (left <= right) {
				long mid = (left + right) / 2;

				if (isPos(mid, piles, h)){
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			return (int) left;
		}

		static boolean isPos(long mid, int[] piles, int h) {
			long hour = 0;

			for (int p : piles) {
				h -= p / mid;
				if (p % mid > 0) h--;
			}

			return h >= 0;
		}
	}
}
