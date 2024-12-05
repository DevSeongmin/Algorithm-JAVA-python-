package code_tree.sprint28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _02_거스름돈_계산하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		int[] coins = new int[N];
		int totalCnt = 0;

		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int coin = Integer.parseInt(input[0]);
			int cnt = Integer.parseInt(input[1]);

			totalCnt += cnt;
			coins[i] = coin;
			K -= coin * cnt;
		}

		int[] DP = new int[K + 1];
		Arrays.fill(DP, Integer.MAX_VALUE);
		DP[0] = 0;

		for (int i = 1; i <= K; i++) {

			for (int c : coins) {
				if (i - c < 0)
					continue;
				if (DP[i - c] == Integer.MAX_VALUE)
					continue;

				DP[i] = Math.min(DP[i], DP[i - c] + 1);
			}
		}
		if (DP[K] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(DP[K] + totalCnt);
	}
}
