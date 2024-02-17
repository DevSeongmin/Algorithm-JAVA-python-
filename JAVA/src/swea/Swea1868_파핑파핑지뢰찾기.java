package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.16
 *
 * 문제해결 방법 주변에 지뢰가 없는 칸 즉 0인칸에서 BFS탐색을 한다.
 * 이 때 0일 경우 이어서 탐색하고 숫자가 있으면 그곳의 방문여부는 true로 만들고 더이상 탐색 X가 핵심
 */

public class Swea1868_파핑파핑지뢰찾기 {

    static int[] moveX = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[] moveY = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int N;
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {


            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            // 지뢰위치 -1 로
            for (int i = 0; i < N; i++) {
                input = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    if (input[j].equals("*")) {
                        map[i][j] = -1;
                        visited[i][j] = true;
                    }
                }
            }


            // 지뢰 주변 숫자 까지
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == -1) {

                        for (int k = 0; k < 8; k++) {
                            int ny = i + moveY[k];
                            int nx = j + moveX[k];

                            if (isin(ny, nx) && map[ny][nx] != -1) {
                                map[ny][nx]++;
                            }
                        }

                    }
                }
            }


            int answer = 0;

            // 0 인칸에서 정답 ++ , BFS탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == 0) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }


            // 방문안한곳 하나당 정답 ++
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) answer++;
                }
            }

            //정답 출력
            System.out.println("#" + tc + " " + answer);

        }

    }

    // 범위 안 인지 확인하는 메서드
    static boolean isin(int y, int x) {
        if (0 <= y && y < N && 0 <= x && x < N) return true;
        return false;
    }


    // BFS탐색
    static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            y = tmp[0];
            x = tmp[1];


            for (int i = 0; i < 8; i++) {
                int ny = y + moveY[i];
                int nx = x + moveX[i];

                if (isin(ny, nx) && !visited[ny][nx]) {
                    // 방문 안했다면 True
                    visited[ny][nx] = true;
                    // 다음좌표가값이 0일때만 이어서 탐색
                    if (map[ny][nx] == 0) q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
