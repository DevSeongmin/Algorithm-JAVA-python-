package swea;

import java.util.Scanner;

public class Swea2072_홀수만_더하기 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int sum = 0;

            for (int i = 0; i < 10; i++) {
                int tmp = input.nextInt();
                if (tmp % 2 == 1) {
                    sum += tmp;
                }
            }
            System.out.println("#" + tc + " " + sum);
        }

    }
}
