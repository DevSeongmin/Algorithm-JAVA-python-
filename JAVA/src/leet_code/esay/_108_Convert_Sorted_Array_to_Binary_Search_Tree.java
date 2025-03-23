package leet_code.esay;

import leet_code.common.TreeNode;

public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {
	class Solution {
		public TreeNode sortedArrayToBST(int[] nums) {
			return setTree(0, nums.length, nums);
		}
		static TreeNode setTree(int left, int right, int[] nums) {
			if (left >= right) return null;

			int mid = (left + right) / 2;

			TreeNode node = new TreeNode(nums[mid]);
			node.left = setTree(left, mid, nums);
			node.right = setTree(mid + 1, right, nums);

			return node;
		}
	}
}
