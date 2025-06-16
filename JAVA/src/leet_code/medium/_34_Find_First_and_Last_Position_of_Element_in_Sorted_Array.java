package leet_code.medium;

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
	class Solution {
		public int[] searchRange(int[] nums, int target) {

			if (nums.length == 0) {
				return new int[] {-1, -1};
			}

			return new int[] {searchUnder(nums, target), searchUpper(nums, target)};
		}

		int searchUnder(int[] nums, int target) {
			int s = 0;
			int e = nums.length;

			int result = -1;

			while (s <= e) {
				int mid = (s + e) / 2;

				if (!(0 <= mid && mid < nums.length)){
					break;
				}


				if (nums[mid] == target) {
					e = mid - 1;
					result = mid;
				}
				else if (nums[mid] < target) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}

			return result;
		}

		int searchUpper(int[] nums, int target) {
			int s = 0;
			int e = nums.length;
			int result = -1;

			while (s <= e) {
				int mid = (s + e) / 2;

				if (!(0 <= mid && mid < nums.length)){
					break;
				}

				if (nums[mid] == target) {
					s = mid + 1;
					result = mid;
				}
				else if (nums[mid] < target) {
					s = mid + 1;
				} else {
					e = mid - 1;
				}
			}
			return result;
		}
	}
}
