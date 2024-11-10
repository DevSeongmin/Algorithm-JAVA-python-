package Programmers;

import java.util.ArrayList;
import java.util.List;

class Node {
	int x, y, num;
	Node left, right;

	Node(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}
}

public class Lv3_길_찾기_게임 {

	static int cnt;
	static int[][] answer;

	public int[][] solution(int[][] nodeinfo) {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < nodeinfo.length; i++) {
			nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}

		nodes.sort((a, b) -> b.y != a.y ? Integer.compare(b.y, a.y) : Integer.compare(a.x, b.x));

		Node root = nodes.get(0);

		for (int i = 1; i < nodes.size(); i++) {
			addNode(root, nodes.get(i));
		}

		answer = new int[2][nodeinfo.length];

		cnt = 0;
		preOrder(root);
		cnt = 0;
		postOrder(root);

		return answer;
	}

	private void addNode(Node parent, Node child) {
		if (child.x < parent.x) {
			if (parent.left == null) {
				parent.left = child;
			} else {
				addNode(parent.left, child);
			}
		} else {
			if (parent.right == null) {
				parent.right = child;
			} else {
				addNode(parent.right, child);
			}
		}
	}

	private void preOrder(Node node) {
		if (node != null) {
			answer[0][cnt++] = node.num;
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	private void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			answer[1][cnt++] = node.num;
		}
	}
}

