package code_tree.sprint16;

import java.io.*;
import java.util.*;

public class _03_곰돌이의_모험 {

	static int N, P, answer;
	static int[][] board;
	static Set<String>[] playerVisited;
	static ArrayList<String> selected;
	static int[] dy = {-1, 1, 0, 0, 0};
	static int[] dx = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken()) + 1;

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		playerVisited = new HashSet[P];

		for (int i = 0; i < P; i++) {
			playerVisited[i] = new HashSet();

			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;

			Player player = new Player(y, x, 0);
			player.visited.add(y + " " + x);

			Queue<Player> q = new LinkedList();
			q.add(player);

			while(!q.isEmpty()) {
				Player curPlayer = q.poll();

				if (curPlayer.t >= 3) {
					String allPos = "";
					for (String s : curPlayer.visited) {
						allPos += s + " ";
					}
					playerVisited[i].add(allPos);
					continue;
				}

				for (int dir = 0; dir < 5; dir++) {
					int ny = curPlayer.y + dy[dir];
					int nx = curPlayer.x + dx[dir];

					if (!isIn(ny, nx)) continue;
					if (board[ny][nx] == -1) continue;

					Player nPlayer = new Player(ny, nx, curPlayer.t + 1);
					nPlayer.visited = new HashSet(curPlayer.visited);
					nPlayer.visited.add(ny + " " + nx);
					q.add(nPlayer);
				}
			}
		}
		selected = new ArrayList();
		recursion(0);
		System.out.println(answer);
	}

	static void recursion(int depth) {
		if (depth == P) {
			HashSet<String> answerSet = new HashSet();
			for (String yxs : selected) {
				String[] yxsArr = yxs.split(" ");
				for (int i = 0; i < yxsArr.length; i+=2) {
					int y = Integer.parseInt(yxsArr[i]);
					int x = Integer.parseInt(yxsArr[i+1]);
					answerSet.add(y + " " + x);
				}
			}

			int value = 0;
			for (String tmp : answerSet) {
				String[] yx = tmp.split(" ");
				int y = Integer.parseInt(yx[0]);
				int x = Integer.parseInt(yx[1]);
				value += board[y][x];
			}
			answer = Math.max(answer, value);
			return;
		}

		for (String tmp : playerVisited[depth]) {
			selected.add(tmp);
			recursion(depth + 1);
			selected.remove(selected.size() - 1);
		}
	}

	static boolean isIn(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}

class Player{
	int y, x, t;
	Set<String> visited;

	public Player(int y, int x, int t) {
		this.y = y;
		this.x = x;
		this.t = t;
		visited = new HashSet();
	}
}