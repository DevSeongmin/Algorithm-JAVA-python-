package code_tree.sprint10;

import java.io.*;
import java.util.*;

class Point{
	int y, x;

	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class _04_NxM_표_자르기 {

	static int Y, X;
	static int[][] board;
	static boolean[][] visited;
	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new int[Y][X];
		visited = new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursion(0, 0, 0);
		System.out.println(answer);
	}

	static void recursion(int y, int x, int value) {

		if (x >= X) {
			recursion(y + 1, 0, value);
			return;
		}

		if (y >= Y) {
			answer = Math.max(answer, value);
			return;
		}

		if (board[y][x] == 0) {
			recursion(y, x+1, value);
			return;
		}

		if (visited[y][x]){
			recursion(y, x + 1, value);
			return;
		}

		for (int i = 0; i < 2; i++) {
			String num = "";
			int cy = y;
			int cx = x;

			ArrayList<Point> points = new ArrayList();

			while (!(cy >= Y || cx >= X) && !visited[cy][cx]) {
				num += board[cy][cx];
				visited[cy][cx] = true;
				points.add(new Point(cy, cx));

				cy += dy[i];
				cx += dx[i];
				if (cy >= Y || cx >= X) {
					break;
				}
			}

			recursion(y, x+1, value + Integer.parseInt(num));

			for (Point p : points){
				visited[p.y][p.x] = false;
			}
		}
	}
}
