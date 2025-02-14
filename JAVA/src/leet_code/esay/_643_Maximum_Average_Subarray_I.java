package leet_code.esay;

public class _643_Maximum_Average_Subarray_I {
	class Solution {
		public double findMaxAverage(int[] nums, int k) {
			double max = 0;

			for (int i = 0; i < k; i++) {
				max += (double) nums[i];
			}

			int left = 0;
			int right = k;

			System.out.println(max);
			double answer = max;
			while (right < nums.length) {
				max += nums[right++];
				max -= nums[left++];
				answer = Math.max(answer, max);
			}

			return answer / k;
		}
	}
}
