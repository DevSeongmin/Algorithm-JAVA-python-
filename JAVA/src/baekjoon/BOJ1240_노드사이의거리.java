package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.11
 * 문제 해결방식 : 비선형 자료구조의 탐색방법인 DFS또는 BFS 탐색을 통해
 * 두 노드 사이의 거리를 구한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class BOJ1240_노드사이의거리 {

    // 방문 리스트
    static boolean[] visited;
    // 그래프 표현 연결 리스트 방식으로
    static ArrayList<ArrayList<int[]>> graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int Node = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);


        // 연결 그래프 표현
        graph = new ArrayList<>();
        for (int i = 0; i <= Node; i++) {
            graph.add(new ArrayList<>());
        }


        // 거리 정보도 포함하여 트리 간선 연결
        for (int i = 0; i < Node-1; i++) {
            input = br.readLine().split(" ");

            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);

            graph.get(n1).add(new int[] {n2, d});
            graph.get(n2).add(new int[] {n1, d});
        }


        for (int i = 0; i < T; i++) {
            // 방문 리스트 초기화
            visited = new boolean[Node+1];
            input = br.readLine().split(" ");
            // 두 노드 입력
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            answer = 0;
            // DFS를 통해 거리값을 얻는다.
            // 한노드에서 DFS탐색하여 다른 노드를 만날 때 까지
            dfs(n1,0,n2);
            System.out.println(answer);
        }
    }


    static void dfs(int node, int distance, int target) {

        // 찾고자 하는 노드를 만났다면
        // 거리값을 정답 리스트에 넣어주고 return;
        if (target == node) {
            answer = distance;
            return;
        }

        // 노드 방문 처리
        visited[node] = true;


        // 연결된 노드들 탐색
        for (int[] i : graph.get(node)) {
            if (!visited[i[0]]) {
                // 해당 노드까지의 거리 + 이전까지 거리
                dfs(i[0], distance + i[1], target);
            }
        }


    }


}
