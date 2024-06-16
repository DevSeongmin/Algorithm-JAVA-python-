package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ20208_진우의민트초코우유 {
	static int initHP;
	static int plusHP;
	static ArrayList<Point> minchos = new ArrayList<>();
	static int minchoCount;
	static ArrayList<Point> sequence = new ArrayList<>();
	static boolean[] visited;
	static Point jinu = null;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		initHP = Integer.parseInt(st.nextToken());
		plusHP = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 1) {
					jinu = new Point(i, j);
				}
				if (value == 2) {
					minchos.add(new Point(i, j));
				}
			}
		}

		minchoCount = minchos.size();
		if (minchoCount == 0) {
			System.out.println(0);
			return;
		}
		visited = new boolean[minchoCount];
		recursion(0);
		System.out.println(answer);
	}

	static void recursion(int cnt) {
		if (cnt == minchoCount) {
			check();
		}

		for (int i = 0; i < minchoCount; i++) {
			if (!visited[i]) {
				sequence.add(minchos.get(i));
				visited[i] = true;
				cnt++;
				recursion(cnt);
				cnt--;
				sequence.remove(sequence.size() - 1);
				visited[i] = false;
			}
		}
	}

	static void check() {
		int HP = initHP;

		// 첫번째 민초 우유까지 갈 수 있는지
		HP -= getManhattan(jinu.y, jinu.x, sequence.get(0).y, sequence.get(0).x);

		// 없다면 리턴
		if (HP < 0) {
			return;
		}

		HP += plusHP;

		for (int i = 0; i < minchoCount - 1; i++) {
			// 현재 민초 우유 위치에서 다시 집으로 갈 수 있는지
			if (HP >= getManhattan(sequence.get(i).y, sequence.get(i).x, jinu.y, jinu.x)) {
				answer = Math.max(answer, i + 1);
			}

			// 현재 민초에서 다음 민초 우유로 이동할 수 있는지
			int nextDist = getManhattan(sequence.get(i).y, sequence.get(i).x, sequence.get(i + 1).y,
				sequence.get(i + 1).x);
			if (HP >= nextDist) {
				HP = HP - nextDist + plusHP;
			} else {
				return;
			}
		}

		if (HP >= getManhattan(sequence.get(minchoCount - 1).y, sequence.get(minchoCount - 1).x, jinu.y,
			jinu.x)) {
			answer = Math.max(answer, minchoCount);
		}
	}

	static int getManhattan(int y1, int x1, int y2, int x2) {
		return Math.abs(y2 - y1) + Math.abs(x2 - x1);
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
