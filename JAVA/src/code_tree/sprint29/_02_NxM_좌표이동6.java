package code_tree.sprint29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int y, x, cnt, k;

	public Node(int y, int x, int cnt, int k){
		this.y =y;
		this.x =x ;
		this.cnt = cnt;
		this.k = k;
	}
}
public class _02_NxM_좌표이동6 {

	static int Y, X;
	static final int[] dy = {-1, 1, 0, 0};
	static final int[] dx = {0, 0, -1, 1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		int[][] board = new int[Y][X];
		boolean[][][] visited = new boolean[2][Y][X];

		for (int i = 0; i < Y;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < X; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Node startNode = null;

		if (board[0][0] == 1){
			startNode = new Node(0, 0, 1, 1);
		} else {
			startNode = new Node(0, 0, 1, 0);
		}

		visited[0][0][0] = true;

		Queue<Node> q = new LinkedList();
		q.add(startNode);

		while(!q.isEmpty()){
			Node curNode = q.poll();

			if (curNode.y == Y - 1 && curNode.x == X - 1){
				System.out.println(curNode.cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int ny = curNode.y + dy[i];
				int nx = curNode.x + dx[i];
				int nk = curNode.k;



				if (!isIn(ny, nx)) continue;


				if (board[ny][nx] == 1){
					nk++;
				}


				if (nk > 1) continue;
				if (visited[nk][ny][nx]) continue;

				visited[nk][ny][nx] = true;
				q.add(new Node(ny, nx, curNode.cnt + 1, nk));
			}
		}

		System.out.println(-1);
	}


	static boolean isIn(int y, int x) {
		return 0 <= y && y < Y && 0 <= x && x < X;
	}
}