package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// MST(최소 신장 트리) 알고리즘  크루스칼로 구현
public class BOJ4386_별자리_만들기 {

    // 서로소 집합을 나타내는 배열
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];


        double[][] nodes = new double[N][2];

        // 엣지 리스트                                           자바는 어렵네용...
        PriorityQueue<double[]> edgeList = new PriorityQueue<>(Comparator.comparingDouble(arr -> arr[0]));


        // 노드정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i][0] = Double.parseDouble(st.nextToken());
            nodes[i][1] = Double.parseDouble(st.nextToken());
            parents[i] = i;
        }


        // 2중 포문으로 2개의 모든 노드쌍을 계산
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                                        // 노드의 거리                  i번째 노드, j번째 노드
                edgeList.add(new double[]{calDistance(nodes[i], nodes[j]), i, j});
            }
        }


        double answer = 0;
        double value = 0;
        // 크루스칼 알고리즘 노드의 개수 -1 번 만큼 연결하면 된다!
        for (int i = 0; i < N  - 1; i++) {
            int node1 = 0;
            int node2 = 0;
            value = 0;

            // 두 노드가 다른 집합일 때 까지
            while (true) {
                double[] datas = edgeList.poll();
                node1 = (int) datas[1];
                node2 = (int) datas[2];
                value = datas[0];
                if (find(node1) != find(node2)) {
                    break;
                }
            }

            // 두 노드를 연결하고
            union(node1, node2);
            // 두 노드의 사이의 거리만큼 정답에 +
            answer += value;
        }


        // 정답 출력
        System.out.println(answer);


    }

    // 두 노드의 거리 계산
    static double calDistance(double[] n1, double[] n2) {

        double y = Math.abs(n1[0] - n2[0]);
        double x = Math.abs(n1[1] - n2[1]);

        return Math.sqrt(y * y + x * x);
    }

    // find 연산
    static int find(int n) {
        if (parents[n] == n) {
            return n;
        }

        parents[n] = find(parents[n]);
        return parents[n];
    }

    // 유니온 연산
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parents[a] = b;
    }



}
