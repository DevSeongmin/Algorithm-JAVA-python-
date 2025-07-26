package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15824_너_봄에는_캡사이신이_맛있다 {

	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);

		long[] pow2 = new long[N];
		pow2[0] = 1;

		for (int i = 1; i < N; i++) {
			pow2[i] = (pow2[i - 1] * 2) % MOD;
		}

		long answer = 0;
		for (int i = 0; i < N; i++) {
			long maxCnt = pow2[i];
			long minCnt = pow2[N-i-1];

			answer = (answer + ((maxCnt - minCnt + MOD) % MOD) * arr[i]) % MOD;
		}

		System.out.println(answer);
	}
}
