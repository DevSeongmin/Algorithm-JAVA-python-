package code_tree.sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01_색종이2 {
	static final int SIZE = 100;
	static int[][] grid = new int[SIZE][SIZE];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for(int dx = 0; dx < 10; dx++) {
				for(int dy = 0; dy < 10; dy++) {
					grid[x + dx][y + dy] = 1;
				}
			}
		}

		int answer = 0;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(grid[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if(!isIn(ny , nx) || grid[nx][ny] == 0) {
							answer++;
						}
					}
				}
			}
		}

		System.out.println(answer);
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < 100 && 0 <= x && x < 100;
	}
}