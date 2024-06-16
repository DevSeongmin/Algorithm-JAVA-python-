package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12869_뮤탈리스크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] attacks = {9, 3, 1};
		int[][] sequence = new int[6][3];

		int cnt = 0;
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				for (int c = 0; c < 3; c++) {
					if (a == b || b == c || a == c)
						continue;
					sequence[cnt][0] = a;
					sequence[cnt][1] = b;
					sequence[cnt][2] = c;
					cnt++;
				}
			}
		}

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Scvs scvs = new Scvs();

		for (int i = 0; i < N; i++) {
			scvs.c = scvs.b;
			scvs.b = scvs.a;
			scvs.a = Integer.parseInt(st.nextToken());
		}

		Queue<Scvs> q = new LinkedList<>();
		HashSet<Scvs> visited = new HashSet<>();

		visited.add(scvs);
		q.add(scvs);

		int attackCount = 0;
		while (!q.isEmpty()) {
			int iterate = q.size();

			for (int i = 0; i < iterate; i++) {
				Scvs curScvs = q.poll();
				if (curScvs.getSum() == 0) {
					System.out.println(attackCount);
					return;
				}

				for (int j = 0; j < 6; j++) {
					int nextA = curScvs.a - attacks[sequence[j][0]];
					int nextB = curScvs.b - attacks[sequence[j][1]];
					int nextC = curScvs.c - attacks[sequence[j][2]];

					Scvs newScvs = new Scvs(nextA, nextB, nextC);

					if (!visited.contains(newScvs)) {
						q.add(newScvs);
						visited.add(newScvs);
					}
				}
			}
			attackCount++;
		}

	}

	static class Scvs {

		int a, b, c;

		public Scvs() {
		}
		
		public Scvs(int a, int b, int c) {
			this.a = Math.max(a, 0);
			this.b = Math.max(b, 0);
			this.c = Math.max(c, 0);
		}

		int getSum() {
			return a + b + c;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Scvs scvs = (Scvs)o;
			return a == scvs.a && b == scvs.b && c == scvs.c;
		}

		@Override
		public int hashCode() {
			return Objects.hash(a, b, c);
		}
	}
}
