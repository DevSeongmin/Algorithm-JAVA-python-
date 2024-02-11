package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.11
 * 문제 해결 : 비선형 자료구조인 그래프에서 DFS탐색을 통해 배열의 부모 노드를 저장해 둔다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ11725_트리의부모찾기 {

    // 부모 노드를 담아둘 배열 선언
    static int[] parents;
    // 그래프 선언 ( 연결 리스트)
    static ArrayList<Integer>[] graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());

        // 부모의 초기는 -1로 채운다. -1이면 방문을 안한것
        parents = new int[N+1];
        Arrays.fill(parents, -1);


        // 그래프 연결리스트 형식으로 표현
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++){
            input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);

            graph[node1].add(node2);
            graph[node2].add(node1);
        }


        // DFS탐색
        dfs(1);

        // 2번 노드부터 부모 노드 출력
        for (int i = 2; i <=N; i++){
            System.out.println(parents[i]);
        }

    }

    static void dfs(int node){

        for (int i : graph[node]) {
            // 다음 노드가 -1이라면 (아직 탐색 안했다면)
            if (parents[i] == -1){
                // parents 배열에 해당 노드인덱스에 부모 노드 번호를 저장 
                parents[i] = node;
                // 이후 연결된 노드들 탐색
                dfs(i);
            }
        }
    }
}
