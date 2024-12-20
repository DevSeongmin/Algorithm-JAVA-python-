package code_tree.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _02_건물_최소개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] buildings = new int[N][2];

		Set<Integer> heights = new HashSet();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			heights.add(y);

			buildings[i][0] = x;
			buildings[i][1] = y;
		}

		int answer = 0;

		for (int h : heights) {
			if (h ==0) continue;

			int cnt = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (!flag && buildings[i][1] == h) {
					flag = true;
					cnt++;
				}

				if (flag && buildings[i][1] < h){
					flag = false;
				}
			}
			answer+=cnt;
		}
		System.out.println(answer);

	}
}