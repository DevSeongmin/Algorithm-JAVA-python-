package code_tree.sprint24;

import java.util.*;
import java.io.*;

class Node{
	int idx, cnt;

	public Node(int idx, int cnt){
		this.idx = idx;
		this.cnt = cnt;
	}
}

public class _02_최소_동전의_수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[] arr = new int[N];
		input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int MAX_LENGTH = 11001;
		int[] visited = new int[MAX_LENGTH];
		Arrays.fill(visited, Integer.MAX_VALUE);
		visited[0] = 0;

		Queue<Node> q = new LinkedList();
		Node startNode = new Node(0, 0);
		q.add(startNode);

		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int curIdx = curNode.idx;
			int curCnt = curNode.cnt;

			for (int i : arr){
				int nextIdx = curIdx + i;

				if (nextIdx < 0 || nextIdx >= MAX_LENGTH) continue;

				if (visited[nextIdx] <= curCnt + 1) continue;

				visited[nextIdx] = curCnt + 1;
				q.add(new Node(nextIdx, curCnt + 1));
			}
		}

		if (visited[M] == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		System.out.println(visited[M]);
	}
}
