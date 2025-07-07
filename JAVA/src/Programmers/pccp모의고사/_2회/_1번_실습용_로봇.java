package Programmers.pccp모의고사._2회;

public class _1번_실습용_로봇 {
	class Solution {

		public int[] solution(String command) {
			int[] answer = {};

			Rocket rocket = new Rocket(0, 0, 0);

			for (char c : command.toCharArray()) {
				if (c == 'R') {
					rocket.turnRight();
				} else if (c == 'L') {
					rocket.turnLeft();
				} else if (c == 'G') {
					rocket.go();
				} else if (c == 'B') {
					rocket.back();
				}
			}

			return new int[] {rocket.x, rocket.y};
		}
	}

	class Rocket{
		int y;
		int x;
		int dir;
		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, 1, 0, -1};

		public Rocket(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		public void turnRight() {
			dir++;
			if (dir == 4) {
				dir = 0;
			}
		}

		public void turnLeft() {
			dir--;
			if (dir==-1) {
				dir = 3;
			}
		}

		public void go() {
			this.y += dy[this.dir];
			this.x += dx[this.dir];
		}

		public void back() {
			this.y -= dy[this.dir];
			this.x -= dx[this.dir];
		}
	}
}
