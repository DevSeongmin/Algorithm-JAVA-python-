package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lv2_나무_공격 {

	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int Y = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());

			Queue<Integer>[] arrs = new LinkedList[Y];

			for (int i = 0; i < Y; i++) {
				arrs[i] = new LinkedList();
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < X; j++) {
					int val = Integer.parseInt(st.nextToken());

					if (val == 1) arrs[i].add(1);
				}
			}

			for (int i =0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				for (int j = s - 1; j < e; j++) {
					if (!arrs[j].isEmpty()) {
						arrs[j].poll();
					}
				}
			}

			int answer = 0;
			for (int i = 0; i < Y; i++) {
				answer += arrs[i].size();
			}
			System.out.println(answer);
		}
	}
}
