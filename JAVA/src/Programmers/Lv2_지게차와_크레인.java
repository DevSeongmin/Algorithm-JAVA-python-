package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_지게차와_크레인 {

	class Solution {

		static int Y, X;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};

		public int solution(String[] storage, String[] requests) {
			Y = storage.length;
			X = storage[0].length();

			char[][] map = new char[Y][X];

			for (int i = 0; i < Y; i++) {
				map[i] = storage[i].toCharArray();
			}


			for (String request : requests) {
				if (request.length() == 1) {
					map = lift(map, request.charAt(0));
				} else {
					crane(map, request.charAt(0));
				}
			}

			int answer = 0;
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (map[i][j] != '-') answer++;
				}
			}

			return answer;
		}

		static char[][] lift(char[][] map, char alpha) {

			char[][] tmpMap = new char[Y][X];

			for (int i = 0; i < Y; i++) {
				tmpMap[i] = Arrays.copyOf(map[i], X);
			}

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {

					if (map[i][j] != alpha) continue;

					if (canMove(map, i, j)) {
						tmpMap[i][j] = '-';
					}
				}
			}
			return tmpMap;
		}


		static boolean canMove(char[][] map, int y, int x) {

			boolean[][] visited = new boolean[Y][X];
			visited[y][x] = true;

			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {y, x});

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				if (cur[0] == 0 || cur[0] == Y-1 || cur[1] == 0 || cur[1] == X-1) return true;

				for (int i = 0; i < 4; i++) {
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];

					if (!isIn(ny, nx)) continue;
					if (visited[ny][nx]) continue;
					if (map[ny][nx] != '-') continue;

					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});
				}
			}

			return false;
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}

		static void crane(char[][] map, char alpha) {
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (map[i][j] == alpha) {
						map[i][j] = '-';
					}
				}
			}
		}
	}
}
