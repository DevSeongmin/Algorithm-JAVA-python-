package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ5549_행성탐사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int Y = Integer.parseInt(input[0]);
		int X = Integer.parseInt(input[1]);
		int T = Integer.parseInt(br.readLine());

		char[][] planet = new char[Y][X];

		for (int i = 0; i < Y; i++) {
			String line = br.readLine();
			for (int j = 0; j < X; j++) {
				planet[i][j] = line.charAt(j);
			}
		}

		HashMap<Character, Integer>[][] prefix = new HashMap[Y + 1][X + 1];

		for (int i = 0; i < Y + 1; i++) {
			for (int j = 0; j < X + 1; j++) {
				prefix[i][j] = new HashMap();
				prefix[i][j].put('J', 0);
				prefix[i][j].put('I', 0);
				prefix[i][j].put('O', 0);

			}
		}

		char[] element = {'J', 'O', 'I'};

		for (int i = 1; i < Y + 1; i++) {
			for (int j = 1; j < X + 1; j++) {
				prefix[i][j].put(planet[i - 1][j - 1], prefix[i][j].get(planet[i - 1][j - 1]) + 1);

				for (char e : element) {
					int up = prefix[i - 1][j].get(e);
					int left = prefix[i][j - 1].get(e);
					int upLeft = prefix[i - 1][j - 1].get(e);
					int result = up + left - upLeft;
					prefix[i][j].put(e, prefix[i][j].get(e) + result);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			for (char e : element) {
				sb.append(
					prefix[y2][x2].get(e) + prefix[y1 - 1][x1 - 1].get(e) - prefix[y2][x1 - 1].get(e) - prefix[y1
						- 1][x2].get(e) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
