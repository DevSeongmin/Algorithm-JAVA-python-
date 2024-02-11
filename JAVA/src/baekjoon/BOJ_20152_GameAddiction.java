package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20152_GameAddiction {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a == b) {
            System.out.println(1);
            return;
            // a를 더 작은값으로
        }  else if(a > b){
            int tmp = b;
            b = a;
            a = tmp;
        }


        long[][] map = new long[b+1][b+1];


        for (int i = (int)a; i <= b; i++) {
            for (int j = (int)a; j <= b; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = (int)a; i <= b; i++) {
            for (int j = (int)a; j <= b; j++) {
                if (i > j) map[i][j] = 0;
            }
        }


//        for (int[] m : map) System.out.println(Arrays.toString(m));

        long answer = 0;
        for (int i = 1; i <= b; i++) {
            for (int j = 1; j <= b; j++) {
                if(map[i][j] == 1){
                    map[i][j] = Math.max(map[i][j-1] + map[i-1][j], map[i][j]);
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        System.out.println(answer);

    }
}
