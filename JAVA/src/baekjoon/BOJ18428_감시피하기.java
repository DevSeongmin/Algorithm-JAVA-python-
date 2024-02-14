package baekjoon;

/**
 * 작성자 : 황성민
 * 작성 일자 : 24.02.13
 * 문제 해결 : 구현 + 조합
 * N * N사이즈의 맵에 선생님의 위치 학생의 위치 장애물의 위치가 주어진다.
 * 선생님의 시야는 4방향으로 끝까지 확인하며
 * 장애물 3개를 설치하여 모든 학생이 선생님에게 걸리지 않도록 하는 문제이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ18428_감시피하기 {

    static int N;
    static ArrayList<int[]> teachers;
    static ArrayList<int[]> emptySpace;
    static int[] moveY = {-1, 1, 0, 0};
    static int[] moveX = {0, 0, -1, 1};
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];

        // 선생님들의 좌표
        teachers = new ArrayList<>();
        // 빈공간( 장애물 설치 가능 공간)
        emptySpace = new ArrayList<>();


        // 맵 정보 입력
        // 선생님 정보 입력
        // 빈공간 정보 입력
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j];
                if (map[i][j].equals("T")) {
                    teachers.add(new int[]{i, j});
                } else if (map[i][j].equals("X")) {
                    emptySpace.add(new int[]{i, j});
                }
            }
        }

        // 장애물 설치
        install(0, 0);
        // 걸린적이 없다면 NO
        System.out.println("NO");

    }


    static void install(int depth, int s) {

        // 장애물을 3개 설치했다면
        if (depth == 3) {
            // 모든 감시를 피했다면 YES후 프로그램 종료
            if (findStudent()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        // 빈 공간에 장애물 3개를 두는 조합
        for (int i = s; i < emptySpace.size(); i++) {

            int[] tmp = emptySpace.get(i);
            int y = tmp[0];
            int x = tmp[1];

            map[y][x] = "O";

            install(depth + 1, i + 1);

            map[y][x] = "X";
        }


    }

    // 선생님들 좌표에서 4방향을 탐색하여 학생들을 찾는 함수
    static boolean findStudent() {
        for (int i = 0; i < teachers.size(); i++) {
            int[] tmp = teachers.get(i);
            for (int j = 0; j < 4; j++) {
                int ny = tmp[0];
                int nx = tmp[1];
                while (0 <= nx && nx < N && 0 <= ny && ny < N && !map[ny][nx].equals("O")) {
                    if (map[ny][nx].equals("S")) {
                        return false;
                    }
                    ny += moveY[j];
                    nx += moveX[j];
                }

            }
        }
        return true;
    }
}
