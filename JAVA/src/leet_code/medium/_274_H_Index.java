package leet_code.medium;

import java.util.Arrays;

public class _274_H_Index {
	class Solution {

		// 내 풀이
		public int hIndex(int[] citations) {
			Arrays.sort(citations);

			int l  = citations.length;
			int h = 0;
			int idx = 0;
			int answer = 0;

			while (h <= 5000 && idx < l) {
				if (citations[idx] >= h) {
					int cnt = l - idx;
					if (cnt >= h) {
						answer = h;
					}
					h++;
				} else {
					idx++;
				}
			}

			return answer;
		}


		// 카운팅 정렬을 이용한 O(n)알고리즘 풀이
		public int hIndex2(int[] citations) {
			int n = citations.length;
			int[] buckets = new int[n+1];
			for(int c : citations) {
				if(c >= n) {
					buckets[n]++;
				} else {
					buckets[c]++;
				}
			}
			int count = 0;
			for(int i = n; i >= 0; i--) {
				count += buckets[i];
				if(count >= i) {
					return i;
				}
			}
			return 0;
		}
	}
}
