package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.28
 * 문제 해결 : BFS로 접근하고 점프를 했을 때는 점프횟수에대한 방문 배열을 따로 처리하여 해결한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {

    static int Y, X;

    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};

    static int[] holseMoveY = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] holseMoveX = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[][] map = new int[Y][X];

        // 방문배열 점프 횟수를 기록할 수 있을만큼
        boolean[][][] visited = new boolean[K + 1][Y][X];

        for (int i = 0; i < Y; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < X; j++) {
                if (input[j].equals("1")) {
                    map[i][j] = -1;
                }
            }
        }


        Queue<Node> q = new LinkedList<>();

        map[0][0] = 1;
        visited[0][0][0] = true;
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int y = cur.y;
            int x = cur.x;
            int k = cur.k;

            // 목적지라면 정답 출력
            if (y == Y - 1 && x == X - 1) {
                System.out.println(map[y][x] - 1);
                return;
            }

            // 그냥 이동하는 경우
            for (int i = 0; i < 4; i++) {
                int ny = y + moveY[i];
                int nx = x + moveX[i];

                if (!isIn(ny, nx)) continue;
                if (visited[k][ny][nx]) continue;
                if (map[ny][nx] == -1) continue;

                map[ny][nx] = map[y][x] + 1;
                visited[k][ny][nx] = true;
                q.add(new Node(ny, nx, k));
            }


            // 점프를 할 수 있을 때 점프하는 경우
            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + holseMoveY[i];
                    int nx = x + holseMoveX[i];

                    if (!isIn(ny, nx)) continue;
                    if (visited[k + 1][ny][nx]) continue;
                    if (map[ny][nx] == -1) continue;


                    map[ny][nx] = map[y][x] + 1;
                    visited[k + 1][ny][nx] = true;
                    q.add(new Node(ny, nx, k + 1));
                }
            }
        }
        System.out.println(-1);


    }

    // 범위 체크 
    static boolean isIn(int y, int x) {
        return 0 <= y && y < Y && 0 <= x && x < X;
    }

    
    // 좌표 클래스
    static class Node {
        int y, x, k;

        public Node(int y, int x, int k) {
            this.y = y;
            this.x = x;
            this.k = k;
        }
    }
}