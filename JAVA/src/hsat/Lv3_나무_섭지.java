package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lv3_나무_섭지 {
	public class Main {

		static int Y,X;
		static char[][] board;
		static boolean[][] namuVisited;
		static boolean[][] ghostVisited;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			board = new char[Y][X];
			ghostVisited = new boolean[Y][X];
			namuVisited = new boolean[Y][X];

			Queue<Node> q = new LinkedList();
			Node namu = null;

			for (int i = 0; i < Y; i++){
				String input = br.readLine();
				for (int j = 0; j < X; j++) {
					board[i][j] = input.charAt(j);

					if (board[i][j] == 'G') {
						q.add(new Node('G', i, j));
						ghostVisited[i][j] = true;
					}

					if (board[i][j] == 'N') {
						namu = new Node('N', i, j);
						namuVisited[i][j] = true;
					}
				}
			}

			q.add(namu);

			while(!q.isEmpty()) {
				Node cur = q.poll();

				if (board[cur.y][cur.x] == 'D' && cur.name == 'N') {
					System.out.println("Yes");
					return;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];

					if (!isIn(ny ,nx)) continue;


					if (cur.name == 'G') {

						if (ghostVisited[ny][nx]) continue;

						ghostVisited[ny][nx] = true;
						q.add(new Node('G', ny, nx));
					}

					if (cur.name == 'N') {

						if (board[ny][nx] == '#') continue;
						if (ghostVisited[ny][nx]) continue;
						if (namuVisited[ny][nx]) continue;

						namuVisited[ny][nx] = true;
						q.add(new Node('N', ny,nx));
					}
				}
			}
			System.out.println("No");
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < Y && 0 <= x && x < X;
		}

		static class Node{
			char name;
			int y, x;


			public Node(char name, int y, int x){
				this.name = name;
				this.y = y;
				this.x = x;
			}
		}
	}
}
