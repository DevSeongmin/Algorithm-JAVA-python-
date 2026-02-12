package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ21940_가운데에서_만나기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	final static int INF = 200 * 200 * 200;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(graph[i], INF);
		}


		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			graph[s][e] = t;
		}

		int friendCount = Integer.parseInt(br.readLine());
		List<Integer> friendList = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < friendCount; i++) {
			friendList.add(Integer.parseInt(st.nextToken()));
		}

		for (int t = 1; t <= N; t++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					graph[s][e] = Math.min(graph[s][e], graph[s][t] + graph[t][e]);
				}
			}
		}

		int answerVal = Integer.MAX_VALUE;
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			for (Integer friend : friendList) {
				if (i == friend) {
					tmp = Math.max(tmp, graph[friend][i]);
				} else {
					tmp = Math.max(tmp, graph[friend][i] + graph[i][friend]);
				}
			}
			if (tmp <= answerVal) {
				answerVal = tmp;

				if (map.get(tmp) == null) {
					map.put(tmp, new ArrayList<>());
				}

				map.get(tmp).add(i);
			}
		}

		System.out.println(map.get(answerVal).toString().replace("[", "").replace("]", "").replace(",", ""));
	}
}
