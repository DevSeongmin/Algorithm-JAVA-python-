package code_tree.sprint12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _03_코드트리_사내_메신저 {
	static int N;
	static int[] dp;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dp = new int[N+1];

		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken(); // Sam의 상사 정보는 무시

		for (int i = 2; i <= N; i++) {
			int manager = Integer.parseInt(st.nextToken());
			graph[manager].add(i);
		}

		dfs(1);
		System.out.println(dp[1]);
	}

	static void dfs(int current) {
		visited[current] = true;
		ArrayList<Integer> childrenTimes = new ArrayList<>();

		for (int next : graph[current]) {
			if (!visited[next]) {
				dfs(next);
				childrenTimes.add(-dp[next]);
			}
		}

		Collections.sort(childrenTimes);

		for (int i = 0; i < childrenTimes.size(); i++) {
			dp[current] = Math.max(dp[current], -childrenTimes.get(i) + i + 1);
		}
	}
}
