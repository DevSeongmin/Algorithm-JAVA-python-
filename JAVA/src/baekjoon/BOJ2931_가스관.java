package baekjoon;
/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.25
 * 문제 해결 : 시뮬레이션을 진행하며 뚤린 파이프 위치를 구한다.
 * 해당 파이프에서 상하좌우 연결 가능한 여부를 확인하여
 * 해당 파이프에 모양을 구한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2931_가스관 {

    static char[][] map;
    static int[] moveX = {-1, 0, 1, 0};
    static int[] moveY = {0, -1, 0, 1};
    static int X, Y;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");

        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        map = new char[Y][X];

        // 맵 입력
        for (int i = 0; i < Y; i++) {
            String s = br.readLine();
            for (int j = 0; j < X; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        // 시작 파이프 라인 저장
        Flow flow = null;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (map[i][j] == 'M') {
                    for (int d = 0; d < 4; d++) {
                        int ny = i + moveY[d];
                        int nx = j + moveX[d];

                        // 다음 좌표가 갈 수 있으면
                        if (0 <= nx && nx < X && 0 <= ny && ny < Y && map[ny][nx] != '.' && map[ny][nx] != 'Z') {

                            // 시작 정보 입력
                            flow = new Flow(i, j, d);
                            break;
                        }
                    }
                }
            }
        }


        // 끊긴 파이프 라인 찾기
        while (true) {

            flow.move();

            // 범위를 벗어나면 끝
            if (!(0 <= flow.x && flow.x < X && 0 <= flow.y && flow.y < Y)) {
                break;
            }

            // 끊긴 좌표를 찾으면 끝
            if (map[flow.y][flow.x] == '.') {
                break;
            }
        }

        // 고쳐야 할 파이프 라인
        Flow fixPos = new Flow(flow.y, flow.x,0);


        // 상하좌우 연결 가능 확인
        boolean up = true;
        boolean left = true;
        boolean right = true;
        boolean down = true;

        // 위쪽 확인
        int upX = fixPos.x;
        int upY = fixPos.y - 1;
        if (upY < 0 || map[upY][upX] == '-' || map[upY][upX] == '2' || map[upY][upX] == '3' || map[upY][upX] == '.' || map[upY][upX] == 'M' || map[upY][upX] == 'Z') {
            up = false;
        }


        // 오른쪽 확인
        int rightX = fixPos.x + 1;
        int rightY = fixPos.y;
        if (rightX >= X || map[rightY][rightX] == '|' || map[rightY][rightX] == '1' || map[rightY][rightX] == '2' || map[rightY][rightX] == '.' || map[rightY][rightX] == 'M' || map[rightY][rightX] == 'Z') {
            right = false;
        }


        // 왼쪽 확인
        int leftX = fixPos.x - 1;
        int leftY = fixPos.y;
        if (leftX < 0 || map[leftY][leftX] == '|' || map[leftY][leftX] == '3' || map[leftY][leftX] == '4' || map[leftY][leftX] == '.' || map[leftY][leftX] == 'M' || map[leftY][leftX] == 'Z') {
            left = false;
        }

        // 아래쪽 확인
        int downX = fixPos.x;
        int downY = fixPos.y + 1;
        if (downY >= Y || map[downY][downX] == '-' || map[downY][downX] == '1' || map[downY][downX] == '4' || map[downY][downX] == '.' || map[downY][downX] == 'M' || map[downY][downX] == 'Z') {
            down = false;
        }


        // 정답 찾기
        char answer = ' ';
        if (left && right && up && down) {
            answer = '+';
        } else if (left && right) {
            answer = '-';
        } else if (up && down) {
            answer = '|';
        } else if (right && down) {
            answer = '1';
        } else if (up && right) {
            answer = '2';
        } else if (up && left) {
            answer = '3';
        } else if (left && down) {
            answer = '4';
        }

        // 정답 출력
        System.out.println((fixPos.y + 1) + " " + (fixPos.x + 1) + " " + answer);
    }

    // 파이프의 정보를 가지고 있는 클래스
    static class Flow {
        int y, x;
        int directionIdx;


        public Flow(int y, int x, int directionIdx) {
            this.y = y;
            this.x = x;
            this.directionIdx = directionIdx;
        }


        // 관을타고 움직이는 메서드
        void move() {
            y = y + moveY[directionIdx];
            x = x + moveX[directionIdx];

            if (!(0 <= y && y < Y && 0 <= x && x < X)) {
                return;
            }

            char pipe = map[y][x];


            // 애들은 그냥 가던대로 흐르면 된다.
            if (pipe == '-' || pipe == '|' && pipe == '+') {
                return;
            }


            // 각각 모양에 맞게 방향을 꺽어준다.
            if (pipe == '1') {
                if (directionIdx == 1) {
                    directionIdx = 2;
                    return;
                }

                if (directionIdx == 0) {
                    directionIdx = 3;
                    return;
                }
            }

            if (pipe == '2') {
                if (directionIdx == 3) {
                    directionIdx = 2;
                    return;
                }

                if (directionIdx == 0) {
                    directionIdx = 1;
                    return;
                }
            }

            if (pipe == '3') {
                if (directionIdx == 3) {
                    directionIdx = 0;
                    return;
                }

                if (directionIdx == 2) {
                    directionIdx = 1;
                    return;
                }
            }

            if (pipe == '4') {
                if (directionIdx == 2) {
                    directionIdx = 3;
                    return;
                }

                if (directionIdx == 1) {
                    directionIdx = 0;
                    return;
                }
            }
        }
    }
}

