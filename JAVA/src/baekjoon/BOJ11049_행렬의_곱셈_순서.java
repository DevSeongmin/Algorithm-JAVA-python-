package baekjoon;

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

public class BOJ11049_행렬의_곱셈_순서 {

	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Matrix[] matrices = new Matrix[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			matrices[i] = new Matrix(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		}

		int[][] dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0 ; j < N; j++) {
				if (i != j) dp[i][j] = INF;
			}
		}


		for (int length = 1; length < N; length++){
			for (int start = 0; start + length < N; start++){
				for (int sepa = start; sepa < start + length; sepa++){
					dp[start][start + length] = Math.min(
						dp[start][start + length],
						dp[start][sepa] + dp[sepa + 1][start + length]
							+ matrices[start].y * matrices[sepa].x * matrices[start + length].x
					);
				}
			}
		}

		System.out.println(dp[0][N - 1]);
	}
}