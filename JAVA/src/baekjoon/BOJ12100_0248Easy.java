package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.03.01
 * 문제 해결 방법 : 구현, 시뮬레이션
 *              한쪽 방향으로 미는 경우만 구현하고
 *               나머지 미는 연산은 2차원 배열을 spin돌려서 미는 방식으로 구현
 */


public class BOJ12100_0248Easy {
    static int N, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        answer = 0;
        simulation(0);
        System.out.println(answer);

    }


    // 5번 미는 시뮬레이션
    static void simulation(int depth) {
        if (depth == 5) {
            answer = Math.max(answer, getScore());
            return;
        }

        int[][] origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            origin[i] = Arrays.copyOf(map[i], N);
        }


        pushRight();
        simulation(depth + 1);
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(origin[i], N);
        }


        pushDown();
        simulation(depth + 1);
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(origin[i], N);
        }


        pushLeft();
        simulation(depth + 1);
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(origin[i], N);
        }


        pushUp();
        simulation(depth + 1);
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(origin[i], N);
        }
    }


    // 최대 점수 계산
    static int getScore() {
        int score = map[0][0];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                score = Math.max(score, map[i][j]);
            }
        }

        return score;
    }


    static void pushUp() {
        spin();
        spin();
        spin();
        pushLeft();
        spin();
    }


    static void pushRight() {
        spin();
        spin();
        pushLeft();
        spin();
        spin();
    }


    static void pushDown() {
        spin();
        pushLeft();
        spin();
        spin();
        spin();
    }

    // 2차원 배열을 90도 회전
    static void spin() {

        int[][] tmp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[j][N - i - 1] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.copyOf(tmp[i], N);
        }


    }


    // 왼쪽으로 미는 연산
    static void pushLeft() {
        for (int i = 0; i < N; i++) {

            // 시작 위치 찾기
            int startIdx = -1;

            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    startIdx = j;
                    break;
                }
            }
            // 시작 점을 못찾으면 빠져나오기
            if (startIdx == -1) continue;

            // 오른쪽으로 이동하며 숫자를 탐색할 인덱스
            int nextIdx = startIdx + 1;

            while (nextIdx < N) {

                // 다음 오른쪽이 0이라면 한번더 오른쪽으로
                if (map[i][nextIdx] == 0) {
                    nextIdx++;
                    continue;

                    // 나랑 같은 값을 찾으면
                } else if (map[i][startIdx] == map[i][nextIdx]) {
                    map[i][startIdx] += map[i][nextIdx];
                    map[i][nextIdx] = 0;

                    while (nextIdx < N && map[i][nextIdx] != 0) {
                        nextIdx++;
                    }

                    startIdx = nextIdx;
                    nextIdx++;

                    // 나랑 다른값을 찾으면
                } else if (map[i][startIdx] != map[i][nextIdx]) {
                    startIdx = nextIdx;
                    nextIdx++;
                }
            }
        }




        // 숫자 값들을 왼쪽으로 붙이기
        // ex)
        // 4 0  2 8 8
        // 4 2 8 8 0
        for (int i = 0; i < N; i++) {
            int zeroIdx = -1;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    zeroIdx = j;
                    break;
                }
            }
            if (zeroIdx == -1) continue;

            int nextIdx = zeroIdx + 1;

            while (nextIdx < N) {

                // 다음 좌표 0이면 더 찾기
                if (map[i][nextIdx] == 0) {
                    nextIdx++;
                }

                // 0이 아닌값을 찾으면
                else if (map[i][nextIdx] != 0) {

                    // 찾은값 0과 스왑
                    int tmp = map[i][nextIdx];
                    map[i][nextIdx] = map[i][zeroIdx];
                    map[i][zeroIdx] = tmp;

                    zeroIdx++;
                    nextIdx = zeroIdx + 1;

                }
            }
        }
    }
}
