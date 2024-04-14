package baekjoon;

/**
 * 작성자 : 황성민
 * 작성 일자 : 24.03.30
 * 문제 해결 : 물건의 개수가 여러개이다. Multiple - knapsack 문제
 *             이 경우 무식하게 물건 1나부터 10개 까지 다 하는 경우를 개선할 수 있다.
 *             만약 물건 개수가 6개라면?
 *             1 2 3 으로 나눠서 각각의 아이템을 넣어주면 1개부터 6개를 넣는 모든 경우를 커버할 수 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ12920_평범한배낭2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int MAX_WEIGHT = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());


            // 이진수를 이용해서 물건 패키징하기
            int binaryCnt = 0;
            // 2진수 1... 2... 4.. 8... 씩 빼가면 아이템을 묶어준다.
            while (cnt > 0) {
                int bin = (1 << binaryCnt);
                if (cnt >= bin) {
                    items.add(new Item(weight * bin, value * bin));
                    cnt -= bin;

                // 증가한 2진수 보다 남은 카운트가 더 적은경우 카운트만큼 패키징해서 넣어주고 break;
                } else {
                    items.add(new Item(weight * cnt, value * cnt));
                    break;
                }
                binaryCnt++;
            }
        }


        // Knapsack 알고리즘 진행
        int[] DP = new int[MAX_WEIGHT + 1];
        for (int i = 0; i < items.size(); i++) {
            Item curIem = items.get(i);
            for (int j = MAX_WEIGHT; j >= curIem.weight; j--) {
                if (j >= curIem.weight) {
                    DP[j] = Math.max(DP[j], curIem.value + DP[j - curIem.weight]);
                }
            }
        }


        // 정답 출력
        System.out.println(DP[MAX_WEIGHT]);
    }


    static class Item {
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
