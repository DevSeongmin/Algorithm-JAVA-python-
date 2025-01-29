package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Lv2_장애물_인식_프로그램 {
	public class Main {

		static int N;
		static int[][] board;
		static boolean[][] visited;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};
		static HashMap<Integer, Integer> map = new HashMap();

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = input.charAt(j) - '0';
				}
			}

			int curGroupNum = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && board[i][j] == 1) {
						dfs(i, j, curGroupNum);
						curGroupNum++;
					}
				}
			}
			ArrayList<Integer> answerList = new ArrayList();

			for (int i = 1; i <= map.size(); i++) {
				answerList.add(map.get(i));
			}

			Collections.sort(answerList);

			System.out.println(answerList.size());
			for (int val : answerList) {
				System.out.println(val);
			}
		}

		static void dfs(int y, int x, int curGroupNum) {
			visited[y][x] = true;
			map.put(curGroupNum, map.getOrDefault(curGroupNum, 0) + 1);


			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (!isIn(ny, nx)) continue;
				if (visited[ny][nx]) continue;
				if (board[ny][nx] == 0) continue;

				dfs(ny, nx, curGroupNum);
			}
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < N && 0 <= x && x < N;
		}
	}
}
