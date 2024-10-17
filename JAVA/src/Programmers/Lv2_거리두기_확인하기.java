package Programmers;

public class Lv2_거리두기_확인하기 {

	class Solution {
		public int[] solution(String[][] places) {
			int[] answer = new int[5];

			int answerIdx = 0;
			for (String[] place : places) {
				answer[answerIdx++] = check(place);
			}

			return answer;
		}

		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};

		static boolean isIn(int y, int x) {
			return 0 <= y && y < 5 && 0 <= x && x < 5;
		}

		public int check(String[] place) {

			char[][] placeArr = new char[5][5];

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					placeArr[i][j] = place[i].charAt(j);
				}
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {

					if (placeArr[i][j] == 'O') {

						int pCount = 0;

						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];

							if (isIn(ny, nx) && placeArr[ny][nx] == 'P' && ++pCount >= 2) {
								return 0;
							}
						}
					}

					if (placeArr[i][j] == 'P') {
						for (int d = 0; d < 4; d++) {
							int ny = i + dy[d];
							int nx = j + dx[d];

							if (isIn(ny, nx) && placeArr[ny][nx] == 'P') {
								return 0;
							}
						}
					}
				}
			}
			return 1;
		}
	}

}
