package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_택배_마스터_광우 {
	public class Main {

		static boolean[] visited;
		static int[] arr, order;
		static int N, M, K;
		static int answer = Integer.MAX_VALUE;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N];
			order = new int[N];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[N];

			permu(0);
			System.out.println(answer);

		}
		static void permu(int depth){
			if (depth >= N) {
				answer = Math.min(answer, getWeight());
				return;
			}

			for (int i = 0; i < N; i++) {
				if (visited[i]) continue;

				visited[i] = true;
				order[depth] = arr[i];
				permu(depth+1);
				visited[i] = false;
			}
		}

		static int getWeight() {
			int weight = 0;
			int idx = 0;
			int count = 0;
			int checkWeight = 0;

			while(true) {
				if (checkWeight + order[idx] > M) {
					count++;
					if (count == K) return weight;
					checkWeight = order[idx];
				} else {
					checkWeight += order[idx];
				}

				weight += order[idx];
				idx = (idx+1) % N;
			}
		}
	}
}
