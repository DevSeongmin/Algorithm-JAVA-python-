package swea;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.28
 * 문제 해결 : 시뮬레이션
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Swea1767_프로세서연결하기 {

    static int N, answer, maxconn;
    static LinkedList<Processer> processers;
    static int[][] map;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            processers = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != N - 1 && j != N - 1) {
                        processers.add(new Processer(i, j));
                    }
                }
            }
            maxconn = 0;
            answer = Integer.MAX_VALUE; // end input

            // 정답 찾기
            dfs(0, 0, 0);

            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int cnt, int connection) {

        // 만약 현재 연결 수와 지금까지 최대 연결 수가 같다면
        if (connection == maxconn) {
            // 좀 더 작은 연결값을 정답으로
            answer = Math.min(answer, cnt);
        // 현재 연결한 프로세스개수가 더 많다면
        } else if (connection > maxconn) {
            // 최대 연결 수 갱신
            maxconn = connection;
            // 정답 갱신
            answer = cnt;
        }

        // 모든 프로세서를 다 돌았을경우 return
        if (depth == processers.size()) return;

        // 현재 프로세서 꺼내기
        Processer p = processers.get(depth);

        // 그냥 연결 안하고 넘기는 경우
        dfs(depth + 1, cnt, connection);


        // 4방향 연결 시뮬레이션
        for (int i = 0; i < 4; i++) {
            int dy = moveY[i];
            int dx = moveX[i];
            int y = p.y;
            int x = p.x;

            // 연결 확인 여부
            boolean flag = false;

            // 선 뻣어나가기
            while (true) {
                y += dy;
                x += dx;

                // 범위 밖에 나가면 연결한 것
                if (!isIn(y, x)) {
                    flag = true;
                    break;
                }
                // 0이 아니면 연결 못함
                if (map[y][x] != 0) {
                    break;
                }
                // 연결한 선 표시
                map[y][x] = depth + 2;
                cnt++;
            }

            // 연결했다면 파고들기
            if (flag) {
                dfs(depth + 1, cnt, connection + 1);
            }

            // 다시 돌려놓기
            y = p.y;
            x = p.x;
            while (true) {
                y += dy;
                x += dx;

                // 범위 밖에 나가면 연결한 것
                if (!isIn(y, x)) {
                    break;
                }
                if (map[y][x] != depth + 2) break;

                // 연결선이면 돌려놓기
                if (map[y][x] == depth + 2) {
                    map[y][x] = 0;
                    cnt--;
                }
            }
        }
    }


    static boolean isIn(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    static class Processer {
        int y, x;
        public Processer(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
