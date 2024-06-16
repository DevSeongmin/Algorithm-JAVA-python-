package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class BOJ1082_방번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			return;
		}

		int[] values = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

		int money = Integer.parseInt(br.readLine());

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		int check = Integer.MAX_VALUE;

		int minCostKey = -1;
		int noZeroMinCostKey = -1;
		for (int i = N - 1; i >= 0; i--) {
			if (check > values[i]) {
				map.put(i, values[i]);
				minCostKey = i;
				if (i != 0) {
					noZeroMinCostKey = i;
				}
				check = values[i];
			}
		}

		StringBuilder answer = new StringBuilder();

		if (money >= map.get(noZeroMinCostKey)) {
			answer.append(noZeroMinCostKey);
			money -= map.get(noZeroMinCostKey);
		} else {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < money / map.get(minCostKey); i++) {
			answer.append(minCostKey);
		}
		money %= map.get(minCostKey);

		for (int i = 0; i < answer.length(); i++) {
			for (Integer integer : map.keySet()) {
				if (integer <= answer.charAt(i) - '0') {
					break;
				}

				if (map.get(integer) - map.get(answer.charAt(i) - '0') <= money) {
					money -= map.get(integer) - map.get(answer.charAt(i) - '0');
					answer.setCharAt(i, (char)(integer + '0'));
					break;
				}
			}
		}
		System.out.println(answer);

	}
}
