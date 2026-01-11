package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19637_IF문좀대신써줘 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] powers = new int[a];
		String[] names = new String[a];

		for (int i = 0; i < a; i++) {
			st = new StringTokenizer(br.readLine());
			names[i] = st.nextToken();
			powers[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b; i++) {
			int power = Integer.parseInt(br.readLine());

			sb.append(setName(powers, names, power)).append("\n");
		}

		System.out.println(sb);
	}

	private static String setName(int[] powers, String[] names, int power) {
		int left = 0;
		int right = powers.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (power <= powers[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return names[left];
	}
}
