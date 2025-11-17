package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ16724_피리부는사나이 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int Y, X;
	static HashMap<Character, Node> dMap = new HashMap<>();
	static Node[][] unionFindMap;
	static{
		dMap.put('D', new Node(1, 0));
		dMap.put('U', new Node(-1, 0));
		dMap.put('L', new Node(0, -1));
		dMap.put('R', new Node(0, 1));
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		unionFindMap = new Node[Y][X];

		char[][] board = new char[Y][X];
		boolean[][] visited = new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			char[] input = br.readLine().toCharArray();
			board[i] = input;

			for (int j = 0; j < X; j++) {
				unionFindMap[i][j] = new Node(i, j);
			}
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				Node curNode = unionFindMap[i][j];

				Node direction = dMap.get(board[i][j]);
				int ny = i + direction.y;
				int nx = j + direction.x;

				if (!isIn(ny, nx)) continue;

				Node nextNode = unionFindMap[ny][nx];
				union(curNode, nextNode);
			}
		}

		System.out.println(setCount(unionFindMap));
	}

	private static int setCount(Node[][] unionFindMap) {
		int count= 0;

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				Node curNode = unionFindMap[i][j];
				if (curNode.y == i && curNode.x == j) {
					count++;
				}
			}
		}
		return count;
	}

	static Node find(Node node) {
		Node parent = unionFindMap[node.y][node.x];
		if (node.equals(parent)) return node;

		return node = find(parent);
	}

	static boolean union(Node node1, Node node2) {
		Node pNode1 = find(node1);
		Node pNode2 = find(node2);

		if (pNode1.equals(pNode2)) return false;

		unionFindMap[pNode1.y][pNode1.x] = pNode2;
		return true;
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}

	static class Node{
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public boolean equals(Node o) {
			return this.y == o.y && this.x == o.x;
		}
	}
}
