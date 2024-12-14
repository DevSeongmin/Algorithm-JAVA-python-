package code_tree.sprint29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Matrix{
	int y, x;

	public Matrix(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class _03_행렬_곱셈_순서 {

	static int[][] dp;
	static Matrix[] matrices;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		matrices = new Matrix[N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			matrices[i] = new Matrix(y, x);
		}

		System.out.println(solve(0, N-1));
	}

	static int solve(int start, int end) {
		if (start == end) return 0;
		if (dp[start][end] != 0) return dp[start][end];

		dp[start][end] = Integer.MAX_VALUE;

		for (int i = start; i < end; i++) {
			int cost = solve(start, i) + solve(i+1, end)
				+ matrices[start].y * matrices[i].x * matrices[end].x;
			dp[start][end] = Math.min(dp[start][end], cost);
		}
		return dp[start][end];
	}
}