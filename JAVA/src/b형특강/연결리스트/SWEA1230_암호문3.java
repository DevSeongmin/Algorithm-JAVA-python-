package b형특강.연결리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1230_암호문3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            LinkedList<Integer> codes = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                codes.add(Integer.parseInt(st.nextToken()));
            }

            int commends = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int cnt = 0;
            while (cnt < commends) {
                cnt++;
                String commend = st.nextToken();

                switch (commend) {
                    case "I": {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());

                        for (int i = 0; y > i; i++) {
                            codes.add(x + i, Integer.parseInt(st.nextToken()));
                        }
                        break;


                    }
                    case "D": {

                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());

                        for (int i = 0; i < y; i++) {
                            codes.remove(x);
                        }
                        break;
                    }

                    case "A": {

                        int x = Integer.parseInt(st.nextToken());
                        for (int i = 0; x > i; i++) {
                            codes.add(Integer.parseInt(st.nextToken()));
                        }
                        break;
                    }

                }
            }
            sb.append("#" + tc + " ");
            for (int i = 0; i < 10; i++) {
                sb.append(codes.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
