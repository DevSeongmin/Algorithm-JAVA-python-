package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2140_지뢰찾기 {

    static int N;
    static int[] moveX = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] moveY = {0, 0, -1, 1, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '#') {
                    board[i][j] = -3;
                } else {
                    board[i][j] = s.charAt(j) - '0';
                }
            }
        }


        int answer = 0;

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if (board[i][j] == -3) {
                    boolean check = true;

                    for (int k = 0; k < 8; k++) {
                        int ny = i + moveY[k];
                        int nx = j + moveX[k];

                        if (board[ny][nx] == -3) continue;
                        if (board[ny][nx] == 0) {
                            check = false;
                            break;
                        }
                    }

                    if (check) {
                        answer++;
                        for (int k = 0; k < 8; k++) {
                            int ny = i + moveY[k];
                            int nx = j + moveX[k];

                            if (board[ny][nx] == -3) continue;

                            board[ny][nx] -= 1;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
