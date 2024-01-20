package baekjoon;

import java.util.Scanner;

public class BOJ11729_하노이탑_이동_순서 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();


        System.out.println((int)Math.pow(2,N)-1);
        hanoi(1,2,3,N);
        System.out.println(sb);

    }

    public static void hanoi(int start, int tmp, int end, int N) {
        if (N==1){
            sb.append(start + " " + end + "\n");
            return;
        }

        hanoi(start, end, tmp, N - 1);
        sb.append(start + " " + end + "\n");
        hanoi(tmp, start, end, N-1);
    }
}
