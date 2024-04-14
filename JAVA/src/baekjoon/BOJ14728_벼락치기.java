package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.03.30
 * 문제 해결 : 0-1 Knapsack 메모리 최적화
 */

public class BOJ14728_벼락치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int MAX_WEIGHT = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        // 1차원 DP배열 선언
        int[] DP = new int[MAX_WEIGHT + 1];

        for (int i = 0; i < N; i++) {
            Item curItem = items[i];


            // 이미 고려한 물건을 또 고려하지 않기 위해 뒤에서 부터
            for (int j = MAX_WEIGHT; j >= 0; j--) {

                if (j >= curItem.weight) {
                    DP[j] = Math.max(DP[j],
                            curItem.value + DP[j - curItem.weight]);
                }
            }
        }


        System.out.println(DP[MAX_WEIGHT]);
    }


    static class Item {
        int weight, value;

        public Item(int weight, int value) {
            this.value = value;
            this.weight = weight;
        }
    }
}