package leet_code.esay;

public class _283_Move_Zeroes {
	class Solution {
		public void moveZeroes(int[] nums) {
			int[] answer = new int[nums.length];

			int idx = 0;
			int zCnt = 0;

			for (int num : nums){
				if (num != 0){
					answer[idx++] = num;
				}
			}

			for (int i = 0; i < nums.length; i++) {
				nums[i] = answer[i];
			}
		}
	}
}
