package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.24
 * 문제 해결 방식 : BFS를 이용하여 연합국을 만들고 연합국들의 인구를 평균값으로
 *              이 과정을 더 이상 이동하지 못할 때 까지
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234_인구이동 {

    static int N, min, max;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 맵 사이즈
        N = Integer.parseInt(st.nextToken());
        // 이동 가능한 연합군 사이의 최솟값
        min = Integer.parseInt(st.nextToken());
        // 이동 가능한 연합국 사이의 최댓값
        max = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시간 변수
        int time = 0;

        // 와일문으로 인구가 이동 가능할 때 까지
        while (movePossible()) {

            // 인구 이동 진행
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    bfs(i, j);
                }
            }

            // 시간 ++
            time++;
        }


        // 정답 출력
        System.out.println(time);


    }


    // BFS 탐색 인구 이동
    static void bfs(int y, int x) {

        // 링크드 리스트는 연합국을 담아둠
        LinkedList<Node> union = new LinkedList<>();
        // BFS 큐
        Queue<Node> q = new LinkedList<>();

        // 현재 들어온 국가 추가
        union.add(new Node(y, x));
        // 큐에 현재 국가 기준으로 연합국들 탐색
        q.add(new Node(y, x));
        visited[y][x] = true;

        // 인구수 총 합
        int sumPopulation = map[y][x];

        // 큐가 빌 때 까지
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node.y + moveY[i];
                int nx = node.x + moveX[i];

                // 다음 좌표가 범위 밖이라면 넘긴다.
                if (!isIn(ny, nx)) continue;
                // 이미 방문했다면 넘긴다.
                if (visited[ny][nx]) continue;

                // 두 국가의 차이
                int diff = Math.abs(map[ny][nx] - map[node.y][node.x]);

                // 차이가 범위 밖이라면 넘긴다.
                if (diff < min || max < diff) continue;

                // 다음 국가 방문 체크
                visited[ny][nx] = true;

                // 다음 국가 이어서 탐색
                q.add(new Node(ny, nx));

                // 연합 가능한 국가이므로 큐에 추가
                union.add(new Node(ny, nx));

                // 연합의 인구수 +
                sumPopulation += map[ny][nx];
            }
        }

        // 연합국들의 평균 인구수
        int avgPopulation = sumPopulation / union.size();


        // 연합국들 인구 분배
        for (Node node : union) {
            map[node.y][node.x] = avgPopulation;
        }
    }


    // 범위 체크
    static boolean isIn(int y, int x) {
        if (0 <= x && x < N && 0 <= y && y < N) return true;
        return false;
    }


    // 인구가 이동 가능한지 여부
    static boolean movePossible() {


        // 두 국 사이에 차이값이 해당 min max 사이값에 있다면 true
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N-1 && j == N-1) continue;
                else if (i == N - 1) {
                    int rightDiff = Math.abs(map[i][j] - map[i][j + 1]);
                    if (min <= rightDiff && rightDiff <= max) return true;

                }
                else if (j == N - 1) {
                    int downDiff = Math.abs(map[i][j] - map[i + 1][j]);
                    if (min <= downDiff && downDiff <= max) return true;
                } else{
                    int rightDiff = Math.abs(map[i][j] - map[i][j + 1]);
                    int downDiff = Math.abs(map[i][j] - map[i + 1][j]);
                    if (min <= rightDiff && rightDiff <= max) return true;
                    if (min <= downDiff && downDiff <= max) return true;
                }
            }
        }

        // 아니면 false
        return false;

    }

    static class Node {
        int x, y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

}
