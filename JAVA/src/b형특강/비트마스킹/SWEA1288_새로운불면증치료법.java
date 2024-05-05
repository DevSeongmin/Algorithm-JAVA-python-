package b형특강.비트마스킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1288_새로운불면증치료법 {

    static final int CHECK = (1 << 10) - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int myCheck = 0;

            int N = Integer.parseInt(br.readLine());

            int mul;
            for (mul = 1; ; mul++) {

                int curNum = N * mul;

                while (curNum > 0) {
                    int shift = curNum % 10;

                    myCheck |= (1 << (shift));
                    curNum /= 10;
                }
                if (myCheck == CHECK) break;
            }

            sb.append("#" + tc + " " + (mul * N) + "\n");
        }

        System.out.println(sb);
    }

}
