package leet_code.medium;

public class _33_Search_in_Rotated_Sorted_Array {
	class Solution {
		public int search(int[] nums, int target) {

			int s = findStart(nums);
			int e = nums.length + s;

			while (s <= e) {
				int mid = (s + e) / 2;

				int val = nums[mid % nums.length];

				if (val == target) return mid % nums.length;
				if (val < target) {
					s = mid + 1;
				}

				if (val > target) {
					e = mid -1;
				}
			}

			return -1;
		}
		int findStart(int[] nums) {
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] < nums[i-1]) {
					return i;
				}
			}
			return 0;
		}
	}
}
