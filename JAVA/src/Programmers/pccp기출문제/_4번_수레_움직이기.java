package Programmers.pccp기출문제;

public class _4번_수레_움직이기 {
	class Solution {

		static int Y, X;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};
		static int answer = Integer.MAX_VALUE;

		public int solution(int[][] maze) {
			Y = maze.length;
			X = maze[0].length;

			Node redStart = null;
			Node blueStart = null;

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					if (maze[i][j] == 1) {
						redStart = new Node(i, j);
					}
					if (maze[i][j] == 2) {
						blueStart = new Node(i, j);
					}
				}
			}

			boolean[][] redVisited = new boolean[Y][X];
			redVisited[redStart.y][redStart.x] = true;

			boolean[][] blueVisited = new boolean[Y][X];
			blueVisited[blueStart.y][blueStart.x] = true;


			dfsRedFirst(redStart, blueStart, redVisited, blueVisited,
				false, false, maze, 0);

			dfsBlueFirst(redStart, blueStart, redVisited, blueVisited,
				false, false, maze, 0);

			return answer == Integer.MAX_VALUE ? 0 : answer;
		}

		void dfsRedFirst(Node red, Node blue,
			boolean[][] redVisited, boolean[][] blueVisited,
			boolean redFinished, boolean blueFinished,
			int[][] maze, int depth) {

			if (redFinished && blueFinished) {
				answer = Math.min(answer, depth);
				return;
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					int redNextY = red.y + dy[i];
					int redNextX = red.x + dx[i];
					int blueNextY = blue.y + dy[j];
					int blueNextX = blue.x + dx[j];

					if (!redFinished && blueFinished) {
						if (blue.y == redNextY && blue.x == redNextX) continue;
						if (!isIn(redNextY, redNextX)) continue;
						if (maze[redNextY][redNextX] == 5) continue;
						if (redVisited[redNextY][redNextX]) continue;

						boolean redFlag = false;

						if (maze[redNextY][redNextX] == 3) redFlag = true;

						redVisited[redNextY][redNextX] = true;

						dfsRedFirst(new Node(redNextY, redNextX), blue, redVisited, blueVisited,
							redFlag, blueFinished, maze, depth+1);

						redVisited[redNextY][redNextX] = false;

					} else if (redFinished && !blueFinished) {
						if(blueNextY == red.y && blueNextX == red.x) continue;
						if (!isIn(blueNextY, blueNextX)) continue;
						if (blueVisited[blueNextY][blueNextX]) continue;
						if (maze[blueNextY][blueNextX] == 5) continue;

						boolean blueFlag = false;

						if (maze[blueNextY][blueNextX] == 4) blueFlag = true;

						blueVisited[blueNextY][blueNextX] = true;

						dfsRedFirst(red, new Node(blueNextY, blueNextX), redVisited, blueVisited,
							redFinished, blueFlag, maze, depth+1);

						blueVisited[blueNextY][blueNextX] = false;


					} else if (!redFinished && !blueFinished) {
						if (redNextY == blue.y && redNextX == blue.x) continue;
						if (blueNextY == redNextY && blueNextX == redNextX) continue;
						if (!isIn(redNextY, redNextX)) continue;
						if (!isIn(blueNextY, blueNextX)) continue;
						if (redVisited[redNextY][redNextX]) continue;
						if (blueVisited[blueNextY][blueNextX]) continue;
						if (maze[redNextY][redNextX] == 5) continue;
						if (maze[blueNextY][blueNextX] == 5) continue;

						boolean redFlag = false;
						boolean blueFlag = false;

						if (maze[redNextY][redNextX] == 3) redFlag = true;
						if (maze[blueNextY][blueNextX] == 4) blueFlag = true;

						redVisited[redNextY][redNextX] = true;
						blueVisited[blueNextY][blueNextX] = true;

						dfsRedFirst(new Node(redNextY, redNextX), new Node(blueNextY, blueNextX),
							redVisited, blueVisited, redFlag, blueFlag, maze, depth+1);

						redVisited[redNextY][redNextX] = false;
						blueVisited[blueNextY][blueNextX] = false;
					}
				}
			}
		}

		void dfsBlueFirst(Node red, Node blue,
			boolean[][] redVisited, boolean[][] blueVisited,
			boolean redFinished, boolean blueFinished,
			int[][] maze, int depth) {

			if (redFinished && blueFinished) {
				answer = Math.min(answer, depth);
				return;
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					int redNextY = red.y + dy[i];
					int redNextX = red.x + dx[i];
					int blueNextY = blue.y + dy[j];
					int blueNextX = blue.x + dx[j];

					if (!redFinished && blueFinished) {
						if (blue.y == redNextY && blue.x == redNextX) continue;
						if (!isIn(redNextY, redNextX)) continue;
						if (maze[redNextY][redNextX] == 5) continue;
						if (redVisited[redNextY][redNextX]) continue;

						boolean redFlag = false;

						if (maze[redNextY][redNextX] == 3) redFlag = true;

						redVisited[redNextY][redNextX] = true;

						dfsBlueFirst(new Node(redNextY, redNextX), blue, redVisited, blueVisited,
							redFlag, blueFinished, maze, depth+1);

						redVisited[redNextY][redNextX] = false;

					} else if (redFinished && !blueFinished) {
						if(blueNextY == red.y && blueNextX == red.x) continue;
						if (!isIn(blueNextY, blueNextX)) continue;
						if (blueVisited[blueNextY][blueNextX]) continue;
						if (maze[blueNextY][blueNextX] == 5) continue;

						boolean blueFlag = false;

						if (maze[blueNextY][blueNextX] == 4) blueFlag = true;

						blueVisited[blueNextY][blueNextX] = true;

						dfsBlueFirst(red, new Node(blueNextY, blueNextX), redVisited, blueVisited,
							redFinished, blueFlag, maze, depth+1);

						blueVisited[blueNextY][blueNextX] = false;


					} else if (!redFinished && !blueFinished) {
						if (blueNextY == red.y && blueNextX == red.x) continue;
						if (blueNextY == redNextY && blueNextX == redNextX) continue;
						if (!isIn(redNextY, redNextX)) continue;
						if (!isIn(blueNextY, blueNextX)) continue;
						if (redVisited[redNextY][redNextX]) continue;
						if (blueVisited[blueNextY][blueNextX]) continue;
						if (maze[redNextY][redNextX] == 5) continue;
						if (maze[blueNextY][blueNextX] == 5) continue;

						boolean redFlag = false;
						boolean blueFlag = false;

						if (maze[redNextY][redNextX] == 3) redFlag = true;
						if (maze[blueNextY][blueNextX] == 4) blueFlag = true;

						redVisited[redNextY][redNextX] = true;
						blueVisited[blueNextY][blueNextX] = true;

						dfsBlueFirst(new Node(redNextY, redNextX), new Node(blueNextY, blueNextX),
							redVisited, blueVisited, redFlag, blueFlag, maze, depth+1);

						redVisited[redNextY][redNextX] = false;
						blueVisited[blueNextY][blueNextX] = false;
					}
				}
			}
		}



		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}
	}

	class Node {
		int y,x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
