package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Lv3_강의실_배정 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			PriorityQueue<Lesson> pq = new PriorityQueue(new Comparator<Lesson>(){
				@Override
				public int compare(Lesson a, Lesson b) {
					return a.e == b.e ? Integer.compare(a.s, b.s) : Integer.compare(a.e, b.e);
				}
			});

			int N = Integer.parseInt(br.readLine());


			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				pq.add(new Lesson(s, e));
			}

			int curTime = -1;

			int answer = 0;
			while(!pq.isEmpty()) {
				Lesson lesson = pq.poll();

				if (lesson.s >= curTime) {
					answer++;
					curTime = lesson.e;
				}
			}
			System.out.println(answer);
		}

		static class Lesson{
			int s, e;

			public Lesson(int s, int e) {
				this.s = s;
				this.e = e;
			}
		}
	}
}
