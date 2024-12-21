package code_tree.sprint4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _01_정수_이어부티기 {

	static int N, K;
	static String[] input;
	static Set<String> set;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new String[N];

		for (int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}

		set = new HashSet();
		visited = new boolean[N];

		permu(0, "");

		System.out.println(set.size());
	}

	static void permu(int depth, String value){
		if (depth == K) {
			set.add(value);
			return;
		}

		for (int i = 0; i < N; i++) {

			if (visited[i]) continue;

			visited[i] = true;
			permu(depth+1, value + input[i]);
			visited[i] = false;
		}
	}
}