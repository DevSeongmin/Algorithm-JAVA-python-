package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.22
 * 문제 해결 방법 : 큐를 사용하여 두 백조가 만나는 시점을 출력한다.
 *                이 문제는 단순히 BFS 뿐만 아니라  BFS의 깊이마다 멈췄다 다른 작업을 수행 하고
 *                                              이어서 큐의 BFS를 진행하는 스킬이 들어간다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3197_백조의호수 {

    static int X, Y;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input;

        input = br.readLine().split(" ");


        Y = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);
        Character[][] map = new Character[Y][X];

        // 백조의 방문 배열
        boolean[][] swanVisited = new boolean[Y][X];

        // 물의 방문 배열 --> 얼음을 녹이는 과정에서 큐에 녹이는 얼음의 정보가 중복되어 들어가는 것을
        //                  막아야 메모리 초과를 피할 수 있다.
        boolean[][] waterVisited = new boolean[Y][X];


        // 물의 정보가 담긴 큐
        Queue<Node> waterQ = new LinkedList<>();

        // 녹여야하는 얼음의 정보가 담긴 큐
        Queue<Node> meltQ = new LinkedList<>();

        // 백조 큐는 우선 순위큐로 선언   Node에 우선순위 시간순으로 정렬되도록 재정의
        PriorityQueue<Node> swanQ = new PriorityQueue<>();

        // 백조 정보
        Node[] swans = new Node[2];
        int tmp = 0;

        // 맵 표현
        for (int i = 0; i < Y; i++) {
            String s = br.readLine();
            for (int j = 0; j < X; j++) {
                map[i][j] = s.charAt(j);

                // 백조가 있는 자리도 물이다.
                if (map[i][j] == 'L') {
                    swans[tmp++] = new Node(i, j, 0);
                    waterQ.add(new Node(i, j));
                    waterVisited[i][j] = true;


                } else if (map[i][j] == '.') {
                    waterQ.add(new Node(i, j));
                    waterVisited[i][j] = true;
                }
            }
        }


        // 첫번째 백조를 기준으로
        swanQ.add(swans[0]);
        swanVisited[swans[0].y][swans[0].x] = true;


        int time = 0;
        while (true) {


            // 녹일 정보 저장
            while (!waterQ.isEmpty()) {
                Node node = waterQ.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = node.y + moveY[i];
                    int nx = node.x + moveX[i];

                    if (!isIn(ny, nx)) continue;

                    if (map[ny][nx] == 'X' && !waterVisited[ny][nx]) {
                        waterVisited[ny][nx] = true;
                        meltQ.add(new Node(ny, nx));
                    }
                }
            }


            // 녹이기
            while (!meltQ.isEmpty()) {
                Node node = meltQ.poll();
                map[node.y][node.x] = '.';
                waterQ.add(node);
            }


            time++;

            // 백조 탐색 현재 백조큐의 사이즈 만큼
            int swansize = swanQ.size();
            while (swansize-- > 0) {

                Node node = swanQ.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = node.y + moveY[i];
                    int nx = node.x + moveX[i];
                    if (!isIn(ny, nx)) continue;

                    // 만약 2번 백조와 좌표가 같다면 시간 출력 후 종료
                    if (ny == swans[1].y && nx == swans[1].x) {
                        System.out.println(time);
                        System.exit(0);
                    }

                    if (swanVisited[ny][nx]) continue;

                    // 다음 칸이 얼음이라면
                    if (map[ny][nx] == 'X') {
                        swanVisited[ny][nx] = true;
                        // 큐의 뒤에 삽입
                        swanQ.add(new Node(ny, nx, node.t+1));
                    }

                    // 물이라면
                    else if (map[ny][nx] == '.') {
                        // 큐의 반복을 1 늘려줌
                        swansize++;
                        swanVisited[ny][nx] = true;
                        // 큐에 넣기
                        swanQ.add(new Node(ny, nx, node.t));
                    }
                }
            }



        }


    }

    // 범위 체크 메서드
    static boolean isIn(int y, int x) {
        if (0 <= x && x < X && 0 <= y && y < Y) {
            return true;
        }
        return false;
    }


    // x,y좌표를 표현하는 노드
    static class Node implements Comparable<Node>{
        int y;
        int x;
        int t;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return y == node.y && x == node.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Node(int y, int x, int t) {
            this(y, x);
            this.t = t;
        }

        // 시간순으로 먼저 정렬되도록 재정의
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.t, o.t);
        }
    }
}