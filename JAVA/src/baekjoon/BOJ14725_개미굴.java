package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ14725_개미굴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Node head = new Node();

		for (int i = 0; i < N; i++) {
			String[] stringArr = br.readLine().split(" ");
			int cnt = Integer.parseInt(stringArr[0]);

			Node node = head;
			for (int j = 1; j < cnt + 1; j++) {
				String s = stringArr[j];

				if (node.children.containsKey(s)) {
					node = node.children.get(s);
				} else {
					node.children.put(s, new Node());
					node = node.children.get(s);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		dfs(head, 0, sb);
		System.out.println(sb);
	}

	static void dfs(Node node, int depth, StringBuilder sb) {

		for (String s : node.children.keySet()) {
			for (int k = 0; k < depth; k++) {
				sb.append("--");
			}
			sb.append(s).append("\n");
			dfs(node.children.get(s), depth + 1, sb);
		}
	}

	static class Node {
		TreeMap<String, Node> children;

		public Node() {
			children = new TreeMap<String, Node>();
		}
	}
}
