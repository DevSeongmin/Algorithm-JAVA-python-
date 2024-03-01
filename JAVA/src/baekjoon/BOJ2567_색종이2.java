package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2567_색종이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[101][101];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            for (int y = Y; y < Y + 10; y++) {
                for (int x = X; x < X + 10; x++) {
                    map[y][x] = true;
                }
            }
        }


        int answer = 0;

        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {

                if (map[i][j]) {

                    int cnt = 4;
                    for (int d = 0; d < 4; d++) {
                        int ny = i + moveY[d];
                        int nx = j + moveX[d];

                        if (0 <= nx && nx < 101 && 0 <= ny && ny < 101 && map[ny][nx]) {
                            cnt--;
                        }
                    }

                    answer += cnt;
                }
            }
        }

        System.out.println(answer);

    }
}
