package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15483_최소_편집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.nextLine();
		String b = sc.nextLine();

		int l1 = a.length();
		int l2 = b.length();

		int[][] dp = new int[l1+1][l2+1];

		for (int i = 1; i <= l1; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i <= l2; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				int tmp1 = dp[i-1][j] + 1;
				int tmp2 = dp[i][j-1] + 1;
				int tmp3 = dp[i-1][j-1] + (a.charAt(i-1) == b.charAt(j-1) ? 0 : 1);
				dp[i][j] = Math.min(Math.min(tmp1, tmp2), tmp3);
			}
		}

		System.out.println(dp[l1][l2]);
	}
}
