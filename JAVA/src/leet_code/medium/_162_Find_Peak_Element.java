package leet_code.medium;

public class _162_Find_Peak_Element {
	class Solution {
		public int findPeakElement(int[] nums) {

			long[] my_num = new long[nums.length+2];

			my_num[0] = Long.MIN_VALUE;
			for (int i = 0; i < nums.length; i++) {
				my_num[i+1] = nums[i];
			}
			my_num[nums.length+1] = Long.MIN_VALUE;

			int left = 1;
			int right = nums.length+1;

			while (left <= right) {
				int mid = (left + right) / 2;

				if (my_num[mid-1] < my_num[mid] && my_num[mid] > my_num[mid+1]) {
					return mid - 1;
				}

				if (my_num[mid-1] < my_num[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}

			return -1;
		}
	}
}
