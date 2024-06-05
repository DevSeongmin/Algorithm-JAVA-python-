package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503_로봇청소기 {
	static int[] moveY = {-1, 0, 1, 0};
	static int[] moveX = {0, 1, 0, -1};

	static int[][] room;
	static int Y, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		room = new int[Y][X];
		st = new StringTokenizer(br.readLine());

		Robot robot = new Robot(Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()));

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(robot.simulation());

	}

	static boolean isIn(int y, int x) {
		return 0 <= x && x < X && 0 <= y && y < Y;
	}

	static class Robot {
		int y, x, dir;
		int cnt;

		public Robot(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
			cnt = 0;
		}

		private void clean() {
			if (room[y][x] == 0) {
				room[y][x] = 2;
				cnt++;
			}
		}

		private void turnLeft() {
			dir = (dir + 3) % 4;
		}

		private boolean check() {
			for (int i = 0; i < 4; i++) {
				int ny = y + moveY[i];
				int nx = x + moveX[i];

				if (isIn(ny, nx) && room[ny][nx] == 0) {
					return false;
				}
			}
			return true;
		}

		private int simulation() {

			while (true) {
				clean();

				if (check()) {
					int ny = y - moveY[dir];
					int nx = x - moveX[dir];

					if (room[ny][nx] == 1) {
						return cnt;
					} else {
						y = ny;
						x = nx;
					}
				} else {
					turnLeft();
					int ny = y + moveY[dir];
					int nx = x + moveX[dir];

					if (isIn(ny, nx) && room[ny][nx] == 0) {
						y = ny;
						x = nx;
					}
				}
			}

		}

	}
}
