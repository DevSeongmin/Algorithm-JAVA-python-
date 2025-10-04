package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ5639_이진검색트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();

		String line;
		while (true){
			line = br.readLine();

			if (line == null) break;

			arr.add(Integer.parseInt(line));
		}

		Node head = new Node(arr.get(0));
		makeTree(head, 0, arr.size(), arr);

		postOrder(head);
	}

	static void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.val);
	}

	static void makeTree(Node parent, int s, int e, ArrayList<Integer> arr) {

		int lowIdx = -1;
		int highIdx = -1;

		for (int i = s+1; i < e; i++) {
			if (lowIdx == -1 && arr.get(i) < parent.val) {
				lowIdx = i;
			}
			if (highIdx == -1 && arr.get(i) > parent.val) {
				highIdx = i;
			}
		}

		if (lowIdx != -1 && highIdx != -1) {
			Node left = new Node(arr.get(lowIdx));
			Node right = new Node(arr.get(highIdx));

			parent.left = left;
			parent.right = right;

			makeTree(left, lowIdx, highIdx, arr);
			makeTree(right, highIdx, e, arr);

		} else if (highIdx == -1 && lowIdx != -1) {
			Node left = new Node(arr.get(lowIdx));
			parent.left = left;

			makeTree(left, lowIdx, e, arr);

		} else if (lowIdx == -1 && highIdx != -1) {
			Node right = new Node(arr.get(highIdx));
			parent.right = right;

			makeTree(right, highIdx, e, arr);
}

	}
}

class Node {
	int val;
	Node left, right;

	public Node(int val) {
		this.val = val;
	}

	public Node() {
	}
}