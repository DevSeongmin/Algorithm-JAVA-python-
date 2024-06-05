package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_BestCahnce {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] values = new int[N];
		int[] prices = new int[N];
		int[] opportunity = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(st.nextToken());
		}

		int maxIndex = 0;
		int val = values[0];

		for (int i = 1; i < N; i++) {
			if (val < values[i]) {
				val = values[i];
				maxIndex = i;
			}
		}

		int secondIndex = -1;
		val = -1;

		for (int i = 0; i < N; i++) {
			if (i == maxIndex)
				continue;
			if (val < values[i]) {
				val = values[i];
				secondIndex = i;
			}
		}

		for (int i = 0; i < N; i++) {
			if (i != maxIndex) {

				opportunity[i] = values[maxIndex] - prices[i];

			} else {
				opportunity[i] = values[secondIndex] - prices[i];
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(values[i] - opportunity[i] - prices[i] + " ");
		}

	}

}
