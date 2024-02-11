package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.11
 * 문제 해결 : 레벨 햄버거는 빵 (이전버거) 패티 (이전버거) 빵
 * 으로 이루어져있다.
 * 분할정복을 이용하여 문제를 해결한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16974_레벨햄버거 {

    static long[] pattys;
    static long[] levelBurgers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        long target = Long.parseLong(input[1]);

        levelBurgers = new long[N + 1];
        levelBurgers[0] = 1;

        pattys = new long[N + 1];
        pattys[0] = 1;


        // 현재 N레벨 버거에 들어있는 패티 수
        long patty = 1;


        // N 레벨 버거의 패티 + 빵 수
        long burgers = 1;
        for (int i = 0; i < N; i++) {
            burgers = burgers * 2 + 3;
            levelBurgers[i + 1] = burgers;
            patty = patty * 2 + 1;
            pattys[i + 1] = patty;
        }

        recursion(target, patty, N);
    }


    static void recursion(long target, long patty, int level) {
        // 레벨이 0이라면 현재 패티 출력
        if (level == 0) {
            System.out.println(patty);
            return;
        }

        long mid = levelBurgers[level - 1] + 2;

        // 현재 먹어야하는 개수가 1이라면
        if (target == 1) {
            System.out.println(patty - pattys[level]);
            return;
        }

        // 중간 패티가 들어있는 지점보다 작다면
        else if (target < mid) {
            recursion(target - 1, patty - pattys[level - 1] - 1, level - 1);

            // 중간 지점이라면
        } else if (target == mid) {
            System.out.println(patty - pattys[level - 1]);
            return;
        }

        // 중간 지점보다 크다면
        else if (target > mid) {
            recursion(target - levelBurgers[level - 1] - 2, patty, level - 1);
        }
        // 현재 햄버거를 다 먹는다면
        else if (target == levelBurgers[level]) {
            System.out.println(patty);
            return;
        }


    }
}
