package leet_code.medium;

import leet_code.common.TreeNode;

public class _114_Flatten_Binary_Tree_to_Linked_List {
	class Solution {




		// 내 풀이
		public void flatten(TreeNode root) {
			travel(root);
		}

		TreeNode travel(TreeNode root) {
			if (root == null) return null;

			System.out.println(root.val + "|");

			TreeNode left = travel(root.left);
			TreeNode right = travel(root.right);


			if (left != null && right != null) {
				root.right = left;
				root.left = null;

				while (left.right != null) {
					left = left.right;
				}
				left.left = null;
				left.right = right;
			}

			if (left != null && right == null) {
				root.right = left;
				root.left = null;
			}

			return root;
		}


		// 최적화 된 풀이
		public void flattenOptimized(TreeNode root) {
			if (root == null) return;

			TreeNode left = root.left;
			TreeNode right = root.right;

			root.left = null;

			flatten(left);
			flatten(right);

			root.right = left;
			while (root.right != null) {
				root = root.right;
			}
			root.right = right;
		}

	}

}
