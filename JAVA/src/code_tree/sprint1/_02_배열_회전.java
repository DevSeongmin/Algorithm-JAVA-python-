package code_tree.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02_배열_회전 {

	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int Y = Integer.parseInt(input[0]);
		int X = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);

		int[][] board = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			input = br.readLine().split(" ");
			for (int j = 0 ; j < X; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}

		int depth = Math.min(Y, X) / 2;

		for (int d = 0; d < depth; d++) {

			for (int k = 0; k < K; k++) {
				int cy = d;
				int cx = d;
				int init = board[cy][cx];
				int dir = 0;

				while (true) {
					if (!(0 + d <= cy + dy[dir] && cy + dy[dir] < Y - d &&
						0 + d <= cx + dx[dir] && cx + dx[dir] < X -d)){
						dir++;
					}

					if (dir >=4 ) break;

					cy += dy[dir];
					cx += dx[dir];

					board[cy - dy[dir]][cx - dx[dir]] = board[cy][cx];
				}
				board[cy+1][cx] = init;
			}
		}

		for (int i = 0; i < Y; i++) {
			for (int j = 0; j < X; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}