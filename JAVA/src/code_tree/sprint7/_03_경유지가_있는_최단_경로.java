package code_tree.sprint7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _03_경유지가_있는_최단_경로 {

	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	static int Y, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int[][] visited = new int[Y][X];
		int[][] BOARD = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				BOARD[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}

		Node startNode = new Node(0, 0, 0);

		if (BOARD[0][0] == 1) startNode.cnt = 1;

		Queue<Node> q = new LinkedList();
		q.add(startNode);
		visited[0][0] = startNode.cnt;

		int answer = -1;

		while(!q.isEmpty()) {
			Node curNode = q.poll();

			if (curNode.y == Y-1 && curNode.x == X-1) {
				answer = Math.max(answer, curNode.cnt);
			}

			for (int i = 0; i < 2; i ++) {
				int ny = dy[i] + curNode.y;
				int nx = dx[i] + curNode.x;
				int nCnt = curNode.cnt;

				if (!isIn(ny, nx)) continue;

				if (BOARD[ny][nx] == 1) {
					nCnt++;
				}

				if (visited[ny][nx] >= nCnt) continue;

				visited[ny][nx] = nCnt;
				q.add(new Node(ny, nx, nCnt));
			}
		}
		System.out.println(answer);
	}

	static boolean isIn(int y, int x) {
		return y < Y && x < X;
	}
}

class Node {
	int y, x, cnt;

	public Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
}