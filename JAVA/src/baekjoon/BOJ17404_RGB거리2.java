package baekjoon;

/**
 *  작성자 : 황성민
 * 작성일자 24.01.20
 * 문제 해결 및 풀이 : https://blog.naver.com/steadydeveloper/223328405098
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ17404_RGB거리2 {

    static int[][] DP;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DP = new int[N][3];
        int answer = Integer.MAX_VALUE;


        // DP 배열 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                DP[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 0번, 1번, 2번에서 시작하는 경우 각각 계산
        for (int start = 0; start < 3; start++) {
            int[][] arr = deepCopy(DP);
            //각 시작점에서 점화식 수행 후 최솟값을 정답으로 갱신
            answer = Math.min(answer, solutions(start, arr));
        }
        // 정답 출력
        System.out.println(answer);
    }


    // 2차원 배열을 깊은 복사하기 위한 메서드 
    static int[][] deepCopy(int[][] arr) {
        int[][] returnArr = new int[N][3];
        for (int i = 0; i < N; i++) {
            returnArr[i] = arr[i].clone();
        }
        return returnArr;
    }

    // 점화식 수행 메서드 
    static int solutions(int start, int[][] arr) {
        // 마지막 RGB값은 시작점과 달라야한다. 
        arr[N-1][start] = 1000*1000;
        // 시작점 말고 다른 RGB색에서 시작하는 경우 제외하기위해 큰수로 초기화
        arr[0][(start+1)%3] += 1000*1000;
        arr[0][(start+2)%3] += 1000*1000;


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    // 점화식 이전 인덱스와 다르면서 가장 작은 값 찾기
                    if (j != k) {
                        min = Math.min(min, arr[i - 1][k]);
                    }
                }
                arr[i][j] += min;
            }
        }
        //마지막 까지 도달했을 때 RGB의 합이 가장 작은 값 반환
        return Math.min(Math.min(arr[N - 1][0], arr[N - 1][1]), arr[N - 1][2]);
    }
}
