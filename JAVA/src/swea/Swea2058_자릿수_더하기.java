package swea;

import java.util.Scanner;

public class Swea2058_자릿수_더하기 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int answer = 0;

        while (N > 0) {

            answer += N % 10;
            N /= 10;
        }

        System.out.println(answer);


    }

}
