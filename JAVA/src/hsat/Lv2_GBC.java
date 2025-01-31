package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv2_GBC {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] first = new int[101];
			int[] second = new int[101];

			int idx = 1;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int length = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				for (int j = 0; j < length; j++) {
					first[idx++] = value;
				}
			}

			idx = 1;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int length = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());

				for (int j = 0; j < length; j++) {
					second[idx++] = value;
				}
			}

			int answer = 0;
			for (int i = 1; i <= 100; i++) {
				answer = Math.max(answer, second[i] - first[i]);
			}

			System.out.println(answer);
		}
	}
}
