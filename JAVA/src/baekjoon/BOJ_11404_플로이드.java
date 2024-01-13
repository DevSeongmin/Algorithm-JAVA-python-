package baekjoon;

import java.util.Scanner;

// 플로이드 워셜 알고리즘
//  그래프의 이론중 모든 노드에서 다른 모든 노드들까지의 최단 거리를 구하는 알고리즘
public class BOJ_11404_플로이드 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 문제에서의 가중치(weight)의 입력범위가 100_000 이하이므로 무한대를 편의상 100_001로 설정 했다가 틀림...
        // 이유 A -> B -> C -> D 처럼 한 방향으로 있을 때 단순히 가중치의 값 + 1로 최대값을 지정하면 무한대 역할을 제대로 못한다.
        // 그래서 한 노드에서 다른 노드로 가는 최악의 경우인
        // 100000(가중치 최댓값) * 100(최대 노드 수)로 설정
        int INF = 100000 * 100;

        int NODE = input.nextInt();
        int EDGE = input.nextInt();

        // 인덱스를 맞추기 위해 (NODE + 1)
        int[][] matrix = new int[NODE + 1][NODE + 1];



        // 초기 인접 행렬 설정
        for (int i = 1; i <= NODE; i++) {
            for (int j = 1; j <= NODE; j++) {

                // 무한대로 설정
                matrix[i][j] = INF;

                // 나에서 나로 가는 거리는 0
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }



        // 인접행렬 표현 엣지의 수 만큼 반복
        for (int i = 0; i < EDGE; i++) {
            int startNode = input.nextInt();
            int endNode = input.nextInt();
            int weight = input.nextInt();

            // 문제에서 같은 경로가 여러번 주어질 수도 있어서 기존에 값과 비교하여 최솟값으로 설정
            matrix[startNode][endNode] = Math.min(weight, matrix[startNode][endNode]);
        }



        // 플로이드 워셜 알고리즘 수행

        // 출발 노드에서 목적지 노드까지 가는 거리와    출발 노드에서 임시 경유지를 들렸다 목적지 노드로 가는 값을 비교하여 작은 값으로 업데이트
        // DP 점화식 DP[start][end] = min(DP[start][end],  DP[start][tmp] + DP[tmp][end])
        // 핵심 이론 : 시작 노드부터 도착지 노드까지 최단 경로를 구했다고 가정했을 때 최단 경로 위에 경유지 노드가 존재한다면 그 경유지 노드 까지도 결국 최단 거리라는 것을 이해할 수 있습니다.
        for (int tmp = 1; tmp <= NODE; tmp++) {
            for (int start = 1; start <= NODE; start++) {
                for (int end = 1; end <= NODE; end++) {
                    //점화식 수행
                    matrix[start][end] = Math.min(matrix[start][end], matrix[start][tmp] + matrix[tmp][end]);
                }
            }
        }

        // 정답 출력
        for (int i = 1; i <= NODE; i++) {
            for (int j = 1; j <= NODE; j++) {
                // 초기 무한대로 설정되어 있다면 경로가 없다는 의미이므로 0 출력
                if (matrix[i][j] == INF) {
                    System.out.print("0 ");

                // 무한대가 아니라면 해당 값 출력
                } else {
                    System.out.print(matrix[i][j] + " ");

                }
            }
            System.out.println();
        }

    }
}
