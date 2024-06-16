package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21758_꿀따기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] honeys = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			honeys[i] = Integer.parseInt(st.nextToken());
		}

		long[] prefix = new long[N + 1];

		for (int i = 0; i < N; i++) {
			prefix[i + 1] = prefix[i] + honeys[i];
		}

		long[] reversePrefix = new long[N + 1];

		for (int i = N - 1; i >= 0; i--) {
			reversePrefix[i] = reversePrefix[i + 1] + honeys[i];
		}

		long answer = 0;

		// 	case 1 꿀통 맨 오른쪽 고정 1번 벌 맨 왼쪽 고정
		for (int bee = 1; bee < N - 1; bee++) {
			long honey = prefix[bee] - prefix[1] + (prefix[N] - prefix[bee + 1]) * 2;
			answer = Math.max(answer, honey);
		}

		// case 2 꿀통 맨 왼쪽 고정 1번 벌 맨 오른쪽 고정
		for (int bee = 1; bee < N - 1; bee++) {
			long honey = reversePrefix[bee + 1] - reversePrefix[N - 1] + (reversePrefix[0] - reversePrefix[bee]) * 2;
			answer = Math.max(answer, honey);
		}

		// 벌 양 끝쪽에 배치
		for (int honeyPot = 1; honeyPot < N - 1; honeyPot++) {
			long honey = prefix[N] + honeys[honeyPot] - honeys[0] - honeys[N - 1];
			answer = Math.max(answer, honey);
		}

		System.out.println(answer);

	}
}
