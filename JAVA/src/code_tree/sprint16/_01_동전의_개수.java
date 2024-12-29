package code_tree.sprint16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _01_동전의_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);

		int answer = 0;
		for (int i = N-1; i >= 0; i--) {
			answer += money / coins[i];
			money %= coins[i];

			if (money == 0) {
				break;
			}
		}
		System.out.println(answer);
	}
}