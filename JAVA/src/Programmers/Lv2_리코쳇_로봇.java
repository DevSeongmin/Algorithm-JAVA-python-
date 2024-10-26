package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_리코쳇_로봇 {
	class Node{
		int y, x, cnt;

		public Node(int y, int x, int cnt) {
			this.y =y ;
			this.x =x ;
			this.cnt =cnt ;
		}
	}


	class Solution {

		static int Y,X;

		public int solution(String[] board) {

			Y = board.length;
			X = board[0].length();
			char[][] map = new char[Y][X];
			boolean visited[][] = new boolean[Y][X];
			Node startNode = null;

			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					char val  = board[i].charAt(j);
					map[i][j] = val;

					if (val == 'R'){
						startNode = new Node(i, j, 0);
						visited[i][j] = true;
					}
				}
			}

			Queue<Node> q = new LinkedList();
			q.add(startNode);

			int answer = 0;

			while(!q.isEmpty()) {
				Node curNode = q.poll();

				if (map[curNode.y][curNode.x] == 'G') {
					return curNode.cnt;
				}

				for (int i = 0; i < 4; i++) {
					int ny = curNode.y;
					int nx = curNode.x;

					Node nextNode = findNext(curNode, i, map, visited);
					if (nextNode == null) continue;
					if (visited[nextNode.y][nextNode.x]) continue;

					q.add(nextNode);
					visited[nextNode.y][nextNode.x] = true;
				}
			}
			return -1;
		}


		public Node findNext(Node curNode, int i, char[][] map, boolean[][] visited){

			int ny = curNode.y;
			int nx = curNode.x;

			while(map[ny][nx] != 'D'){
				ny += moveY[i];
				nx += moveX[i];

				if (!isIn(ny, nx)){

					ny -= moveY[i];
					nx -= moveX[i];


					return new Node(ny, nx, curNode.cnt+1);
				}
			}

			ny -= moveY[i];
			nx -= moveX[i];

			if (visited[ny][nx]) return null;

			return new Node(ny, nx, curNode.cnt+1);
		}

		static int[] moveY = {-1, 1, 0, 0};
		static int[] moveX = {0, 0, -1, 1};

		public boolean isIn(int y, int x) {
			return 0<= y && y < Y && 0 <= x && x < X;
		}
	}
}
