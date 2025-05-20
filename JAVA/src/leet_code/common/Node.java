package leet_code.common;

import java.util.List;

public class Node {
	public int y, x, cnt, val;
	public Node left, right;
	public Node next;
	public Node random;
	public List<Node> neighbors;

	public Node(int val) {
		this.val = val;
	}

	public Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}