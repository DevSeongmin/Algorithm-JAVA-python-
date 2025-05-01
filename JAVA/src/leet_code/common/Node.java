package leet_code.common;

public class Node {
	public int y, x, cnt, val;
	public Node next;
	public Node random;

	public Node(int val) {
		this.val = val;
	}

	public Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}