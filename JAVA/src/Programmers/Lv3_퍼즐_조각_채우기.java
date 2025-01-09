package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Lv3_퍼즐_조각_채우기 {
	class Solution {

		static int N, blockLength, spacesLength, answer;
		static int[][] board;
		static int[][] table;
		static int[] dy = {-1, 1, 0, 0};
		static int[] dx = {0, 0, -1, 1};
		static boolean[] blockVisited;

		static ArrayList<ArrayList<Node>> emptySpaces, blocks;

		public int solution(int[][] board, int[][] table) {
			N = board.length;
			this.board = board;
			this.table = table;

			emptySpaces = getEmptySpaces();
			blocks = getBlocks();

			spacesLength = emptySpaces.size();
			blockLength = blocks.size();
			blockVisited = new boolean[blockLength];

			for (int i =0; i < spacesLength; i++) {
				ArrayList<Node> space = emptySpaces.get(i);

				for (int j = 0; j < blockLength; j++) {
					if (blockVisited[j]) continue;

					ArrayList<Node> block = blocks.get(j);
					if (space.size() != block.size()) continue;
					if (!isSame(space, block)) continue;

					blockVisited[j] = true;
					answer += block.size();
					break;
				}
			}
			return answer;
		}

		boolean isSame(ArrayList<Node> space, ArrayList<Node> block) {

			for (int i = 0; i < 4; i++) {

				boolean flag = true;

				for (int j = 0; j < space.size(); j++) {
					if (space.get(j).y != block.get(j).y || space.get(j).x != block.get(j).x) {
						flag = false;
					}
				}

				if (flag) {
					return true;
				}
				block = spin(block);
			}
			return false;
		}

		ArrayList<ArrayList<Node>> getEmptySpaces() {

			ArrayList<ArrayList<Node>> emptySpaces = new ArrayList();

			boolean[][] visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) continue;
					if (visited[i][j]) continue;

					ArrayList<Node> emptySpace = new ArrayList();
					Queue<Node> q = new LinkedList();

					Node startNode = new Node(i, j);
					visited[i][j] = true;
					q.add(startNode);
					emptySpace.add(startNode);

					while(!q.isEmpty()) {
						Node cur = q.poll();

						for (int d = 0; d < 4; d++) {
							int ny = cur.y + dy[d];
							int nx = cur.x + dx[d];

							if (!isIn(ny, nx)) continue;
							if (visited[ny][nx]) continue;
							if (board[ny][nx] == 1) continue;

							Node nextNode = new Node(ny, nx);

							emptySpace.add(nextNode);
							q.add(nextNode);
							visited[ny][nx] = true;
						}
					}
					emptySpaces.add(mySort(emptySpace));
				}
			}
			return emptySpaces;
		}

		ArrayList<ArrayList<Node>> getBlocks() {

			ArrayList<ArrayList<Node>> blocks = new ArrayList();

			boolean[][] visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (table[i][j] == 0) continue;
					if (visited[i][j]) continue;

					ArrayList<Node> block = new ArrayList();
					Queue<Node> q = new LinkedList();

					Node startNode = new Node(i, j);
					visited[i][j] = true;
					q.add(startNode);
					block.add(startNode);


					while(!q.isEmpty()) {
						Node cur = q.poll();

						for (int d = 0; d < 4; d++) {
							int ny = cur.y + dy[d];
							int nx = cur.x + dx[d];

							if (!isIn(ny, nx)) continue;
							if (visited[ny][nx]) continue;
							if (table[ny][nx] == 0) continue;

							Node nextNode = new Node(ny, nx);

							block.add(nextNode);
							q.add(nextNode);
							visited[ny][nx] = true;
						}
					}
					blocks.add(mySort(block));
				}
			}
			return blocks;
		}

		static ArrayList<Node> mySort(ArrayList<Node> arr) {

			Collections.sort(arr, (a, b) -> a.y == b.y ? a.x - b.x : a.y - b.y);

			int y = arr.get(0).y;
			int x = arr.get(0).x;

			for (Node node : arr) {
				node.y -= y;
				node.x -= x;
			}

			return arr;
		}

		static boolean isIn(int y, int x) {
			return 0 <= y && y < N && 0 <= x && x < N;
		}

		static ArrayList<Node> spin(ArrayList<Node> arr) {

			for (Node node : arr) {
				int y = node.y;
				int x = node.x;

				node.y = -x;
				node.x = y;
			}
			return mySort(arr);
		}
	}

	class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return this.y + " " + this.x;
		}
	}
}


