package swea;

import java.util.Scanner;

public class Swea195_달팽이_숫자 {

    static int[] xMove = {1, 0, -1, 0};
    static int[] yMove = {0, 1, 0, -1};


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {



            int N = input.nextInt();
            int[][] snail = new int[N][N];
            int[] cur = {0, 0};
            int idx = 0;


            for (int i = 1; i <= N * N; i++) {
                snail[cur[0]][cur[1]] = i;

                int cnt = 0;
                while (cnt < 3) {
                    cnt++;
                    int nx = cur[1] + xMove[idx];
                    int ny = cur[0] + yMove[idx];

                    if ((0 <= nx & nx < N) & (0 <= ny & ny < N)) {
                        if (snail[ny][nx] == 0) {
                            cur[0] = ny;
                            cur[1] = nx;
                            break;
                        } else {
                            idx = (idx + 1) % 4;
                        }
                    } else {
                        idx = (idx + 1) % 4;
                    }
                }
            }
            System.out.println("#" + tc);
            for (int[] sn : snail) {
                for (int i : sn) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}
