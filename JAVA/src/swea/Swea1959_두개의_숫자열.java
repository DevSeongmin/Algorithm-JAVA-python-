package swea;

import java.util.Scanner;

public class Swea1959_두개의_숫자열 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++){

            int N = input.nextInt();
            int M = input.nextInt();
            int answer = Integer.MIN_VALUE;

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            for (int i = 0; i < N; i++) {
                arr1[i] = input.nextInt();
            }

            for (int i = 0; i < M; i++) {
                arr2[i] = input.nextInt();
            }

            if (N <= M) {
                for (int i = 0; i <= M - N; i++) {
                    int tmp = 0;
                    for (int j = i; j < i + N; j++) {
                        tmp += arr1[j - i] * arr2[j];
                    }
                    answer = Math.max(answer, tmp);
                }


            } else {
                for (int i = 0; i <= N - M; i++) {
                    int tmp = 0;
                    for (int j = i; j < i + M; j++) {
                        tmp += arr1[j] * arr2[j - i];
                    }
                    answer = Math.max(answer, tmp);
                }
            }
            System.out.println("#" + tc + " " +  answer);
        }



    }
}
