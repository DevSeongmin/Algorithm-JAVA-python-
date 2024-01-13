package swea;

import java.util.Scanner;

public class Swea2068_최대수_구하기 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int answer = 0;

            for (int i = 0; i < 10; i++) {
                answer = Math.max(answer, input.nextInt());
            }

            System.out.println("#" + tc + " " + answer);
        }

    }
}
