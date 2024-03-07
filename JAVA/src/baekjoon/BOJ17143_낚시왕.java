package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ17143_낚시왕 {

    static int Y,X;
    static int[] moveX = {0, 0, 0, 1, -1};
    static int[] moveY = {0, -1, 1, 0, 0};
    static HashMap<Shark, Integer> sharks;
    static HashMap<Shark, Integer> tmpSharks;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        sharks = new HashMap<>();

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            sharks.put(new Shark(y, x, speed, direction, size), size);
        }


        int answer = 0;
        for (int j = 1; j <= X; j++) {
            for (int i = 1; i <= Y; i++){
                if (sharks.containsKey(new Shark(i, j))) {
                    answer += sharks.get(new Shark(i, j));
                    sharks.remove(new Shark(i, j));
                    break;
                }
            }
            moveSharks();
        }
        System.out.println(answer);
    }


    static void moveSharks(){
        tmpSharks = new HashMap<>();

        for (Shark shark : sharks.keySet()) {
            int y = shark.y;
            int x = shark.x;
            int speed = shark.speed;
            int direction = shark.direction;

            if (direction == 1 || direction == 2) {
                speed = speed % ((Y-1)*2);
            } else {
                speed = speed % ((X-1)*2);
            }



            for (int i = 0; i < speed; i++) {

                if (!isIn(y + moveY[direction], x + moveX[direction])) {
                    if (direction == 1) direction = 2;
                    else if (direction == 2) direction = 1;
                    else if (direction == 3) direction = 4;
                    else if (direction == 4) direction = 3;
                }



                y += moveY[direction];
                x += moveX[direction];
            }

            // 해당 위치에 상어가 없으면
            if (!tmpSharks.containsKey(new Shark(y, x))) {
                tmpSharks.put(new Shark(y, x, speed, direction, shark.size), shark.size);

            // 해당 위치에 상어가 있다면 크기가 큰 상어로
            } else {
                // 기존의 상어가 더 작다면
                if (tmpSharks.get(new Shark(y, x)) < shark.size) {
                    tmpSharks.remove(new Shark(y, x));
                    tmpSharks.put(new Shark(y, x, shark.speed, direction, shark.size), shark.size);
                }
            }
        }

        sharks = new HashMap<>(tmpSharks);
    }

    static boolean isIn(int y, int x){
        return 1 <= y && y <= Y && 1 <= x && x <= X;
    }

    static class Shark {
        int y, x, speed, size, direction;

        public Shark(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Shark(int y, int x, int speed, int direction, int size) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Shark shark = (Shark) o;
            return y == shark.y && x == shark.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
