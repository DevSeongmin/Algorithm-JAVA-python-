package Programmers;

public class Lv3_징검다리_건너기 {
	class Solution {
		public int solution(int[] stones, int k) {
			int answer = 0;
			int left = 1;
			int right = 200_000_001;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (isPosible(mid, k, stones)) {
					answer = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			return answer;
		}

		public boolean isPosible(int mid, int k, int[] stones) {

			int connectCnt = 0;

			for (int stone : stones) {
				if (stone < mid) {
					connectCnt++;
					if (connectCnt >= k)
						return false;
				} else {
					connectCnt = 0;
				}
			}
			return true;
		}
	}
}
