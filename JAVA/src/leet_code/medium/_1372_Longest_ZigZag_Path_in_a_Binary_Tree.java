package leet_code.medium;

import leet_code.common.TreeNode;

public class _1372_Longest_ZigZag_Path_in_a_Binary_Tree {
	class Solution {
		int maxStep = 0;
		public int longestZigZag(TreeNode root) {
			dfs(root, -1, 0);
			dfs(root, 1, 0);

			return maxStep;
		}
		private void dfs(TreeNode root, int direction, int step) {
			if (root == null) return;
			maxStep = Math.max(maxStep, step);

			if (direction == -1) {
				dfs(root.right, 1, step + 1);
				dfs(root.left, -1, 1);
			} else {
				dfs(root.left, -1, step + 1);
				dfs(root.right, 1, 1);
			}
		}
	}
}
