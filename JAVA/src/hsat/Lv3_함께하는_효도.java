package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_함께하는_효도 {

	public class Main {
		static int N, K;
		static int[][] board;
		static Node[] friends;
		static int[][] visited;
		static int[] moveY = {-1, 1, 0, 0};
		static int[] moveX = {0, 0, -1, 1};
		static int maxVal = 0;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			visited = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			friends = new Node[K];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()) - 1;
				int x = Integer.parseInt(st.nextToken()) - 1;

				visited[y][x] = 1;
				friends[i] = new Node(y, x);
			}

			search(0, 0, -1, -1);

			System.out.println(maxVal);
		}

		static void search(int radix, int depth, int y, int x) {
			if (radix == K) {
				int value = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (visited[i][j] > 0) {
							value += board[i][j];
						}
					}
				}
				maxVal = Math.max(maxVal, value);
				return;
			}

			if (depth >= 3) {
				search(radix+1, 0, -1, -1);
				return;
			}

			if (depth == 0) {
				y = friends[radix].y;
				x = friends[radix].x;
			}

			for (int i = 0; i < 4; i++) {
				int ny = y + moveY[i];
				int nx = x + moveX[i];

				if (!isIn(ny, nx)) continue;

				visited[ny][nx]++;
				search(radix, depth+1, ny, nx);
				visited[ny][nx]--;
			}
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < N && 0 <= x && x < N;
		}

		static class Node {
			int y, x;
			public Node(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}
	}
}
