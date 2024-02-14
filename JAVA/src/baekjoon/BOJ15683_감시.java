package baekjoon;

/**
 * 작성자 : 황성민
 * 작성 일자 : 24.02.12
 * 문제 해결 : 빡구현 한다...
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ15683_감시 {

    static int Y, X;
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, -1, 0, 1};
    static int[][] map;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<int[]> cctvs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        map = new int[Y][X];

        // CCTV정보를 담는 리스트   요소는 int[]로   y좌표, x좌표, cctv번호가 들어간다.
        cctvs = new ArrayList<>();


        // 맵 정보를 담고 CCTV정보는 CCTV리스트에 담아둔다.
        for (int i = 0; i < Y; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < X; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                // 0은 빈칸    // 6은 벽
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new int[]{i, j, map[i][j]});
                }
            }
        }


        // 5번 CCTV 4방향 CCTV는 미리 처리
        for (int i = cctvs.size() - 1; i >= 0; i--) {
            if (cctvs.get(i)[2] == 5) {
                int y = cctvs.get(i)[0];
                int x = cctvs.get(i)[1];

                // 볼 수 있는 부분은 -1로 처리
                map[y][x] = -1;

                for (int j = 0; j < 4; j++) {
                    int ny = y + moveY[j];
                    int nx = x + moveX[j];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {

                        map[ny][nx] = -1;
                        ny += moveY[j];
                        nx += moveX[j];
                    }
                }
                // 5번 CCTV를 CCTV리스트에서 제거
                cctvs.remove(i);
            }
        }
        setAnswer();


        // CCTV 시뮬레이션 시작
        backTracking(0, 0);
        System.out.println(answer);

    }


    // 조합을 이용하여 모든 CCTV를 돌았을 때 정답을 갱신해준다.
    static void backTracking(int depth, int s) {
        if (depth == cctvs.size()) {
            setAnswer();
            return;
        }

        // 변형전 원본 저장
        int[][] original = new int[Y][X];
        for (int i = 0; i < Y; i++) original[i] = Arrays.copyOf(map[i], X);


        // CCTV개수만큼 combination 돌리기
        for (int i = s; i < cctvs.size(); i++) {
            int[] cctv = cctvs.get(i);

            // 1번 CCTV를 만나면
            if (cctv[2] == 1) {
                map[cctv[0]][cctv[1]] = -1;
                for (int j = 0; j < 4; j++) {
                    int ny = cctv[0] + moveY[j];
                    int nx = cctv[1] + moveX[j];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {

                        map[ny][nx] = -1;
                        ny += moveY[j];
                        nx += moveX[j];
                    }

                    backTracking(depth + 1, i + 1);

                    for (int k = 0; k < Y; k++) map[k] = Arrays.copyOf(original[k], X);
                }
            }


            // 2번 CCTV를 만나면
            if (cctv[2] == 2) {
                map[cctv[0]][cctv[1]] = -1;


                for (int j = 0; j < 2; j++) {
                    int ny = cctv[0] + moveY[j];
                    int nx = cctv[1] + moveX[j];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {

                        map[ny][nx] = -1;
                        ny += moveY[j];
                        nx += moveX[j];
                    }

                    ny = cctv[0] - moveY[j];
                    nx = cctv[1] - moveX[j];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {

                        map[ny][nx] = -1;
                        ny -= moveY[j];
                        nx -= moveX[j];
                    }

                    backTracking(depth + 1, i + 1);

                    for (int k = 0; k < Y; k++) map[k] = Arrays.copyOf(original[k], X);
                }
            }


            // 3번 CCTV를 만나면
            if (cctv[2] == 3) {
                map[cctv[0]][cctv[1]] = -1;
                for (int j = 0; j < 4; j++) {
                    int ny = cctv[0] + moveY[j];
                    int nx = cctv[1] + moveX[j];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {
                        map[ny][nx] = -1;
                        ny += moveY[j];
                        nx += moveX[j];
                    }

                    ny = cctv[0] + moveY[(j + 1) % 4];
                    nx = cctv[1] + moveX[(j + 1) % 4];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {
                        map[ny][nx] = -1;
                        ny += moveY[(j + 1) % 4];
                        nx += moveX[(j + 1) % 4];
                    }

                    backTracking(depth + 1, i + 1);

                    for (int k = 0; k < Y; k++) map[k] = Arrays.copyOf(original[k], X);
                }
            }


            // 4번 CCTV를 만나면
            if (cctv[2] == 4) {
                map[cctv[0]][cctv[1]] = -1;
                for (int j = 0; j < 4; j++) {
                    int ny = cctv[0] + moveY[j];
                    int nx = cctv[1] + moveX[j];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {
                        map[ny][nx] = -1;
                        ny += moveY[j];
                        nx += moveX[j];
                    }

                    ny = cctv[0] + moveY[(j + 1) % 4];
                    nx = cctv[1] + moveX[(j + 1) % 4];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {
                        map[ny][nx] = -1;
                        ny += moveY[(j + 1) % 4];
                        nx += moveX[(j + 1) % 4];
                    }


                    ny = cctv[0] + moveY[(j + 2) % 4];
                    nx = cctv[1] + moveX[(j + 2) % 4];

                    while ((0 <= nx && nx < X && 0 <= ny && ny < Y) && map[ny][nx] != 6) {
                        map[ny][nx] = -1;
                        ny += moveY[(j + 2) % 4];
                        nx += moveX[(j + 2) % 4];
                    }

                    backTracking(depth + 1, i + 1);

                    for (int k = 0; k < Y; k++) map[k] = Arrays.copyOf(original[k], X);
                }
            }
        }
    }


    // 정답 갱신 메서드 0의 개수가 사각지대의 개수이다.
    static void setAnswer() {
        int cnt = 0;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        answer = Math.min(answer, cnt);
    }

}
