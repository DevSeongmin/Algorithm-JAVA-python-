package leet_code.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leet_code.common.TreeNode;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {
	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> answer = new LinkedList<>();

			if (root == null) return answer;

			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);

			boolean flag = true;

			while (!q.isEmpty()) {
				int qSize = q.size();
				List<Integer> list = new LinkedList<>();

				for (int i = 0; i < qSize; i++) {
					TreeNode cur = q.poll();

					if (flag) {
						list.add(cur.val);
					} else {
						list.add(0, cur.val);
					}

					if (cur.left != null) {
						q.add(cur.left);
					}
					if (cur.right != null) {
						q.add(cur.right);
					}
				}

				answer.add(list);
				flag = !flag;
			}

			return answer;
		}
	}
}
