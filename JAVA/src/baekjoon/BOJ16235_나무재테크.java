package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16235_나무재테크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int TreeCount = Integer.parseInt(st.nextToken());
		int YEAR = Integer.parseInt(st.nextToken());

		int[][] fertilizers = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				fertilizers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Farm farm = new Farm(N, fertilizers);

		for (int i = 0; i < TreeCount; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());

			farm.trees[y][x].add(age);
		}


		for (int i = 0; i < YEAR; i++) {
			farm.spring();
			farm.summer();
			farm.autumn();
			farm.winter();
		}

		System.out.println(farm.getTreeCount());
	}
}

class DeadTree {
	int y, x, age;

	public DeadTree(int y, int x, int age) {
		this.y = y;
		this.x = x;
		this.age = age;
	}
}

class Farm{
	int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
	int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

	int N;
	int[][] nutrients;
	int[][] fertilizer;
	PriorityQueue<Integer>[][] trees;
	Queue<DeadTree> deadTreeQueue = new LinkedList<>();

	public Farm(int N, int[][] fertilizers) {
		this.N = N;
		nutrients = new int[N][N];
		fertilizer = fertilizers;
		trees = new PriorityQueue[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutrients[i][j] = 5;
				trees[i][j] = new PriorityQueue<>();
			}
		}
	}

	public void spring() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ArrayList<Integer> tmp = new ArrayList<>();

				while (!trees[i][j].isEmpty()) {
					int treeAge = trees[i][j].poll();

					if (treeAge <= nutrients[i][j]) {
						nutrients[i][j] -= treeAge;
						tmp.add(treeAge+1);
					} else {
						deadTreeQueue.add(new DeadTree(i, j, treeAge));
					}
				}

				for (int grownTree : tmp) {
					trees[i][j].add(grownTree);
				}
			}
		}
	}

	public void summer() {
		while (!deadTreeQueue.isEmpty()) {
			DeadTree deadTree = deadTreeQueue.poll();
			nutrients[deadTree.y][deadTree.x] += deadTree.age / 2;
		}
	}

	public void autumn(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				PriorityQueue<Integer> tmp = new PriorityQueue<>(trees[i][j]);
				while (!tmp.isEmpty()) {
					if (tmp.poll() % 5 == 0) {
						for (int dir = 0; dir < 8; dir++) {
							int ny = i + dy[dir];
							int nx = j + dx[dir];

							if (!isIn(ny,nx)) continue;

							trees[ny][nx].add(1);
						}
					}
				}
			}
		}
	}

	public void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nutrients[i][j] += fertilizer[i][j];
			}
		}
	}

	public int getTreeCount() {
		int treeCount = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				treeCount += trees[i][j].size();
			}
		}

		return treeCount;
	}

	private boolean isIn(int y, int x) {
		return 0 <= y && y < N && 0 <= x && x < N;
	}
}