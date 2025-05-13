package leet_code.medium;

import leet_code.common.TreeNode;

public class _129_Sum_Root_to_Leaf_Numbers {
	class Solution {
		public int sumNumbers(TreeNode root) {
			return travelSum(root, 0);
		}

		public int travelSum(TreeNode node, int curVal) {
			if (node == null) return 0;

			if (node.left == null && node.right == null) {
				return curVal * 10 + node.val;
			}

			return travelSum(node.left, curVal * 10 + node.val) +
				travelSum(node.right, curVal * 10 + node.val);
		}
	}
}
