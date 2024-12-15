package code_tree.sprint30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _02_거스름돈_계산하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		ArrayList<Integer> coins = new ArrayList();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int coin = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());

			for (int j = 0; j < cnt; j++) {
				coins.add(coin);
			}
		}

		int[] dp = new int[target + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < coins.size(); i++) {
			for (int j = target; j >= coins.get(i); j--){
				if (dp[j-coins.get(i)] != Integer.MAX_VALUE){
					dp[j] = Math.min(dp[j], dp[j - coins.get(i)] + 1);
				}
			}
		}

		System.out.println(dp[target] == Integer.MAX_VALUE ? -1 : dp[target]);
	}
}

