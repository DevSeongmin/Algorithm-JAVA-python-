package swea;

/** 작성자 : 황성민
 * 작성일자 : 24.03.02
 * 문제 해결 : 해당 문제에서는 정확한 X, Y값이 주어지지 않았다, 즉 2차원 그리드를 HashMap을 이용하여 방문 여부를 처리
 *                   우선순위 큐를 사용해서 시간순으로, 시간이 같다면 세포의, 생명력 수치가 큰 순으로 나오도록 하여
 *                   세포 분열을 시뮬레이션 하고
 *                   맵에 해당 칸에 최대 생존 시간을 기록한다.
 *                   시뮬레이션이 끝나면 현재 시간보다 생존시간이 큰 세포의 개수를 세어 문제를 해결한다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea5653_줄기세포배양 {

    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {

            st = new StringTokenizer(br.readLine());

            // 칸별 생존 시간을 기록할 해쉬맵
            HashMap<Cell, Integer> surviveTime = new HashMap<>();
            // 세포 우선순위 큐
            PriorityQueue<Cell> pq = new PriorityQueue<>();

            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            for (int i = 0; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp != 0) {
                        // 세포라면 정보 입력
                        surviveTime.put(new Cell(i, j), tmp);
                        pq.add(new Cell(i, j, tmp, tmp));
                    }
                }
            }

            // 시뮬레이션 진행
            int time = 0;
            while (T > time) {
                time++;

                // 현재 퍼질 수 있는 세포가 있다면
                while (!pq.isEmpty() && pq.peek().time < time) {
                    Cell cur = pq.poll();
                    int y = cur.y;
                    int x = cur.x;
                    int level = cur.level;

                    // 4방향 BFS
                    for (int i = 0; i < 4; i++) {
                        int ny = y + moveY[i];
                        int nx = x + moveX[i];

                        // 이미 해당 칸에 세포가 있다면 건너뛴다.
                        if (surviveTime.containsKey(new Cell(ny, nx))) continue;

                        // 해당 좌표로 퍼질 수 있다면 다음 세포의 생존 시간은 현재시간 + 해당 세포의 생명력 * 2
                        surviveTime.put(new Cell(ny, nx), time + level * 2);

                        // pq에 세포 넣기
                        pq.add(new Cell(ny, nx, time + level, level));
                    }
                }
            }
            // 현재 시간보다 큰 생존 시간 칸들 수 세기
            int answer = 0;
            for (Integer value : surviveTime.values()) {
                if (value > T) {
                    answer++;
                }
            }
            // 정답 어펜드
            sb.append("#" + tc + " " + answer + "\n");
        }
        // 정답 출력
        System.out.println(sb);
    }

    // 세포 정보 클래스
    static class Cell implements Comparable<Cell> {
        int y, x, time, level;

        public Cell(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Cell(int y, int x, int time, int level) {
            this(y, x);
            this.time = time;
            this.level = level;
        }


        // 먼저 빼는 순서는 시간순, 시간이 같다면 높은 레벨 순
        @Override
        public int compareTo(Cell o) {
            if (this.time == o.time) {
                return Integer.compare(o.level, this.level);
            }
            return Integer.compare(this.time, o.time);
        }

        // 해쉬맵에 사용하기 위해 equals 재정의
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return y == cell.y && x == cell.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}

