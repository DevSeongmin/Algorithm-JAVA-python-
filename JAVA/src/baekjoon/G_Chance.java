package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_Chance {

	static int answer = Integer.MAX_VALUE;
	static int start, end;
	static int[][] visited = new int[2][1000001];

	static void dfs(int pos, int chance, int cnt) {
		visited[chance][pos] = cnt;

		if (pos < start || cnt >= answer)
			return;

		if (pos == start) {
			answer = Math.min(answer, cnt);

		}

		if (chance == 1 && pos % 10 == 0 && visited[0][pos / 10] > cnt) {
			dfs(pos / 10, 0, cnt + 1);
		}

		if (pos % 2 == 0 && visited[chance][pos / 2] > cnt)
			dfs(pos / 2, chance, cnt + 1);

		if (visited[chance][pos - 1] > cnt) {
			dfs(pos - 1, chance, cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		Arrays.fill(visited[0], Integer.MAX_VALUE);
		Arrays.fill(visited[1], Integer.MAX_VALUE);

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dfs(end, 1, 0);
		System.out.println(answer);

	}

}