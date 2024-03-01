package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.24
 * 문제 해결 : BFS를 이용하여 다음 먹을 수 있는 먹이중
 *          거리가 가장 짧고 위쪽 우선으로 같다면 왼쪽을 먼저 먹도록 구현한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236_아기상어 {

    static int N;
    static int[][] map;

    static int[] moveX = {0, -1, 1, 0};
    static int[] moveY = {-1, 0, 0, 1};

    // 현재 상어의 상태를 나타냄,  + 컴페어러블 재정의 비교를 위해
    static Node babyShark;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    babyShark = new Node(i, j, 2, 0, 0);
                    map[i][j] = 0;
                }
            }
        }


        // 먹을 수 있는 먹이가 있을 때 까지
        while (bfs(babyShark));

        // 정답 출력
        System.out.println(babyShark.time);
    }

    // bfs
    static boolean bfs(Node shark) {

        // 방문배열 업데이트
        boolean[][] visited = new boolean[N][N];
        // 노드들의 비교 재정의로 우선순위 큐 사용
        PriorityQueue<Node> q = new PriorityQueue<>();

        // 현재 상어 큐에 추가
        q.add(shark);

        // 현재 위치 treu
        visited[shark.y][shark.x] = true;


        // max 타임은 먹이를 먹을 수 있으면 그때 최대시간으로 갱신하여
        // 시간이 넘는 좌표들에 대해서는 탐색하지 않도록
        int maxTime = Integer.MAX_VALUE;

        // 큐가 비지 않았거나 큐의 poll 노드가 먹이를 먹은 시간보다 작은 경우만
        while (!q.isEmpty() && q.peek().time < maxTime) {


            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + moveY[i];
                int nx = cur.x + moveX[i];

                // 범위 밖이면 넘겨
                if (!isIn(ny, nx)) continue;

                // 이미 갔던곳이라면 넘겨
                if (visited[ny][nx]) continue;

                // 나보다 큰 물고기는 못지나가
                if (cur.size < map[ny][nx]) {
                    visited[ny][nx] = true;
                    continue;
                }

                // 빈칸이거나 크기 같은 물고기는 지나가   그리고 먹을 수 있는 먹이를 찾은 시간보다 작을 때
                if ((map[ny][nx] == 0 || map[ny][nx] == cur.size) && cur.time < maxTime) {
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx, cur.size, cur.ate, cur.time+1));
                }

                // 나보다 작은 물고기면 먹어  그리고 먹을 수 있는 먹이를 찾은 시간보다 작을 때
                else if (map[ny][nx] < cur.size && cur.time < maxTime) {
                    visited[ny][nx] = true;
                    cur.ate++;

                    // 우선 먹고 크기만큼 먹었으면 사이즈++
                    if (cur.ate == cur.size) {
                        cur.ate = 0;
                        cur.size++;
                    }

                    cur.y = ny;
                    cur.x = nx;
                    cur.time++;

                    maxTime = cur.time;

                    q.add(new Node(cur.y, cur.x, cur.size, cur.ate, cur.time));
                }
            }
        }

        // 만약 큐가 비어있으면 먹을 먹이가 없는 것
        if (q.isEmpty()) {
            return false;
        } else {
            while (true) {

                Node curShark = q.poll();

                // 큐에서 꺼낸 상어의 위치가 0이 아니고 먹을 수 있는 먹이라면
                if (map[curShark.y][curShark.x] < curShark.size && map[curShark.y][curShark.x]!=0 ) {


                    // 먹이 좌표 0으로
                    map[curShark.y][curShark.x] = 0;
                    // 상어 상태 갱신
                    babyShark = curShark;
                    return true;
                }
            }
        }
    }

    // 범위 체크 메서드
    static boolean isIn(int y, int x) {
        if (0 <= x && x < N && 0 <= y && y < N) {
            return true;
        }
        return false;
    }


    // 노드 클래스
    static class Node implements Comparable<Node>{
        int y, x, size, ate, time;

        public Node(int y, int x, int size, int ate, int time) {
            this.y = y;
            this.x = x;
            this.size = size;
            this.ate = ate;
            this.time = time;
        }


        // 우선순위 큐를 사용하기 위해 컴페어투 재정의
        @Override
        public int compareTo(Node o) {
            if (this.time == o.time && this.y == o.y) {
                return this.x - o.x;
            } else if (this. time == o.time){
                return this.y - o.y;
            } else{
                return this.time - o.time;
            }

        }
    }
}
