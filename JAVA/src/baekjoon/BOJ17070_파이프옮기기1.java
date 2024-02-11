package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.11
 * 문제 해결 방법
 *  좌표 상에서 파이프를 둘 수 있는 경우들을 DFS로 탐색하여 끝까지 간 경우
 *  count ++ 해주어 답을 구할 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17070_파이프옮기기1 {

                    //오른쪽 대각 아래
    static int[] moveX = {1, 1, 0};
    static int[] moveY = {0, 1, 1};
    static int[][] map;
    static int answer = 0;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        N = Integer.parseInt(br.readLine());

        // 맵 표현
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // dfs 탐색
        dfs(0, 1, 0);
        System.out.println(answer);


    }

    static void dfs(int y, int x, int direction) {

        // 끝좌표라면 answer++
        if (y == N - 1 && x == N - 1) {
            answer ++;
            return;
        }

        // 파이프를 두는 경우 탐색
        for (int i = 0; i < 3; i++) {
            // 오른쪽에 둔 경우 아래쪽으로 둘 수 없다 .
            // 아래쪽에 둔 경우도 오른쪽으로 둘 수 없다.
            // 즉 좌표 벡터의 차이가 2라면 건너뛴다.
            if (Math.abs(i - direction) == 2) continue;

            // 다음 좌표
            int ny = y + moveY[i];
            int nx = x + moveX[i];

            // 다음좌표가 map좌표 범위 안에 있으며 0의 값이라면
            if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx] == 0) {

                // 만약 이번에 파이프를 대각선짜리를 둔다면
                if (i == 1) {
                    // 대각선 파이프가 벽을 안긁는 경우에만 DFS탐색
                    if (map[ny - 1][nx] == 0 && map[ny][nx - 1] == 0) dfs(ny, nx, i);
                } else {
                    // 대각선 짜리 파이프가 아니라면 DFS탐색
                    dfs(ny, nx, i);
                }
            }
        }
    }
}
