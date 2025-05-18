package leet_code.medium;

import leet_code.common.TreeNode;

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	class Solution {
		static TreeNode answer;
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			answer = null;
			dfs(root, p, q);
			return answer;
		}

		static int dfs(TreeNode root, TreeNode p, TreeNode q) {

			if (root == null) return 0;

			int value;

			if (root.val == p.val || root.val == q.val) {
				value = dfs(root.left, p, q) + dfs(root.right, p, q) + 1;
			} else {
				value = dfs(root.left, p, q) + dfs(root.right, p, q);
			}


			if (value == 2 && answer == null) {
				answer = root;
			}

			return value;
		}
	}
}
