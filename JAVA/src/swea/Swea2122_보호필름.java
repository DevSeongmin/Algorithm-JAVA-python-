package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea2122_보호필름 {

    static int Y, X, K, answer;
    static int[][] film;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());

            Y = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            film = new int[Y][X];

            for (int i = 0; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            sb.append("#" + tc + " ");
            if (check()) {
                sb.append(0 + "\n");
            } else {
                answer = Integer.MAX_VALUE;
                powerSet(0, 0);
                sb.append(answer + "\n");
            }

        }
        System.out.println(sb);
    }



    static void powerSet(int depth, int cnt){
        if (check()) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (depth == Y) return;

        if (cnt >= answer) return;

        int[] origin = Arrays.copyOf(film[depth], X);

        // 0으로 덮는 경우
        for (int i = 0; i < X; i++){
            film[depth][i] = 0;
        }
        powerSet(depth + 1, cnt + 1);


        // 1로 덮는 경우
        for (int i = 0; i < X; i++){
            film[depth][i] = 1;
        }

        powerSet(depth + 1, cnt + 1);


        // 그냥 두는 경우
        film[depth] = origin;
        powerSet(depth + 1, cnt);

    }


    // 성능테스트 통과 확인 메서드
    static boolean check() {

        for (int j = 0; j < X; j++) {
            boolean check = false;
            int tmp = 0;
            for (int i = 0; i < K; i++) {
                tmp += film[i][j];
            }
            if (tmp == 0 || tmp == K) {
                check = true;
                continue;
            }
            for (int i = K; i < Y; i++) {
                tmp += film[i][j];
                tmp -= film[i - K][j];
                if (tmp==0 || tmp == K){
                    check = true;
                }
            }

            if (!check) return false;

        }

        return true;
    }
}
