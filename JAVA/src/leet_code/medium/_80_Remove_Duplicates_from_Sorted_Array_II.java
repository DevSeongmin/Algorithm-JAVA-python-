package leet_code.medium;

import java.util.HashMap;

public class _80_Remove_Duplicates_from_Sorted_Array_II {
	class Solution {
		public int removeDuplicates(int[] nums) {
			HashMap<Integer, Integer> map = new HashMap<>();

			int idx = 0;
			for (int i = 0; i < nums.length; i++) {
				int num = nums[i];

				map.put(num, map.getOrDefault(num, 0) + 1);

				if (map.get(num) <= 2) {
					nums[idx++] = num;
				}
			}
			return idx;
		}


		// Best Practice
		public int removeDuplicates2(int[] nums) {
			int i = 0;
			for (int n : nums)
				if (i < 2 || n > nums[i - 2])
					nums[i++] = n;
			return i;
		}
	}
}
