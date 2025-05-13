package leet_code.medium;

import java.util.LinkedList;
import java.util.Queue;

import leet_code.common.Node;

public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {


	class Solution {
		public Node connect(Node root) {
			if (root == null) return null;

			Queue<Node> q = new LinkedList<>();
			q.add(root);

			Node prev = null;
			while (!q.isEmpty()) {

				int iter = q.size();

				for (int i = 0; i < iter; i++) {
					Node cur = q.poll();

					if (i != 0) {
						prev.next = cur;
					}

					if (cur.left != null){
						q.add(cur.left);
					}
					if (cur.right != null){
						q.add(cur.right);
					}
					prev = cur;
				}
			}
			return root;
		}
	}
}
