package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19539_사과나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int oneCnt = 0;
        int twoCnt = 0;

        for (int tree : trees) {
            twoCnt += tree / 2;
            oneCnt += tree % 2;
        }


        while (oneCnt < twoCnt) {
            oneCnt+= 2;
            twoCnt--;
        }

        if (oneCnt != twoCnt) System.out.println("NO");
        else System.out.println("YES");
    }
}
