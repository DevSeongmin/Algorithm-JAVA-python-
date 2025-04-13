package leet_code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3Sum {

	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {
			Arrays.sort(nums);
			int l = nums.length;
			List<List<Integer>> answer = new ArrayList<>();


			for (int stand = 0; stand < l - 2; stand++) {
				if (stand > 0 && nums[stand] == nums[stand-1]) {
					continue;
				}

				int left = stand + 1;
				int right = l - 1;

				while (left < right) {
					int sum = nums[stand] + nums[left] + nums[right];

					if (sum == 0) {
						answer.add(Arrays.asList(nums[stand], nums[left], nums[right]));
						left++;
						while (nums[left] == nums[left - 1] && left < right) {
							left++;
						}
					} else if (sum < 0) {
						left++;
					} else if (sum > 0) {
						right--;
					}
				}
			}
			return answer;
		}
	}
}
