package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.04
 * 문제 풀이 DFS를 이용하여 자식에서 부모쪽으로 일방향 그래프를 만든 후
 * 두 자식 노드에서 DFS탐색을 하여 처음 만나는 공통 조상을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class BOJ3584_가장가까운공통조상 {

    // 그래프 
    static ArrayList<Integer>[] graph;
    // 방문여부 체크 셋
    static HashSet<Integer> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테케 수 입력
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            // 노드 개수 입력
            int N = Integer.parseInt(br.readLine());

            // 그래프 표현
            graph = new ArrayList[N + 1];

            // 방문 체크 셋
            visited = new HashSet<>();

            // 그래프 노드번호에 각각 빈 리스트 넣어줌
            // 인접 리스트형식으로 그래프 표현
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<Integer>();
            }

            // 간선의 정보들 입력
            // 자식 -> 부모 형식으로
            for (int i = 0; i < N - 1; i++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                graph[b].add(a);
            }

            String[] input = br.readLine().split(" ");
            // 공통 부모를 찾을 두 자식 입력
            int child1 = Integer.parseInt(input[0]);
            int child2 = Integer.parseInt(input[1]);

            // 자식 첫번째 탐색
            dfs(child1);
            // 두번째 자식을 탐색
            dfs(child2);
        }

    }

    static void dfs(int node){
        // 해당 노드가 방문 했다면 처음으로 만나는 공통 조상이다.
        if (visited.contains(node)) {
            // 출력하고 끝
            System.out.println(node);
            return;
        }
        // 들어온 노드 방문으로 체크
        visited.add(node);

        // 연결된 엣지들 dfs 탐색
        for (int i : graph[node]) {
            dfs(i);
        }
    }
}
