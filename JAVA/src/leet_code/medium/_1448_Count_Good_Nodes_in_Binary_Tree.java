package leet_code.medium;

import leet_code.common.TreeNode;

public class _1448_Count_Good_Nodes_in_Binary_Tree {
	class Solution {
		int good;
		public int goodNodes(TreeNode root) {
			good = 0;
			dfs(root, Integer.MIN_VALUE);
			return good;
		}
		void dfs(TreeNode root, int max) {
			if (root == null) return;
			if (max <= root.val) {
				good++;
				max = root.val;
			}

			dfs(root.left, max);
			dfs(root.right, max);
		}
	}
}