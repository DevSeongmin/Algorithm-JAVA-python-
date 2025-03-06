package leet_code.medium;

public class _450_Delete_Node_in_a_BST {
	class Solution {
		public TreeNode deleteNode(TreeNode root, int key) {
			if (root == null) return null;

			if (key < root.val) {
				root.left = deleteNode(root.left, key);
				return root;
			}

			if (key > root.val) {
				root.right = deleteNode(root.right, key);
				return root;
			} else {
				if (root.left == null) {
					return root.right;
				}

				if (root.right == null) {
					return root.left;
				}

				TreeNode min = searchMin(root.right);
				root.val = min.val;
				root.right = deleteNode(root.right, min.val);
				return root;

			}

		}
		static TreeNode searchMin(TreeNode node) {
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}
	}
}
