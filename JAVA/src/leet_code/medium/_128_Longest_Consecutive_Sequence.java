package leet_code.medium;

import java.util.HashSet;

public class _128_Longest_Consecutive_Sequence {

	/**
	 * 0 <= nums.length <= 10^5
	 * -10^9 <= nums[i] <= 10^9
	 * O(n)의 솔루션으로 구현해야한다.
	 *
	 * 초기에는 -10^9 ~ 10^9를 순회하며 해쉬를 이용해 숫자의 유무를 파악하여 최대 길이를 구하려 했지만 TLE
	 *
	 * 똑똑한 풀이 방법
	 *
	 * nums 의 숫자에서 왼쪽 오른쪽의 길이를 구해가며 최대 길이를 구한다.
	 * 이때 Set 에서 삭제해 가며 나중에 중복 체크하는 일이 없도록 한다.
	 *
	 */

	class Solution {
		public int longestConsecutive(int[] nums) {
			HashSet<Integer> set = new HashSet<>();

			for (int num : nums) {
				set.add(num);
			}

			int answer = 0;
			int l = 0;

			for (int i = 0; i < nums.length; i++) {

				int cnt = 1;

				int num = nums[i];
				while (set.contains(--num)) {
					cnt++;
					set.remove(num);
				}

				num = nums[i];
				while (set.contains(++num)) {
					cnt++;
					set.remove(num);
				}

				set.remove(nums[i]);

				answer = Math.max(answer, cnt);
			}

			return answer;
		}
	}
}
