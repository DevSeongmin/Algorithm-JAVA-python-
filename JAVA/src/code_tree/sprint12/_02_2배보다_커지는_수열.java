package code_tree.sprint12;

import java.util.Arrays;
import java.util.Scanner;

public class _02_2배보다_커지는_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] dp = new int[n+1][m+1];
		Arrays.fill(dp[1], 1);

		for (int i = 1; i <n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = j * 2; k <= m; k++) {
					dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % 1_000_000_007;
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= m; i++) {
			answer = (answer + dp[n][i]) % 1_000_000_007;
		}

		System.out.println(answer);

	}
}
