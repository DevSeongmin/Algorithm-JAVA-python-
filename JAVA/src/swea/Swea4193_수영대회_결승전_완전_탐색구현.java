package swea;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Swea4193_수영대회_결승전_완전_탐색구현 {
    static int[] xMove = new int[]{1, 0, -1, 0, 0};
    static int[] yMove = new int[]{0, -1, 0, 1, 0};

    public static boolean dfs(int y, int x, int[][] arr, int[] end) {
        int N = arr.length;
        arr[y][x] = 1;

        if (end[0] == y & end[1] == x) {
            return true;
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = y + yMove[i];
                int nx = x + xMove[i];
                if (0 <= nx & nx < N & 0 <= ny & ny < N) {
                    if (arr[ny][nx] != 1) {
                        return dfs(ny, nx, arr, end);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {


            int N = input.nextInt();
            int[][] arr = new int[N][N];
            int[][] tmp_arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp = input.nextInt();
                    arr[i][j] = tmp;
                    tmp_arr[i][j] = tmp;
                }
            }

            int[] start = new int[2];
            int[] end = new int[2];

            for (int i = 0; i < 2; i++) {
                start[i] = input.nextInt();
            }

            for (int i = 0; i < 2; i++) {
                end[i] = input.nextInt();
            }

            boolean check = dfs(start[0], start[1], tmp_arr, end);

            if (!check) {
                System.out.println("#" + tc + " " + -1);
            } else {


                Queue<int[]> q = new ArrayDeque<>();
                int[] chunk = new int[]{start[0], start[1], 0};
                q.add(chunk);

                while (!q.isEmpty()) {
                    int[] tmp = q.poll();
                    if (tmp[0] == end[0] & tmp[1] == end[1]) {
                        System.out.println("#" + tc + " " + tmp[2]);
                        break;
                    }

                    for (int i = 0; i < 5; i++) {
                        int ny = tmp[0] + yMove[i];
                        int nx = tmp[1] + xMove[i];

                        if (0 <= nx & nx < N & 0 <= ny & ny < N) {
                            int[] t = {ny, nx, tmp[2] + 1};
                            if (arr[ny][nx] == 0) {
                                q.add(t);
                            } else if (arr[ny][nx] == 2 & tmp[2] % 3 == 2) {
                                q.add(t);
                            }
                        }
                    }
                }
            }
        }

    }
}
