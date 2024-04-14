package baekjoon;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.04.14
 * 문제 해결 : 에드혹  개미가 스틱 위에서 배치되어 있는 순서는 절대로 바뀌지 않는다.
 *              그 점을 잘 이용하여 순서를 잘 정해보자
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3163_떨어지는개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Ant[] ants = new Ant[N];
            int[] ids = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int id = Integer.parseInt(st.nextToken());
                int dist = 0;

                // 개미의 진행 방향이 오른쪽이라면
                if (id > 0) {
                    // 거리 떨어지기까지 거리 계산
                    dist = L - idx;
                // 왼쪽이라면
                } else {
                    // 거리 계산
                    dist = idx;
                }

                // 개미 배열에 넣기
                ants[i] = new Ant(dist, id);

                // 개미의 아이디 배열에 아이디 넣기
                ids[i] = id;
            }


            // 왼쪽으로 떨어지는 개미 댁
            Deque<Ant> leftDeque = new ArrayDeque<>();
            // 오른쪽으로 떨어지는 개미 댁
            Deque<Ant> rightDeque = new ArrayDeque<>();


            // 왼쪽 진행 방향인 개미들
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (ants[i].id < 0) {
                    leftDeque.add(new Ant(ants[i].dist, ids[cnt++]));
                }
            }


            // 오른쪽 진행 방향인 개미들
            for (int i = 0; i < N; i++) {
                if (ants[i].id > 0) {
                    rightDeque.add(new Ant(ants[i].dist, ids[cnt++]));
                }
            }


            // 떨어지는 개미 순서 배열
            int[] sequence = new int[N];
            cnt = 0;

            // 왼쪽으로 떨어지는 개미와 오른쪽으로 떨어지는 개미
            // 각 낭떠러지에서 가장 가까운 개미를 비교하여 순서를 정해 나간다.
            while (!leftDeque.isEmpty() && !rightDeque.isEmpty()) {
                // 왼쪽 개미가 낭떠러지까지 더 짧다면
                if (leftDeque.peekFirst().dist < rightDeque.peekLast().dist) {
                    sequence[cnt++] =leftDeque.pollFirst().id;
                // 오른쪽 개미가 낭떠러지까지 더 짧다면
                } else if (leftDeque.peekFirst().dist > rightDeque.peekLast().dist) {
                    sequence[cnt++] = rightDeque.pollLast().id;
                // 같다면 아이디가 적은 개미가 먼저 떨어진다.
                } else {
                    if (leftDeque.peekFirst().id < rightDeque.peekLast().id) {
                        sequence[cnt++] = leftDeque.pollFirst().id;
                    } else {
                        sequence[cnt++] = rightDeque.pollLast().id;
                    }
                }
            }

            // left right 둘중 하나라도 댁이 비면 남은것들 그냥 삽입
            while (!leftDeque.isEmpty()) {
                sequence[cnt++] = leftDeque.pollFirst().id;
            }

            while (!rightDeque.isEmpty()) {
                sequence[cnt++] = rightDeque.pollLast().id;
            }

            // 정답 출력
            sb.append(sequence[K-1] + "\n");
        }

        System.out.println(sb);
    }


    static class Ant {
        int dist, id;

        public Ant(int dist, int id) {
            this.dist = dist;
            this.id = id;
        }

    }
}
