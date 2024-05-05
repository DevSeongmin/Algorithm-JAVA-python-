package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.04.19
 * 문제 해결 : 통나무 상태 가로, 세로 상태, y, x 3차원 방문 배열을 이용한
 *          BFS 탐색
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1938_통나무옮기기 {

    static int N;
    static Log log;
    static int[][] board;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // [1][x][x] 세로통나무의 이동 체크
        // [0][x][x] 가로 통나무의 이동 체크
        boolean[][][] visited = new boolean[2][N][N];

        board = new int[N][N];


        // 통나무는 -2로
        // 종료지점은 -1로
        for (int i = 0; i < N; i++){
            String input = br.readLine();
            for (int j = 0; j < N ; j++){
                char tmp = input.charAt(j);
                if (tmp == 'B') board[i][j] = -2;
                else if (tmp == 'E') board[i][j] = -1;
                else board[i][j] = tmp - '0';
            }
        }


        // 통나무 찾기
        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < N; j++){

                // 세로로 놓인 통나무를 찾은 경우
                if (0 < i && i< N-1 && board[i][j] == -2 && board[i - 1][j] == -2 && board[i + 1][j] == -2) {
                    log = new Log(i, j, 1, 0);
                    board[i][j] = board[i - 1][j] = board[i + 1][j] = 0;
                }

                // 가로로 놓인 통나무를 찾은 경우
                if (0 < j && j < N-1 && board[i][j] == -2 && board[i][j-1] == -2 && board[i][j+1] == -2) {
                    log = new Log(i, j, 0, 0);
                    board[i][j] = board[i][j-1] = board[i][j+1] = 0;
                }
            }
        }


        // BFS 수행
        Queue<Log> q = new LinkedList<>();
        visited[log.upAndDown][log.y][log.x] = true;
        q.add(log);

        while (!q.isEmpty()) {
            Log curLog = q.poll();

            // 만약 현재 위치가 종료 위치라면 (세로)
            if (isIn(curLog.y + 1, curLog.x) && isIn(curLog.y - 1, curLog.x)
                    && board[curLog.y-1][curLog.x] == -1 && board[curLog.y][curLog.x] == -1 && board[curLog.y+1][curLog.x] == -1) {
                System.out.println(curLog.cnt);
                System.exit(0);
            }

            // 만약 현재 위치가 종료 위치라면 (가로)
            if (isIn(curLog.y , curLog.x+ 1) && isIn(curLog.y , curLog.x- 1)
                    && board[curLog.y][curLog.x-1] == -1 && board[curLog.y][curLog.x] == -1 && board[curLog.y][curLog.x+1] == -1) {
                System.out.println(curLog.cnt);
                System.exit(0);
            }

            // 통나무가 세로일 때
            if (curLog.upAndDown == 1) {
                for (int i = 0; i < 4; i++){

                    int nx = curLog.x + moveX[i];
                    int ny = curLog.y + moveY[i];

                    if (!isIn(ny-1,nx) || !isIn(ny+1,nx)) continue;
                    if (visited[1][ny][nx]) continue;
                    if (board[ny-1][nx] == 1 || board[ny][nx] == 1 || board[ny+1][nx] == 1) continue;

                    q.add(new Log(ny, nx, 1, curLog.cnt+1));
                    visited[1][ny][nx] = true;
                }

            // 통나무가 가로일 때
            } else {
                for (int i = 0; i < 4; i++) {

                    int nx = curLog.x + moveX[i];
                    int ny = curLog.y + moveY[i];

                    if (!isIn(ny,nx-1) || !isIn(ny,nx+1)) continue;
                    if (visited[0][ny][nx]) continue;
                    if (board[ny][nx-1] == 1 || board[ny][nx] == 1 || board[ny][nx+1] == 1) continue;

                    q.add(new Log(ny, nx, 0,curLog.cnt+1));
                    visited[0][ny][nx] = true;
                }
            }

            // 회전 했을 때
            int next = curLog.upAndDown == 1 ? 0 : 1;
            if (curLog.turnPossible() && !visited[next][curLog.y][curLog.x]) {
                q.add(new Log(curLog.y, curLog.x, next,curLog.cnt+1));
                visited[next][curLog.y][curLog.x] = true;
            }
        }
        System.out.println(0);
    }

    // 통나무 클래스
    static class Log{
        // 중심의 y, x,
        // upAndDown 모양 1이면 세로 0이면 가로
        // cnt 행동 횟수
        int y, x, upAndDown, cnt;

        public Log(int y, int x, int upAndDown, int cnt) {
            this.y = y;
            this.x = x;
            this.upAndDown = upAndDown;
            this.cnt = cnt;
        }

        // 회전 할 수 있는지
        public boolean turnPossible(){
            for (int i = y-1;  y+2 > i; i++){
                for (int j = x - 1; x + 2 > j; j++){
                    if (!isIn(i,j) || board[i][j] == 1) return false;
                }
            }
            return true;
        }
    }

    // 범위 체크
    static boolean isIn(int y, int x){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
