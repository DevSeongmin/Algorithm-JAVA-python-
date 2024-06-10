package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1484_다이어트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long G = Integer.parseInt(br.readLine());

		int left = 1;
		int right = 1;
		boolean flag = false;

		while (left <= right && right <= G) {

			long standard = (long)right * right - (long)left * left;

			if (standard == G) {
				flag = true;
				System.out.println(right);
				right++;
			} else if (standard < G) {
				right++;
			} else {
				left++;
			}
		}

		if (!flag) {
			System.out.println(-1);
		}

	}
}
