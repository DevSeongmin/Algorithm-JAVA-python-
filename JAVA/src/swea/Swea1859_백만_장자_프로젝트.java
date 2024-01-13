package swea;

import java.util.Scanner;

public class Swea1859_백만_장자_프로젝트 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = input.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = input.nextInt();

            long answer = 0;
            int maxVal = 0;

            for (int i = N - 1; i >= 0; i--) {

                if (arr[i] < maxVal) {
                    answer += maxVal - arr[i];
                } else {
                    maxVal = arr[i];
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
