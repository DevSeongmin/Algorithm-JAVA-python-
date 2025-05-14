package leet_code.medium;

import java.util.Stack;

import leet_code.common.TreeNode;

public class _173_Binary_Search_Tree_Iterator {
	class BSTIterator {

		Stack<TreeNode> stack;
		public BSTIterator(TreeNode root) {
			stack = new Stack<>();

			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}
		public int next() {
			TreeNode cur = stack.pop();
			int nextInt = cur.val;

			TreeNode rightChild = cur.right;

			while (rightChild != null) {
				stack.push(rightChild);
				rightChild = rightChild.left;
			}

			return nextInt;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}
	}
}
