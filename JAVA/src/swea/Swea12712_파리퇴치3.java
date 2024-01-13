package swea;

import java.util.Scanner;

public class Swea12712_파리퇴치3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = input.nextInt();
            int S = input.nextInt() - 1;
            int answer = 0;

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = input.nextInt();
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int tmp_1 = -arr[i][j];
                    int tmp_2 = -arr[i][j];

                    for (int k = -S; k <= S; k++) {
                        if (0 <= j + k & j + k < N) {
                            tmp_1 += arr[i][j+k];
                        }
                        if (0 <= i + k & i + k < N) {
                            tmp_1 += arr[i + k][j];
                        }
                        if ((0 <= i + k & i + k < N) & (0 <= j + k & j + k < N)) {
                            tmp_2 += arr[i+k][j+k];

                        }
                        if ((0 <= i + k & i + k < N) & (0 <= j - k & j - k < N)) {
                            tmp_2 += arr[i+k][j-k];

                        }

                    }
                    answer = Math.max(answer, tmp_1);
                    answer = Math.max(answer, tmp_2);
                }
            }

            System.out.print("#" + tc + " ");
            System.out.println(answer);

        }


    }
}

