/***
 * 작성자 : 황성민
 * 작성일자 24.01.17
 * 문제 해결 및 풀이 : https://blog.naver.com/steadydeveloper/223325711700
 */

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12865_평범한_배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numWeight = br.readLine().split(" ");

        // 물건들의 개수
        int itemsCount = Integer.parseInt(numWeight[0]);
        // 배낭의 담을 수 있는 최대 무게
        int maxWeight = Integer.parseInt(numWeight[1]);

        // 물건들의 정보
        int[][] items = new int[itemsCount + 1][2];

        //DP 배열
        int[][] DP = new int[itemsCount + 1][maxWeight + 1];


        // 물건 정보 입력
        for (int i = 0; i < itemsCount + 1; i++) {
            // 0번째일경우는 아무 물건도 선택하지 않은 경우르 [0, 0]으로 값 설정
            if (i == 0) {
                items[i][0] = 0;
                items[i][1] = 0;
            }
            // 물건들 정보 입력 [무게, 가치]
            else{
                String[] weightValue = br.readLine().split(" ");
                items[i][0] = Integer.parseInt(weightValue[0]);
                items[i][1] = Integer.parseInt(weightValue[1]);
            }
        }

        // i가 0번째라면 아무물건도 고르지않은경우로 0
        // weight가 0이라면 아무 물건도 넣을 수 없으므로 0
        for (int i = 1; i < itemsCount + 1; i++) {
            for (int weight = 1; weight < maxWeight + 1; weight++) {

                // 현재 선택된 물건의 무게
                int w = items[i][0];
                // 현재 선택된 물간의 가치
                int v = items[i][1];

                // 현재 weight인덱스가 선택된 물건의 무게보다 크다면
                if (weight >= w) {

                    // 한칸 위의 값             DP배열의 이전 선택에서 - 현재 선택된 무게 인덱스 + 현재 선택된 물건의 가치
                    // max(DP[i-1][weight],   DP[i-1][weight-w] + v)
                    DP[i][weight] = Math.max(DP[i - 1][weight], DP[i - 1][weight - w] + v);
                } else {
                    DP[i][weight] = DP[i - 1][weight];
                }
            }
        }

        // 정답 출력
        System.out.println(DP[itemsCount][maxWeight]);
    }
}
