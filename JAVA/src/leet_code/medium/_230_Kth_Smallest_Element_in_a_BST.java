package leet_code.medium;

import leet_code.common.TreeNode;

public class _230_Kth_Smallest_Element_in_a_BST {
	class Solution {
		int cnt, answer;

		public int kthSmallest(TreeNode root, int k) {
			answer = 0;
			cnt = 0;
			search(root, k);

			return answer;
		}

		void search(TreeNode root, int k) {
			if (root == null) return;

			search(root.left, k);
			cnt++;
			if (cnt == k) {
				answer = root.val;
			}

			search(root.right, k);
		}
	}
}
