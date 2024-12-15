package code_tree.sprint30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _03_최소_막대의_개수 {

	static int Y, X, cnt;
	static int answer = Integer.MAX_VALUE;
	static String[] board;
	static int[][] vis;
	static int[] dy = {0, 1};
	static int[] dx = {1, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		board = new String[Y];
		vis = new int[Y][X];

		for (int i = 0; i < Y; i++) {
			board[i] = br.readLine();
		}

		search(0, 0);
		System.out.println(answer);

	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}

	static void search(int y, int x) {
		if (y == Y){
			answer = Math.min(answer, cnt);
			return;
		}

		if (x == X){
			search(y + 1, 0);
			return;
		}

		if (board[y].charAt(x) == '.'){
			search(y, x+1);
			return;
		}

		if (vis[y][x] > 0){
			search(y, x + 1);
			return;
		}

		for (int i = 0; i < 2; i++){
			int cy = y;
			int cx = x;

			while(true){
				vis[cy][cx]++;
				cy += dy[i];
				cx += dx[i];
				if (!isIn(cy, cx) || board[cy].charAt(cx) == '.') break;
			}

			cnt++;
			search(y, x + 1);
			cnt--;

			cx = x;
			cy = y;
			while (true) {
				vis[cy][cx]--;
				cx += dx[i];
				cy += dy[i];
				if (!isIn(cy, cx) || board[cy].charAt(cx) == '.') break;
			}
		}
	}
}