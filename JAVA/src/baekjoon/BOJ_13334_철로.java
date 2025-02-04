package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13334_철로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int s = Math.min(a,b);
			int e = Math.max(a,b);

			lines[i] = new Line(s, e);
		}

		int d = Integer.parseInt(br.readLine());

		Arrays.sort(lines, new Comparator<Line>(){
			@Override
			public int compare(Line o1, Line o2) {
				return Integer.compare(o1.e, o2.e);
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int answer = 0;
		for (int i = 0; i < N; i++) {
			pq.add(lines[i].s);
			while (!pq.isEmpty() && pq.peek() < lines[i].e - d) pq.poll();
			answer = Math.max(answer, pq.size());
		}

		System.out.println(answer);
	}

	static class Line{
		int s, e;

		public Line(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
