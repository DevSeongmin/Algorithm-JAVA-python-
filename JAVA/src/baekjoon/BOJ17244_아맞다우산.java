package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.03.08
 * 문제 해결 : 물건들의 좌표를 모두 구하고 해당 물건들을
 *             퍼뮤테이션 돌려서 가져갈 물건들의 순서를 정한다.
 *             그리고 이 경우로 탐색을 하여 최솟값을 구한다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ17244_아맞다우산 {
    static int Y, X, thingsCnt, answer;
    static char board[][];
    static Node  startNode, endNode;
    static ArrayList<Node> things;
    static boolean[] visited;
    static boolean[][] boradVisited;
    static ArrayList<Node> selected = new ArrayList<>();
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        X = Integer.parseInt(input[0]);
        Y = Integer.parseInt(input[1]);

        board = new char[Y][X];

        // 물건들을 담는 좌표
        things = new ArrayList<>();

        for (int i = 0; i < Y; i++){
            String s = br.readLine();
            for (int j = 0; j < X; j++){
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'X') {
                    things.add(new Node(i, j, 0));
                } else if (board[i][j] == 'S') {
                    startNode = new Node(i, j, 0);
                } else if (board[i][j] == 'E') {
                    endNode = new Node(i, j, -1);
                }
            }
        }// End input...

        // 물건의 개수
        thingsCnt = things.size();
        // 순열을 돌리기위한 방문 베열 
        visited = new boolean[thingsCnt];

        // 정답 초기에는 무한으로
        answer = Integer.MAX_VALUE;
        permu(0);
        // 정답 출력
        System.out.println(answer);

    }
    static void permu(int depth){

        // 모두 뽑았다면
        if (depth == thingsCnt){
            // X 좌표 퍼뮤돌림 밑에 로직구현

            // BFS를 돌린다. 물건 순으로 
            boradVisited = new boolean[Y][X];
            Queue<Node> q = new LinkedList<>();
            boradVisited[startNode.y][startNode.x] = true;
            q.add(startNode);

            int dist = 0;

            // i번째 물건을 가는경우 
            // i번째 물건을 갔다면 i번째 물건의 좌표에서 i+1번으로 가는경우를 순회
            for (int i = 0; i < thingsCnt; i++){
                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    // 물건을 bfs탐색으로 찾은경우
                    if (cur.y == selected.get(i).y && cur.x == selected.get(i).x) {
                        dist += cur.d;

                        // 가지치기
                        if (dist >= answer) return;

                        boradVisited = new boolean[Y][X];
                        q = new LinkedList<>();
                        boradVisited[selected.get(i).y][selected.get(i).x] = true;
                        q.add(selected.get(i));
                        break;
                    }

                    for (int d = 0; d < 4; d++){
                        int ny = cur.y + moveY[d];
                        int nx = cur.x + moveX[d];

                        if (boradVisited[ny][nx]) continue;
                        if (board[ny][nx] == '#') continue;
                        if (board[ny][nx] == 'E') continue;

                        q.add(new Node(ny, nx, cur.d + 1));
                        boradVisited[ny][nx] = true;
                    }
                }
            }

            // 마지막 물건에서 End좌표 까지 가는 거리 계산
            while (!q.isEmpty()) {
                Node cur = q.poll();

                // 물건을 bfs탐색으로 찾은경우
                if (cur.y == endNode.y && cur.x == endNode.x) {
                    dist += cur.d;

                    // 가지치기
                    if (dist >= answer) return;
                    break;
                }

                for (int d = 0; d < 4; d++){
                    int ny = cur.y + moveY[d];
                    int nx = cur.x + moveX[d];

                    if (boradVisited[ny][nx]) continue;
                    if (board[ny][nx] == '#') continue;

                    q.add(new Node(ny, nx, cur.d + 1));
                    boradVisited[ny][nx] = true;
                }
            }

            // 정답 더 작은값으로 갱신
            answer = Math.min(answer, dist);
            return;
        }


        // 퍼뮤테이션
        for (int i = 0; i < thingsCnt; i++){
            if (visited[i]) continue;
            visited[i] = true;
            selected.add(things.get(i));

            permu(depth + 1);

            visited[i] = false;
            selected.remove(selected.size()-1);
        }
    }

    static class Node{
        int y, x, d;

        public Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
