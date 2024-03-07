package baekjoon;

/** 작성자 : 황성민
 * 작성일자 : 24.03.01
 * 문제 해결 : 시뮬레이션 구현 : --> 구현량을 줄이기 위해 구슬을 왼쪽으로 기우는 경우만 구현하고
 *                              나머지 상 하 우 는 배열을 돌리고 수행하는 것으로 문제를 해결한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ13460_구슬탈출3 {
    static int Y, X, Z, answer;
    static String answerS;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        // 배열 돌리기 편하도록 YX중 더 큰값으로 큰 배열 만들기
        Z = Math.max(Y, X);

        map = new char[Z][Z];

        // 맵 Y X가 더 클경우 빈칸들은 벽으로 채운다.
        for (int i = 0; i < Z; i++) {
            Arrays.fill(map[i], '#');
        }

        // 맵 정보 입력
        for (int i = 0; i < Y; i++) {
            String s = br.readLine();
            for (int j = 0; j < X; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // 정답은 초기에 무한으로
        answer = Integer.MAX_VALUE;
        answerS = "";

        // 시뮬레이션 진행
        simul(0, 'N', "");

        // 정답 출력
        if (answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(answer);
            System.out.println(answerS);
        }
    }
    static void simul(int depth, char before, String record) {
        // 만약 현재 깊이가 지금까지 구한 답 보다 크면 return;
        if (depth > answer) return;

         // 맵의 상태 체크
        int state = check();

        // 파란공이 빠졌다면 return;
        if (state == -1) {
            return;
        // 빨간공만 빠졌다면 정답 갱신 후 return;
        } else if (state == 1) {
            if (depth < answer){
                answer = depth;
                answerS = record;
            }

            answer = Math.min(answer, depth);
            return;
        }

        // 깊이가 10이면 return;
        if (depth == 10) return;


        // 시뮬 전 맵 저장
        char[][] tmp = new char[Z][Z];
        for (int i = 0; i < Z; i++) {
            tmp[i] = Arrays.copyOf(map[i], Z);
        }


        // 이전에 오른쪽으로 밀었다면 왼쪽으로 밀지 않는다.
        if (before != 'R') {
            pushLeft();
            simul(depth + 1, 'L', record + "L");
            for (int i = 0; i < Z; i++) {
                map[i] = Arrays.copyOf(tmp[i], Z);
            }
        }

        // 아래도 동일
        if (before != 'U') {
            pushDown();
            simul(depth + 1, 'D', record + "D");
            for (int i = 0; i < Z; i++) {
                map[i] = Arrays.copyOf(tmp[i], Z);
            }
        }

        if (before != 'D') {
            pushUp();
            simul(depth + 1, 'U', record + "U");
            for (int i = 0; i < Z; i++) {
                map[i] = Arrays.copyOf(tmp[i], Z);
            }
        }


        if (before != 'L') {
            pushRight();
            simul(depth + 1, 'R', record + "R");
            for (int i = 0; i < Z; i++) {
                map[i] = Arrays.copyOf(tmp[i], Z);
            }
        }

    }


    // 위로 미는 연산
    static void pushUp() {
        spin();
        pushLeft();
        spin();
        spin();
        spin();
    }

    // 오른쪽으로 미는 연산
    static void pushRight() {
        spin();
        spin();
        pushLeft();
        spin();
        spin();
    }

    // 아래쪽으로 미는 연산
    static void pushDown() {
        spin();
        spin();
        spin();
        pushLeft();
        spin();
    }


    // 왼쪽으로 미는 연산
    static void pushLeft() {
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Z; j++) {
                if (map[i][j] == '#' || map[i][j] == 'O') continue;


                // 구슬인 경우 왼쪽으로 밀자
                if (map[i][j] == 'R' || map[i][j] == 'B') {

                    int startIdx = j;

                    while (true) {

                        // 빈칸이면 현재 공이랑 스왑
                        if (map[i][startIdx - 1] == '.') {
                            swap(i, startIdx, startIdx - 1);
                            startIdx--;
                        }

                        // 구멍이면 공 없애고 끝낸다.
                        else if (map[i][startIdx - 1] == 'O') {
                            map[i][startIdx] = '.';
                            break;
                        }

                        // 구멍도 빈칸도 아니면
                        else {
                            break;
                        }
                    }
                }


            }
        }
    }


    // 공 스왑하는 연산
    static void swap(int y, int x1, int x2) {
        char tmp = map[y][x1];
        map[y][x1] = map[y][x2];
        map[y][x2] = tmp;
    }


    // 현재 맵의 빨간공과 파란공 정보 체크
    static int check() {
        boolean b = false;
        boolean r = false;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'R') {
                    r = true;
                }
                if (map[i][j] == 'B') {
                    b = true;
                }
            }
        }

        // 파란 구슬이 빠진경우 무조건 불가
        if (!b) {
            return -1;

            // 빨간 구슬만 빠진 경우  승리
        } else if (!r && b) {
            return 1;

            // 둘 다 있는 경우 더 지켜봐야함
        } else {
            return 0;
        }
    }


    // 맵 왼쪽으로 90도 회전
    static void spin() {
        char[][] tmp = new char[Z][Z];
        for (int i = 0; i < Z; i++) {
            for (int j = 0; j < Z; j++) {
                tmp[i][j] = map[j][Z - i - 1];
            }
        }
        for (int i = 0; i < Z; i++) {
            map[i] = Arrays.copyOf(tmp[i], Z);
        }

    }
}
