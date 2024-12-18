package code_tree.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _04_숫자_크기_비교 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList();
		}

		int[] indeg = new int[N+1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			graph[s].add(e);
			indeg[e]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) {
				pq.add(i);
			}
		}

		while (!pq.isEmpty()) {
			int v = pq.poll();
			System.out.print(v + " ");

			for (int nv : graph[v]) {

				if (--indeg[nv] == 0) {
					pq.add(nv);
				}
			}
		}
	}
}