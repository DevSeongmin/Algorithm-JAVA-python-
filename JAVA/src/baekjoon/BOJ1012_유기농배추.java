package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.17
 * 문제해결 DFS를 이용하여 지렁이의 개수를 구한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012_유기농배추 {

    static int X, Y;
    static int[] moveY = { -1, 1, 0, 0 };
    static int[] moveX = { 0, 0, -1, 1 };
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map = new int[Y][X];

            for (int i = 0; i < b; i++) {
                st = new StringTokenizer(br.readLine());
                int bx = Integer.parseInt(st.nextToken());
                int by = Integer.parseInt(st.nextToken());

                map[by][bx] = 1;
            }

            int answer = 0;
            for (int i = 0; i < Y; i++) {
                for (int j = 0; j < X; j++) {
                    if (map[i][j] == 1) {
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(answer);
        }

    }

    static void dfs(int y, int x) {

        map[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + moveY[i];
            int nx = x + moveX[i];

            if (0 <= nx && nx < X && 0 <= ny && ny < Y && map[ny][nx] == 1)
                dfs(ny, nx);
        }

    }
}
