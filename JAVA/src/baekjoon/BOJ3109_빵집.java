package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.14
 * 문제해결 방법 : 이것은 그리디인가? 디피인가?  솔찍히 잘 모르겠습니다...
 *
 * 문제 해결 방법 : 왼쪽 첫 줄 즉, 첫번째 열에서 DFS 수행
 * 이때 끝 오른쪽 까지 탐색 한 경우 answer++;
 * 하지만 기존 DFS와 다르게 약간의 스킬이 들어간다.
 *
 * 오른쪽 끝 마지막을 탐색한 경우
 * return하고 나머지 재귀를 수행하지 않고
 * 그 상태로 모든 동작을 멈춰야한다.
 *
 * 그리고 이미 간 곳은 가지 않는다 파이프가 겹치는 경우이기때문에
 * 아마 우선 순위가 위에 최대한 붙여서 이동시켜야하는 부분에서 그리디가 아닐까 생각된다.
 * 
 * 강사님 실습이 너무 어려워요 ㅠㅠ
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3109_빵집 {

    static int X, Y;

    // 방향 벡터 우선순위가 위 대각, 오른쪽, 아래 대각
    static int[] moveX = {1, 1, 1};
    static int[] moveY = {-1, 0, 1};

    static Character[][] map;

    // 오른쪽 끝에 도달한 경우 재귀의 동작을 멈추기 위한 flag변수
    static boolean flag;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        // 맵 정보 입력
        map = new Character[Y][X];
        for (int i = 0; i < Y; i++) {
            String in = br.readLine();
            for (int j = 0; j < X; j++) {
                map[i][j] = in.charAt(j);
            }
        }

        for (int i = 0; i < Y; i++) {
            // 왼쪽 첫 열들에서 dfs수행
            flag = false;
            dfs(i, 0);
        }

        System.out.println(answer);


    }

    static void dfs(int y, int x) {
        // 방문한 좌표 x
        map[y][x] = 'x';

        // 끝까지 도달한 경우
        if (x == X - 1) {
            // flag변수 true
            flag = true;
            // 정답 ++
            answer++;
            return;
        }

        // 3방향 탐색
        for (int i = 0; i < 3; i++) {

            // 다음 좌표
            int ny = y + moveY[i];
            int nx = x + moveX[i];

            // 범위 안이고                     다음 좌표가 x가 아니고      현재 끝까지 도달하지 않은 상태라면
            if (0 <= nx && nx < X && 0 <= ny && ny < Y && map[ny][nx] != 'x' && !flag) {
                //dfs 탐색!
                dfs(ny, nx);
                // 마지막 열 직전 이였다면 break;
                if (nx == X-1) break;
            }
        }
    }
}
