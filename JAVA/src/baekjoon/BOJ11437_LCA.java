package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.04
 * 문제 풀이 : LCA알고리즘을 사용한다.
 * index를 노드로 갖고 각 인덱스에 [부모노드, 깊이] 다음과 같이 저장
 * ㅇ;후 깊이가 다르면 같도록 조정 후
 * 현재 노드가 같다면 공통 조상 노드
 * 다르다면 깊이를 같이 낮춰주며 공통 조상을 찾을 때 까지 반복하여
 * 해결
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ11437_LCA {


    // 그래프
    static ArrayList<Integer>[] graph;
    // 방문여부 체크 셋
    static HashSet<Integer> visited;

    private static int[][] lcaArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 노드 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 그래프 표현
        graph = new ArrayList[N + 1];

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
            graph[a].add(b);
        }

        // 방문 체크 셋
        visited = new HashSet<>();

        //lcaArr 선언
        // 인덱스는 노드 번호
        // [idx][0]  은 부모 노드
        // [idx][1]  은 깊이를 나타낸다.
        lcaArr = new int[N+1][2];

        dfs(1);
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");

            // 노드 1과 2 입력
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);

            // 답을 찾을 동안
            while (true){


                // 우선 같은 높이 일 때까지
                while( lcaArr[node1][1] != lcaArr[node2][1]){
                    // 노드 1이 더 높이가 높다면
                    if (lcaArr[node1][1] > lcaArr[node2][1]) {
                        node1 = lcaArr[node1][0];

                    } else if (lcaArr[node1][1] < lcaArr[node2][1]){
                        node2 = lcaArr[node2][0];
                    }
                }


                // 공통 부모 조건 같은 높이 같은 노드
                if (lcaArr[node1][0] == lcaArr[node2][0] && lcaArr[node1][1] == lcaArr[node2][1]) {
                    if (node1 == node2){
                        sb.append(node1 + "\n");
                    } else{
                        sb.append(lcaArr[node1][0] + "\n");
                    }
                    break;

                // 높이를 1씩올려줌
                } else {
                    node1 = lcaArr[node1][0];
                    node2 = lcaArr[node2][0];
                }

            }
        }
        System.out.println(sb);

    }

    static void dfs(int node) {
        
        // 들어온 노드 방문으로 체크
        visited.add(node);

        // 연결된 엣지들 dfs 탐색
        for (int i : graph[node]) {
            if (!visited.contains(i)) {
                lcaArr[i][0] = node;
                lcaArr[i][1] = lcaArr[node][1] + 1;
                dfs(i);
            }
        }
    }
}
