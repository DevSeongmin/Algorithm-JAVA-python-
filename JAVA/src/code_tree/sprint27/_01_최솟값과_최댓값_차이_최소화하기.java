package code_tree.sprint27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _01_최솟값과_최댓값_차이_최소화하기 {
	static int N;
	static int[][] BOARD;
	static int answer = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		BOARD = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++){
				BOARD[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recursion(0, Integer.MAX_VALUE, 0);

		System.out.println(answer);

	}
	static void recursion(int depth, int min, int max){
		if (depth == N) {
			answer = Math.min(answer, max - min);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;

			visited[i] = true;
			recursion(depth+1,
				Math.min(min, BOARD[depth][i]),
				Math.max(max, BOARD[depth][i]));

			visited[i] = false;
		}
	}
}