package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.16
 * 문제 해결 : 시뮬레이션 구현 문제
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17135_캐슬디펜스 {

    // 우선순위  좌상, 상 , 우상
    static int[] moveX = { -1, 0, 1 };
    static int[] moveY = { 0, -1, 0 };

    static int X, Y, D;
    static int[][] map;
    static int[][] tmpMap;
    static int[] archers;
    static ArrayList<int[]> Killed;
    static int solve = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        D = Integer.parseInt(input[2]);

        map = new int[Y + 1][X];
        archers = new int[3];

        for (int i = 0; i < Y; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < X; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        combi(0, 0);
        System.out.println(solve);
    }

    static void combi(int depth, int s) {
        // 궁수 세명을 위치시키면 시뮬레이션 시작
        if (depth == 3) {

            // 원본맵이 바뀌는 것을 방지하기 위해 복사한 맵으로 시뮬레이션
            tmpMap = new int[Y + 1][X];

            for (int i = 0; i < Y + 1; i++) {
                for (int j = 0; j < X; j++) {
                    tmpMap[i][j] = map[i][j];
                }
            }

            int answer = 0;
            Killed = new ArrayList();

            // 가장 윗 행이 모두 내려올 때 까지
            for (int down = 0; down < Y; down++) {
                for (int i = 0; i < 3; i++) {
                    // i번 궁수 활 쏘기
                    BFS(Y, archers[i]);
                }

                // 죽어야 하는 몬스터들 죽이고 죽인 만큼 정답 ++
                for (int[] m : Killed) {
                    answer++;
                    tmpMap[m[0]][m[1]] = 0;
                }

                // 죽은 몬스터 리스트 초기화
                Killed = new ArrayList();

                // 몬스터 아래로 한칸씩 이동 
                moveMonster();
            }

            solve = Math.max(solve, answer);
            return;
        }

        // 3명을 뽑는 재귀
        for (int i = s; i < X; i++) {
            archers[depth] = i;
            combi(depth + 1, i + 1);
        }

    }

    // BFS탐색을 통해 잡아야하는 몬스터 찾기
    static void BFS(int y, int x) {
        Queue<int[]> q = new LinkedList<int[]>();

        // 궁수 위치, 사거리 정보  큐에 삽입
        q.add(new int[] { y, x, 0 });

        // 큐가 빌때까지 반복
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            y = tmp[0];
            x = tmp[1];
            int dist = tmp[2];

            // 몬스터를 만나면
            if (tmpMap[y][x] == 1) {

                // 만약 전에 잡은 몬스터라면 리스트에 담지 않는다.
                boolean flag = true;
                for (int[] k : Killed) {
                    if (k[0] == y && k[1] == x) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    Killed.add(new int[] { y, x });
                }

                return;
            }

            // 3방향 BFS
            for (int i = 0; i < 3; i++) {
                int ny = y + moveY[i];
                int nx = x + moveX[i];

                if (0 <= nx && nx < X && 0 <= ny && ny < Y && dist < D) {
                    q.add(new int[] { ny, nx, dist + 1 });
                }
            }
        }
    }


    // 몬스터들이 한칸씩 내려오는 메서드
    static void moveMonster() {
        for (int i = Y; i > 0; i--) {
            for (int j = 0; j < X; j++) {
                tmpMap[i][j] = tmpMap[i - 1][j];
            }
        }

        for (int i = 0; i < X; i++) {
            tmpMap[0][i] = 0;
        }



    }

}
