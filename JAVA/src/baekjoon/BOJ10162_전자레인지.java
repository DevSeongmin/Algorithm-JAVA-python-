package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162_전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A = N / 300;
        N %= 300;
        int B = N / 60;
        N %= 60;
        int C = N / 10;
        N %= 10;
        if (N == 0) {
            System.out.println(A + " " + B + " " + C);
        } else{
            System.out.println(-1);
        }
    }
}
