package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_성적평균 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());


			int[] arr = new int[N];


			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] prefixSum = new int[N+1];

			for (int i = 1; i <= N; i++) {
				prefixSum[i] = prefixSum[i-1] + arr[i-1];
			}

			for (int i = 0; i < Q; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				double val = prefixSum[e] - prefixSum[s-1];
				val /= (e-s+1);
				System.out.println(String.format("%.2f", val));
			}
		}
	}

}
