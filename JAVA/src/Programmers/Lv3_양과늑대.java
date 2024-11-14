package Programmers;

public class Lv3_양과늑대 {

	static int[] info;
	static int[][] edges;
	static boolean[] visited;
	static int answer = 1;

	public int solution(int[] info, int[][] edges) {
		this.info = info;
		this.edges = edges;
		visited = new boolean[info.length];
		visited[0] = true;
		dfs(0, 0, 0);

		return answer;
	}

	public static void dfs(int idx, int sheep, int wolf){
		if (info[idx] == 0) {
			sheep++;
		} else {
			wolf++;
		}

		if (sheep <= wolf) {
			return;
		}

		answer = Math.max(answer, sheep);

		for (int[] edge : edges) {
			if (visited[edge[0]] && !visited[edge[1]]){
				visited[edge[1]] = true;
				dfs(edge[1], sheep, wolf);
				visited[edge[1]] = false;
			}
		}
	}
}