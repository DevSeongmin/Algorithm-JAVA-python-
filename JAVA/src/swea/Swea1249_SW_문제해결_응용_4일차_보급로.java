package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Swea1249_SW_문제해결_응용_4일차_보급로 {
    static int[] yMove = {0, 0, -1, 1};
    static int[] xMove = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = input.nextInt();
            int[][] arr = new int[N][N];
            int[][] time = new int[N][N];

            for (int i = 0; i < N; i++) {
                String tmp = input.next();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Character.getNumericValue(tmp.charAt(j));
                    time[i][j] = Integer.MAX_VALUE;
                }
            }

            Queue<int[]> Q = new LinkedList<>();
            time[0][0] = 0;
            Q.add(new int[]{0, 0});

            while (!Q.isEmpty()) {
                int[] directions = Q.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = directions[0] + yMove[i];
                    int nx = directions[1] + xMove[i];

                    if (0 <= ny & ny < N & 0 <= nx & nx < N) {
                        if (time[ny][nx] > time[directions[0]][directions[1]] + arr[ny][nx]) {
                            time[ny][nx] = arr[ny][nx] + time[directions[0]][directions[1]];
                            Q.add(new int[]{ny, nx});
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + time[N - 1][N - 1]);
        }
    }
}
