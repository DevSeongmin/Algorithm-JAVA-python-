package baekjoon;

import java.util.Scanner;

public class BOJ10798_세로읽기 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[][] answer = new char[15][15];

        int max = 0;

        for (int i = 0; i < 5; i++) {
            String tmp = input.next();
            max = Math.max(tmp.length(), max);

            for (int j = 0; j < tmp.length(); j++) {
                answer[i][j] = tmp.charAt(j);
            }
        }


        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (answer[j][i] != '\0'){
                    System.out.print(answer[j][i]);
                }
            }
        }



    }


}

