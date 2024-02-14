package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.14
 * 문제해결 방식 : 분할 정복을 이용하여 해결한다.
 *              기저조권 : 모든 값이 같을 때
 *              값이 달라 4 구역을 재귀로 파고들 때는 (를 열어준다.
 *              나눈 4구역을 모두 탐색하면 )를 닫아준다.
 */
public class BOJ1992_쿼드트리 {

    static String[][] map;
    static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        answer = "";

        // 맵 입력
        int N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
            }
        }


        // 분할 정복
        recursion(0, 0, N);
        // 정답 출력
        System.out.println(answer);

    }

    static void recursion(int y, int x, int n) {

        // 사각형기준 0, 0 맨 왼쪽 위 값을 기준값으로
        String standard = map[y][x];


        for (int i = y; i < y + n; i++){
            for (int j = x; j < x + n; j++) {
                // 기준값과 하나라도 다른게 있다면 분할정복
                if (!map[i][j].equals(standard)){
                    // 우선 괄호를 열어준다.
                    answer += "(";

                    // 좌상 우상 좌하 우하 순으로 분할정복
                    recursion(y, x, n/2);
                    recursion(y, x+n/2, n/2);
                    recursion(y+n/2, x, n/2);
                    recursion(y+n/2, x+n/2, n/2);

                    // 4구역 탐색이 끝나면 괄호 닫기
                    answer += ")";
                    return;
                }
            }
        }

        // 모두 같다면 수 정답에 넣기
        answer += standard;
    }

}
