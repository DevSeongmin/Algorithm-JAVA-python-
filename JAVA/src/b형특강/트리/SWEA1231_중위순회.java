package b형특강.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1231_중위순회 {

	static char[] tree;
	static int N;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		// stringbuildr로 한번에 출력하도록해줘

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			N = Integer.parseInt(br.readLine());
			tree = new char[N + 1];

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int r = Integer.parseInt(st.nextToken());
				String s = st.nextToken();

				tree[r] = s.charAt(0);
			}

			sb.append("#" + tc + " ");
			order(1);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void order(int idx) {
		if (idx > N)
			return;

		order(idx * 2);

		sb.append(tree[idx]);

		order(idx * 2 + 1);
	}

}
