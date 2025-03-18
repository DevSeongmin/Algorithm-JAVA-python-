package leet_code.medium;

import java.util.Arrays;

public class _435_Non_overlapping_Intervals {
	class Solution {
		public int eraseOverlapIntervals(int[][] intervals) {

			Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

			int rmCnt = 0;
			int prev = 0;

			for (int i = 1; i < intervals.length; i++) {
				if (intervals[i][0] >= intervals[prev][1]) {
					prev = i;
				} else {
					rmCnt++;
				}
			}
			return rmCnt;
		}
	}
}
