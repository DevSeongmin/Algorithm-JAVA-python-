package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20056_마법사상어와파이어볼 {
    static int N, M;
    static int[] moveX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] moveY = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<FireBall>[][] fireBallsBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        fireBallsBoard = new LinkedList[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                fireBallsBoard[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireBallsBoard[y][x].add(new FireBall(m, s, d));
        }


        for (int i = 0; i < K; i++) {
            move();
        }


        int answer = 0;


        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {

                while (!fireBallsBoard[i][j].isEmpty()) {
                    answer += fireBallsBoard[i][j].poll().m;
                }
            }
        }


        System.out.println(answer);


    }

    static void move() {

        Queue<FireBall>[][] nextBoard = new LinkedList[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                nextBoard[i][j] = new LinkedList<>();
            }
        }


        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {

                while (!fireBallsBoard[i][j].isEmpty()) {

                    FireBall ball = fireBallsBoard[i][j].poll();

                    int ny = (i + moveY[ball.d] * ball.s) % N;
                    ny = ny < 0 ? N + ny : ny;
                    ny = ny == 0 ? N : ny;

                    int nx = (j + moveX[ball.d] * ball.s) % N;
                    nx = nx < 0 ? N + nx : nx;
                    nx = nx == 0 ? N : nx;


                    nextBoard[ny][nx].add(new FireBall(ball.m, ball.s, ball.d));
                }

            }
        }


        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {

                if (nextBoard[i][j].size() < 2) continue;

                int weightSum = 0;
                int speedSum = 0;
                boolean evenFlag = true;
                boolean oddFlag = true;
                int cnt = nextBoard[i][j].size();


                while (!nextBoard[i][j].isEmpty()) {
                    FireBall ball = nextBoard[i][j].poll();

                    weightSum += ball.m;
                    speedSum += ball.s;

                    if (ball.d % 2 == 1) {
                        evenFlag = false;
                    } else if (ball.d % 2 == 0) {
                        oddFlag = false;
                    }
                }

                if (weightSum / 5 > 0) {
                    if (evenFlag || oddFlag) {
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 0));
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 2));
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 4));
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 6));
                    } else {
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 1));
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 3));
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 5));
                        nextBoard[i][j].add(new FireBall(weightSum / 5, speedSum / cnt, 7));
                    }
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                fireBallsBoard[i][j] = new LinkedList<>(nextBoard[i][j]);
            }
        }


    }

    static class FireBall {
        int m, s, d;

        public FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("FireBall{");
            sb.append("m=").append(m);
            sb.append(", s=").append(s);
            sb.append(", d=").append(d);
            sb.append('}');
            return sb.toString();
        }
    }
}
