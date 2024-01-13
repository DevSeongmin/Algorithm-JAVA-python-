package swea;

import java.util.Scanner;

public class Swea1926_간단한_369게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print("1 ");
        for (int i = 2; i <= N; i++) {

            String tmp = Integer.toString(i);
            tmp = tmp.replaceAll("[369]", "-");
            if (tmp.contains("-")) {
                tmp = tmp.replaceAll("[^-]", "");
            }

            System.out.print(tmp + " ");

        }

    }
}
