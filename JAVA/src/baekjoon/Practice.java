package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        System.out.println((multi(N, M) - 1) / (N - 1));


    }

    static long multi(long n, long m){

        if (m == 1) return n;

        if (m % 2 == 0) {
            return  ((multi(n, m / 2) % 1_000_000_007) * (multi(n, m / 2)% 1_000_000_007))  % 1_000_000_007 ;
        }

        return  ((multi(n, m / 2) % 1_000_000_007) *  (multi(n, m / 2)% 1_000_000_007) * n) % 1_000_000_007;
    }
}