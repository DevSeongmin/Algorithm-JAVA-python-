package code_tree.sprint10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int y, x, cnt;

	public Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}

public class _03_목표지점 {

	static int Y, X;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int[][] board = new int[Y][X];
		int[][] answers = new int[Y][X];
		Node startNode = null;

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					startNode = new Node(i, j, 0);
				}

				answers[i][j] = -1;
				if (board[i][j] == 0) answers[i][j] = 0;
			}
		}


		Queue<Node> q = new LinkedList();
		answers[startNode.y][startNode.x] = 0;
		q.add(startNode);

		while(!q.isEmpty()){
			Node cur = q.poll();


			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (!isIn(ny, nx)) continue;
				if (board[ny][nx] == 0) continue;
				if (answers[ny][nx] != -1) continue;

				answers[ny][nx] = cur.cnt + 1;
				q.add(new Node(ny, nx, cur.cnt + 1));
			}
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				System.out.print(answers[i][j] + " ");
			}
			System.out.println();
		}

	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}
}