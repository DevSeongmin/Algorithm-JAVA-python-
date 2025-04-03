package leet_code.medium;

// in-place order solve!!!

public class _189_Rotate_Array {
	class Solution {
		public void rotate(int[] nums, int k) {
			k %= nums.length;

			reverse(nums, 0, nums.length-1);
			reverse(nums, 0, k-1);
			reverse(nums, k , nums.length-1);

		}
		static void reverse(int[] arr, int s, int e) {
			while (s < e) {
				int tmp = arr[s];
				arr[s] = arr[e];
				arr[e] = tmp;
				s++;
				e--;
			}
		}
	}
}
