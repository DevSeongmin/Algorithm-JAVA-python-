package leet_code.medium;

import leet_code.common.TreeNode;

public class _437_Path_Sum_III {
	class Solution {
		public int pathSum(TreeNode root, int targetSum) {
			if (root == null) return 0;
			return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + dfs(root, targetSum);

		} static int dfs(TreeNode node, long targetSum) {
			if (node == null) return 0;
			int cnt = 0;
			if (node.val == targetSum) cnt++;
			cnt += dfs(node.left, targetSum - node.val);
			cnt += dfs(node.right, targetSum - node.val);
			return cnt;
		}
	}
}
