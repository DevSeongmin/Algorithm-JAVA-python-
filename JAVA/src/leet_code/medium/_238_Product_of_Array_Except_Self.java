package leet_code.medium;

public class _238_Product_of_Array_Except_Self {
	class Solution {
		public int[] productExceptSelf(int[] nums) {
			int l = nums.length;

			int[] premulti = new int[l];
			int[] postmulti = new int[l];

			premulti[0] = nums[0];

			for (int i=1; i < l; i++) {
				premulti[i] = nums[i] * premulti[i-1];
			}

			postmulti[l-1] = nums[l-1];

			for (int i = l-2; i >= 0; i--) {
				postmulti[i] = nums[i] * postmulti[i+1];
			}

			int[] answer = new int[l];

			for (int i = 0; i < l; i++) {
				int left = 1;
				int right = 1;

				if (0 <= i-1){
					left = premulti[i-1];
				}

				if (i + 1 < l) {
					right = postmulti[i+1];
				}

				answer[i] = left * right;
			}
			return answer;
		}
	}
}
