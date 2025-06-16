package leet_code.medium;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {
	class Solution {
		public int findMin(int[] nums) {
			int left = 0;
			int right = nums.length - 1;

			while (left < right) {
				int mid = (right + left) / 2;

				if (nums[mid] > nums[right]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			return nums[left];

		}
	}
}
