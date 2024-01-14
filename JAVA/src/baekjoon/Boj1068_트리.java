/*
작성자 : 황성민
작성 날짜 : 2024.01.14
문제 접근 및 해결 : https://blog.naver.com/steadydeveloper/223321971630
 */


package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj1068_트리 {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 노드의 개수 N
        int N = input.nextInt();
        // 시작 노드 변수 선언
        int startNode = 0;

        // 방문 체크 배열 초기화(false)
        visited = new boolean[N];
        Arrays.fill(visited, false);

        // 밴 노드를 입력받고 트리를 인접 리스트로 표현하기위해 트리의 정보를 배열에 넣어둠
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }

        // 금지 노드
        int ban = input.nextInt();


        //그래프 선언 인접 리스트 형식
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }


        // 그래프 정보 입력
        for (int i = 0; i < N; i++) {
            // -1(부모가 없다면)이라면 시작 노드로 선언
            if (arr[i] == -1) {
                startNode = i;
                continue;
            }
            // 연결되는 부모 또는 자식의 값이 금지 노드 값이라면 연결하지 않는다.
            if (arr[i] == ban || i == ban) {
                continue;
            }
            // 그래프 표현 부모 --->  자식    형식의 일방향 간선
            graph.get(arr[i]).add(i);
        }

        // 만약 시작 최상위 부모 노드가 금지노드라면 0출력
        if (startNode == ban) {
            System.out.println(0);
        }
        // 아니라면 DFS로 리프노드 탐색
        else {
            dfs(startNode);
            System.out.println(answer);
        }


    }

    // 리프노드 탐색 dfs함수 선언
    static void dfs(int node) {
        // 현재 노드는 방문처리
        visited[node] = true;

        // 현재 노드와 연결된 노드가 없다면 그건 리프(말단)노드이므로 정답++
        if (graph.get(node).isEmpty()) {
            answer++;
        }

        // 연결된 노드들 재귀적으로 탐색
        for (int v : graph.get(node)) {
            dfs(v);
        }

    }
}
