package b형특강.비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA10726_이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());


            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if ((M & ((1 << N) - 1)) == (1 << N) - 1) {
                sb.append("#" + tc + " ON\n");
            } else {
                sb.append("#" + tc + " OFF\n");
            }
        }

        System.out.println(sb);
    }
}
