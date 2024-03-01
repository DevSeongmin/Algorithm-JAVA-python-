package baekjoon;

/** 작성자 : 황성민
 * 작성일자 : 24.03.01
 * 문제 해결 : 시작점을 제외하고 NextPermutation을 돌려 시작점부터 다 돌고 다시 시작점으로 오는
 *                  비용을 계산하여 문제를 해결한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10971_외판원순회2 {

    // 넥퍼 돌릴 배열
    static int[] permu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 가지 못하는 곳은 무한으로 설정
        double INF = Double.POSITIVE_INFINITY;

        double[][] map = new double[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 경로가 없다면 무한
                if (map[i][j] == 0) {
                    map[i][j] = INF;
                }
            }
        }

        // 시작점을 제외하고 돌릴 넥퍼 배열
        permu = new int[N-1];
        for (int i = 1; i < N; i++){
            permu[i-1] = i;
        }

        // 정답 초기에는 무한으로
        double answer = Integer.MAX_VALUE;

        do {

            // 넥퍼 배열에 정해진 순서로 모두 돌기
            double cost = map[0][permu[0]];

            for (int i = 0; i < permu.length-1; i++){
                cost += map[permu[i]][permu[i+1]];

            }

            cost += map[permu[permu.length-1]][0];

            // 현재 정답보다 작다면 정답으로
            answer = Math.min(answer, cost);

        } while (nextPermu());


        // 정답 출력
        System.out.println((int) answer);

    }

    // 넥퍼 메서드
    static boolean nextPermu(){
        int N = permu.length;

        int i = N-1;

        while(0 < i && permu[i-1] >= permu[i]) --i;

        if (i == 0) return false;

        int j = N-1;

        while (permu[i - 1] >= permu[j]) --j;

        swap(i - 1, j);

        int k = N-1;

        while (i < k) swap(i++, k--);

        return true;
    }

    static void swap(int i, int j){
        int tmp = permu[i];
        permu[i] = permu[j];
        permu[j] = tmp;
    }
}
