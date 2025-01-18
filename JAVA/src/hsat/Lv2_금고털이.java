package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Lv2_금고털이 {

	public class Main {

		public static void main(String[] args) throws IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());


			PriorityQueue<Thing> pq = new PriorityQueue<>(new Comparator<Thing>(){
				@Override
				public int compare(Thing a, Thing b) {
					return Integer.compare(b.v, a.v);
				}
			});

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int w = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				pq.add(new Thing(w, v));
			}



			int answer = 0;

			while (!pq.isEmpty()) {
				Thing thing = pq.poll();

				if (thing.w <= N) {
					answer += thing.w * thing.v;
					N -= thing.w;
				} else {
					answer += N * thing.v;
					break;
				}
			}

			System.out.println(answer);

		}
	}
}

class Thing{
	int w;
	int v;
	public Thing(int w, int v) {
		this.w = w;
		this.v = v;

	}
}
