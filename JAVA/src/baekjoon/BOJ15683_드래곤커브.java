package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.03.01
 * 문제 해결 : 세대별 드래곤이 꺽는 정보는 일정 패턴이 있다.
 *            패턴 --- >>     2세대 드래곤 : 왼왼오
 *                      3세대 드레곤   왼왼오       왼       왼오오
 *                             2세대 그래도     가운데 왼    뒤쪽 2세대 앞뒤로 뒤집고 반전
 *            세대별로 꺽는 정보 저장 후 맵에 그려준다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683_드래곤커브 {

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맵 길이 최대 100 x 100
        boolean[][] map = new boolean[101][101];

        // 0세대는 없다 직진만   1 세대는 왼쪽으로 꺽는다
        ArrayList<Integer>[] generation = new ArrayList[11];
        for (int i = 0; i <= 10; i++) {
            generation[i] = new ArrayList<>();
        }
        generation[1].add(1);

        // 세대별 꺽는 정보 패턴을 이용해 저장
        for (int i = 2; i <= 10; i++) {

            // 전세대
            for (int direction : generation[i - 1]) {
                generation[i].add(direction);
            }

            // 왼쪽 추가
            generation[i].add(1);

            // 전세대 뒤집고 반전
            for (int j = generation[i - 1].size() - 1; j >= 0; j--) {
                int direction = generation[i - 1].get(j) == -1 ? 1 : -1;
                generation[i].add(direction);
            }
        }


        // 입력
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            // 각각의 정보대로 맵을 그린다.


            map[y][x] = true;
            y += moveY[d];
            x += moveX[d];
            map[y][x] = true;

            for (int j = 0; j < ((1 << g) - 1); j++) {

                d += generation[g].get(j);

                if (d == -1) d = 3;
                if (d == 4) d = 0;

                y += moveY[d];
                x += moveX[d];
                map[y][x] = true;
            }
        }


        // 사각형 현재, 오른쪽 , 아래쪽,  오른쪽아래쪽이 트루라면 개수++;
        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    answer++;
                }
            }
        }

        // 정답 출력
        System.out.println(answer);
    }
}
