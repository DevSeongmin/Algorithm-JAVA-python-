package swea;

import java.util.Scanner;

public class Swea1204_SW문제해결기본_1일차최빈수_구하기 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            tc = input.nextInt();


            int[] arr = new int[101];

            for (int i = 0; i < 1000; i++) {
                arr[input.nextInt()] += 1;
            }

            int answer = 0;
            int value = 0;
            for (int i = 0; i <= 100; i++) {
                if (arr[i] >= value) {
                    value = arr[i];
                    answer = i;
                }
            }
            System.out.println("#" + tc + " " + answer);

        }



    }
}
