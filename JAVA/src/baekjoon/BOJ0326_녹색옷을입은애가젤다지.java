package baekjoon;

/**
 *  작성자 : 황성민
 *  작성일자 : 24.03.26
 *  문제 해결 : 2차원 배열의 각 원소를 정점으로 보고 상하좌우에 간선이 있다고 생각하고
 *          다익스트라 알고리즘을 돌린다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ0326_녹색옷을입은애가젤다지 {
    static int N;
    static int[] moveX = { -1, 1, 0, 0 };
    static int[] moveY = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cnt = 0;

        // 0을 입력받을 때 까지 반복
        while (++cnt > 0) {

            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                System.out.println(sb);
                return;
            }

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 다익스트라 알고리즘 모든 거리배열 무한으로
            int[][] distance = new int[N][N];
            for (int[] d : distance)
                Arrays.fill(d, Integer.MAX_VALUE);

            // 시작지점은 0, 0
            distance[0][0] = map[0][0];



            // Start Dijkstra
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, distance[0][0]));
            while (!pq.isEmpty()) {

                Node cur = pq.poll();
                int y = cur.y;
                int x = cur.x;

                for (int i = 0; i < 4; i++) {
                    int ny = y + moveY[i];
                    int nx = x + moveX[i];

                    if (!isIn(ny, nx))
                        continue;

                    if (distance[ny][nx] > distance[y][x] + map[ny][nx]) {
                        distance[ny][nx] = distance[y][x] + map[ny][nx];
                        pq.add(new Node(ny, nx, distance[ny][nx]));
                    }
                }

            }
            sb.append("Problem " + cnt + ": " + distance[N - 1][N - 1] + "\n");
        }

    }

    static boolean isIn(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }


    // weight순으로 먼저 빼기 위해 Comparable 구현
    static class Node implements Comparable<Node> {
        int y, x, weight;

        public Node(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}