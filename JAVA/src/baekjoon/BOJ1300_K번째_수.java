package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1300_K번째_수 {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int low = 1;
		int high = K;

		while(low <= high) {
			int mid = (low + high) / 2;

			int cnt = getCnt(mid);

			if (cnt >= K) {
				high = mid - 1;
			}
			 else if (cnt < K) {
				low = mid + 1;
			}
		}

		System.out.println(low);

	}
	static int getCnt(int mid) {
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			cnt += Math.min(mid / i, N);
		}

		return cnt;
	}
}
