package baekjoon;

import java.util.Scanner;

public class BOJ9251_LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int l1 = s1.length();
		int l2 = s2.length();

		int[][] dp = new int[l1 + 1][l2 + 1];

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		System.out.println(dp[l1][l2]);
	}
}
