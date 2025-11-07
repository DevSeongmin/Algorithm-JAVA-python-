package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ30024_옥수수밭 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int Y, X;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		boolean[][] visited = new boolean[Y][X];
		int[][] field = new int[Y][X];

		PriorityQueue<Corn> pq = new PriorityQueue<>();

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				if (i == Y-1 || j == X-1 || i == 0 || j == 0) {
					visited[i][j] = true;
					pq.add(new Corn(i, j, field[i][j]));
				}
			}
		}

		int repeat = Integer.parseInt(br.readLine());
		while (repeat--> 0) {
			Corn corn = pq.poll();

			for (int i = 0; i < 4; i++) {
				int ny = corn.y + dy[i];
				int nx = corn.x + dx[i];

				if (!isIn(ny, nx)) continue;
				if (visited[ny][nx]) continue;

				pq.add(new Corn(ny, nx, field[ny][nx]));
				visited[ny][nx] = true;
			}

			sb.append(corn.y + 1).append(" ").append(corn.x + 1).append("\n");
		}

		System.out.println(sb.toString());
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}

	static class Corn implements Comparable<Corn> {
		int y, x, value;
		public Corn(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}

		@Override
		public int compareTo(Corn o) {
			return Integer.compare(o.value, this.value);
		}
	}
}
