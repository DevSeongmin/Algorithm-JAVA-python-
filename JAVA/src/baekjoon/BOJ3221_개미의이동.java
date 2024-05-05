package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ3221_개미의이동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int L = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> ant = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = st.nextToken().equals("L") ? -1 : 1;
			int r = x + d * T;
			r %= 2 * L;
			if (r < 0)
				r += 2 * L;
			if (r > L)
				r = 2 * L - r;
			ant.add(r);
		}

		ant.sort(null);
		for (Integer i : ant) {
			System.out.print(i + " ");
		}
	}
}
