package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1052_물병 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);

		if (count1(n) <= k) {
			System.out.println(0);
			return;
		}

		for (int i = 30; i >= 0; i--) {

			if (k == 0) {
				System.out.println((1 << i + 1) - n);
				return;
			}

			if ((1 << i & n) > 0) {
				n -= 1 << i;
				k--;
			}
		}

		System.out.println(0);
	}

	private static int count1(int n) {
		int count = 0;

		for (int i = 30; i >= 0; i--) {

			if ((1 << i & n) > 0) {
				count++;
			}
		}
		return count;
	}
}
