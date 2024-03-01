package swea;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.22
 * 문제해결 : 깊이가 현재까지의 정답을 갱신했던 깊이보다 클경우 정답 갱신
 *          같을 경우 비교하여 더 큰 값으로 정답 갱신
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea1238_Contact {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        // 테스트 케이스 10개
        for (int tc = 1; tc <= 10; tc++) {

            input = br.readLine().split(" ");






            // 엣지 개수
            int N = Integer.parseInt(input[0]);
            // 시작 노드
            int start = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");

            // 그래프 인접 리스트로 표현
            LinkedList<Integer>[] graph = new LinkedList[101];
            for (int i = 0; i <= 100; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < N; i+=2) {
                int n1 = Integer.parseInt(input[i]);
                int n2 = Integer.parseInt(input[i + 1]);
                graph[n1].add(n2);
            }

            // 방문배열
            boolean[] visited = new boolean[101];


            // 정답 변수
            int answer = -1;
            // 지금까지의 최대 깊이를 나타내는 변수
            int maxDepth =0;

            Queue<int[]> q = new LinkedList<>();

            // 시작점 넣고 방문체크
            q.add(new int[] { start, 1});
            visited[start] = true;

            // 큐가 빌 때 까지
            while (!q.isEmpty()) {

                // 큐에서 빼기 
                int[] tmp = q.poll();
                int node = tmp[0];
                int depth = tmp[1];
                // 노드 방문 체크
                boolean flag = true;

                // 연결 가능한 그래프가 있는지 체크
                for (int v : graph[node]) {
                    if (!visited[v]) flag = false;
                }


                // 연결 가능한 그래프가 없다면
                if (flag) {
                    // 깊이가 더 크다면 최대 깊이와 정답 갱신
                    if (depth > maxDepth) {
                        maxDepth = depth;
                        answer = node;
                    }

                    // 깊이가 같다면 더 큰 값으로 정답 갱신
                    if (depth == maxDepth) {
                        answer = Math.max(answer, node);
                    }
                }

                // DFS
                for (int v : graph[node]) {
                    if (visited[v])
                        continue;
                    visited[v] = true;

                    q.add(new int[] { v, depth + 1 });

                }

            }

            // 정답 출력
            System.out.println("#" + tc + " " + answer);
        }

    }

}