package code_tree.sprint23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _02_특이한_LIS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		int[] arr = new int[N];

		for (int i= 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int[] dp = new int[N];
		int[] check = new int[N];

		Arrays.fill(dp, 1);
		Arrays.fill(check, 1);

		for (int i = 1; i < N; i++) {

			for (int j = i-1; j >= 0; j--) {
				if (arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}

				if (arr[i] == arr[j]){
					if (check[j] + 1 > K) continue;

					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						check[i] = check[j] + 1;
					}
				}

			}
		}


		int answer = 0 ;
		for (int i= 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}
}