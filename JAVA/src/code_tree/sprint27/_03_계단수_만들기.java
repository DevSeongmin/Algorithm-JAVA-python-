package code_tree.sprint27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _03_계단수_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int digit = Integer.parseInt(input[0]);
		long K = Integer.parseInt(input[1]);

		long[][] DP = new long[digit+1][10];

		for (int i= 1; i < 10; i++) {
			DP[1][i] = 1;
		}

		for (int i = 2; i <= digit; i++) {

			for (int j = 1; j < 10; j++) {
				for (int k = Math.max(1, j - 2); k <= Math.min(9, j + 2); k++){
					DP[i][j] += DP[i-1][k];
				}
			}
		}

		long total = 0;

		for (int i = 1; i < 10; i++) {
			total += DP[digit][i];
		}

		if (total < K) {
			System.out.println(-1);
			return;
		}

		int answer = 0;

		int left = 1;
		int right = 9;

		for (int i = digit; i >= 1; i--){

			for (int j = left; j <= right; j++) {
				if (K <= DP[i][j]){
					System.out.print(j);

					left = Math.max(1, j-2);
					right = Math.min(9, j+2);
					break;
				}

				K -= DP[i][j];
			}

		}
	}
}