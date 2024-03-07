package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea5656_별돌깨기 {

    static int Y, X, N, answer;
    static int[][] board;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            board = new int[Y][X];

            for (int i = 0; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            answer = Integer.MAX_VALUE;
            simulation(0);
            sb.append("#" + tc + " " + answer + "\n");

        }
        System.out.println(sb);

    }


    static void simulation(int depth) {
        if (depth == N) {
            answer = Math.min(answer, counting());
            return;
        }

        // 시뮬 전 맵 복사
        int[][] origin = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            origin[i] = Arrays.copyOf(board[i], X);
        }


        //i 번째칸에 벽돌 떨어뜨리기
        for (int i = 0; i < X; i++) {


            for (int j = 0; j < Y; j++) {
                if (board[j][i] != 0) {
                    bomb(j, i, board[j][i]);
                    brickDown();
                    break;
                }
            }


            simulation(depth + 1);
            for (int c = 0; c < Y; c++) {
                board[c] = Arrays.copyOf(origin[c], X);
            }
        }

    }

    static int counting() {
        int res = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] != 0) {
                    res++;
                }
            }
        }
        return res;
    }


    static void brickDown() {
        for (int j = 0; j < X; j++) {
            for (int i = Y - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    int brickY = i;

                    while (isIn(brickY + 1, j) && board[brickY + 1][j] == 0) {
                        brickY++;
                    }


                    if (brickY != i) {
                        board[brickY][j] = board[i][j];
                        board[i][j] = 0;
                    }
                }
            }
        }
    }


    static void bomb(int y, int x, int n) {
        board[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;

            for (int j = 0; j < n - 1; j++) {
                ny += moveY[i];
                nx += moveX[i];

                if (!isIn(ny, nx)) continue;

                if (board[ny][nx] != 0) {
                    bomb(ny, nx, board[ny][nx]);
                }
            }
        }
    }


    static boolean isIn(int y, int x) {
        return 0 <= y && y < Y && 0 <= x && x < X;
    }
}
