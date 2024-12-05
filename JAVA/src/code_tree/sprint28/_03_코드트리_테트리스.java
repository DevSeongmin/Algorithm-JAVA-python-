package code_tree.sprint28;
import java.util.*;
import java.io.*;

class Node{
	int y, x;
	public Node(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class _03_코드트리_테트리스 {

	public static int Y, X;
	public static int[][] BOARD;
	public static boolean[][] visited;
	public static List<Node> list = new ArrayList();
	public static int answer;

	public static final int[] dy = {-1, 1, 0, 0};
	public static final int[] dx = {0, 0, -1, 1};

	public static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}

	public static void find() {
		if (list.size() == 5) {
			int straight = 0;

			for (int i = 0; i < 2; i++) {
				int val = 0;
				for (int j = 0; j < 5; j++) {
					if (list.get(i).y == list.get(j).y) val++;
				}
				straight = Math.max(straight, val);

				val = 0;
				for (int j = 0; j < 5; j++) {
					if (list.get(i).x == list.get(j).x) val++;
				}
				straight = Math.max(straight, val);
			}

			if (straight >= 4) return;

			int val = 0;
			for (int i = 0; i < 5; i++) {
				val+= BOARD[list.get(i).y][list.get(i).x];
			}
			answer = Math.max(answer, val);
			return;
		}


		for (int idx = 0; idx < list.size(); idx++) {
			for (int i = 0; i < 4; i++) {
				int ny = list.get(idx).y + dy[i];
				int nx = list.get(idx).x + dx[i];

				if (!isIn(ny, nx)) continue;
				if (visited[ny][nx]) continue;

				visited[ny][nx] = true;
				list.add(new Node(ny, nx));

				find();

				visited[ny][nx] = false;
				list.remove(list.size() - 1);
			}
		}
	}



	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		BOARD = new int[Y][X];
		visited= new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				BOARD[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i= 0; i < Y; i++) {
			for (int j = 0; j < X; j++) {
				list.add(new Node(i, j));
				visited[i][j] = true;

				find();

				list.remove(list.size() - 1);
				visited[i][j] = false;
			}
		}

		System.out.println(answer);
	}
}
