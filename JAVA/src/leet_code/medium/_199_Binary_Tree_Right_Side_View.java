package leet_code.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leet_code.common.TreeNode;

public class _199_Binary_Tree_Right_Side_View {

	static class Solution {
		public List<Integer> rightSideView(TreeNode root) {
			HashSet<Integer> visited = new HashSet<>();
			List<Integer> answer = new ArrayList<>();

			Queue<CustomTreeNode> q = new LinkedList<>();
			q.add(new CustomTreeNode(0, root));

			while(!q.isEmpty()) {
				CustomTreeNode ctn = q.poll();
				int step = ctn.step;
				TreeNode node = ctn.node;

				if (node == null) continue;

				if (!visited.contains(step)){
					answer.add(node.val);
					visited.add(step);
				}

				q.add(new CustomTreeNode(step + 1, node.right));
				q.add(new CustomTreeNode(step + 1, node.left));
			}

			return answer;
		}
	}
}

class CustomTreeNode extends TreeNode{
	int step;
	TreeNode node;

	public CustomTreeNode(int step, TreeNode node){
		super();
		this.step = step;
		this.node = node;
	}
}