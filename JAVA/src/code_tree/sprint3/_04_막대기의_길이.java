package code_tree.sprint3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _04_막대기의_길이 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[] indeg = new int[N+1];

		ArrayList<Integer>[] graph = new ArrayList[N+1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			graph[s].add(e);
			indeg[e]++;
		}

		Queue<Integer> q = new LinkedList();

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0){
				q.add(i);
			}
		}

		while(!q.isEmpty()) {
			int curNode = q.poll();
			System.out.print(curNode + " ");

			for (int nextNode : graph[curNode]){
				if (--indeg[nextNode] == 0) {
					q.add(nextNode);
				}
			}
		}
	}
}