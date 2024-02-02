package swea;

import java.util.Scanner;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.01
 * 문제 해결 방법 N * N의 메트릭스에서 선택된 좌표 기준으로 M만큼의 십자가 모양으로
 * 스프레이를 분사할 수 있다. 상하좌우 ,   상하좌우를 45도 회전한 십자가 모양
 * 모든 좌표에서 계산하여 문제 해결
 */
public class Swea12712_파리퇴치3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 테스트 케이스 개수 입력
        int T = input.nextInt();

        // 테스트 케이스 수 만큼 반복
        for (int tc = 1; tc <= T; tc++) {
            int N = input.nextInt();
            int S = input.nextInt() - 1;
            int answer = 0;

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = input.nextInt();
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 시작점은 두번 더해지므로 한번 빼고 시작
                    int tmp_1 = -arr[i][j];
                    int tmp_2 = -arr[i][j];

                    for (int k = -S; k <= S; k++) {

                        // 해당 좌표를 기준으로 좌우를 탐색하는 코드 
                        if (0 <= j + k & j + k < N) {
                            tmp_1 += arr[i][j+k];
                        }
                        
                        // 해당 좌표를 기준으로 상하를 탐색하는 코드
                        if (0 <= i + k & i + k < N) {
                            tmp_1 += arr[i + k][j];
                        }

                        // 우, 상 대각선 좌 하 대각선 체크
                        if ((0 <= i + k & i + k < N) & (0 <= j + k & j + k < N)) {
                            tmp_2 += arr[i+k][j+k];
                        }
                        // 우 하 대각선 좌 상 대각선 체크 
                        if ((0 <= i + k & i + k < N) & (0 <= j - k & j - k < N)) {
                            tmp_2 += arr[i+k][j-k];

                        }

                    }
                    // 정답 변수를 지금까지중의 가장 큰 수로
                    answer = Math.max(answer, tmp_1);
                    answer = Math.max(answer, tmp_2);
                }
            }

            // 정답 출력
            System.out.print("#" + tc + " ");
            System.out.println(answer);

        }


    }
}

