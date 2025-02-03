package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2533_사회망_서비스 {
	static int N;
	static int[][] dp;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		dp = new int[2][N+1];
		visited = new boolean[N+1];

		dfs(1);

		System.out.println(Math.min(dp[1][1], dp[0][1]));

	}

	private static void dfs(int node) {
		dp[0][node] = 0;
		dp[1][node] = 1;
		visited[node] = true;

		for (int next : tree[node]) {
			if (visited[next]) continue;

			dfs(next);

			dp[0][node] += dp[1][next];
			dp[1][node] += Math.min(dp[0][next], dp[1][next]);
		}
	}

}