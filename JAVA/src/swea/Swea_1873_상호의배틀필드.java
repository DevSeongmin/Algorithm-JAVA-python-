package swea;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.16
 * 문제 해결 : 빡구현 문제
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Swea_1873_상호의배틀필드 {

    static int Y, X;
    static Character[][] map;
    static HashMap<Character, int[]> directions = new HashMap<Character, int[]>();
    static HashMap<Character, Character> shapes = new HashMap<Character, Character>();

    public static void main(String[] args) throws IOException {
        directions.put('<', new int[]{0, -1});
        directions.put('>', new int[]{0, 1});
        directions.put('v', new int[]{1, 0});
        directions.put('^', new int[]{-1, 0});
        directions.put('L', new int[]{0, -1});
        directions.put('R', new int[]{0, 1});
        directions.put('D', new int[]{1, 0});
        directions.put('U', new int[]{-1, 0});
        shapes.put('L', '<');
        shapes.put('R', '>');
        shapes.put('U', '^');
        shapes.put('D', 'v');


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        String[] inputs;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {


            inputs = br.readLine().split(" ");

            Y = Integer.parseInt(inputs[0]);
            X = Integer.parseInt(inputs[1]);

            map = new Character[Y][X];

            Tank tank = null;
            for (int i = 0; i < Y; i++) {
                input = br.readLine();
                for (int j = 0; j < X; j++) {
                    map[i][j] = input.charAt(j);
                    if (directions.containsKey(map[i][j])) {
                        tank = new Tank(i, j, directions.get(map[i][j]), map[i][j]);
                    }
                }
            }

            int command = Integer.parseInt(br.readLine());

            input = br.readLine();

            for (int i = 0; i < command; i++) {

                if (directions.containsKey(input.charAt(i))) tank.move(input.charAt(i));
                else {
                    tank.shoot();
                }
            }

            sb.append("#" + tc + " ");

            for (Character[] ma : map) {
                for (Character m : ma) {
                    sb.append(m);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);

    }

    static class Tank {
        public int y;
        public int x;
        public int[] direction;
        public Character shape;


        public Tank(int y, int x, int[] direction, Character shape) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.shape = shape;
        }


        public void shoot() {
            int ny = y + direction[0];
            int nx = x + direction[1];

            while (isIn(ny, nx)) {

                if (map[ny][nx] == '#') return;
                else if (map[ny][nx] == '*') {
                    map[ny][nx] = '.';
                    return;
                }

                ny += direction[0];
                nx += direction[1];
            }
        }


        public void move(Character m) {
            direction = directions.get(m);
            shape = shapes.get(m);

            map[y][x] = shape;

            int ny = y + direction[0];
            int nx = x + direction[1];

            if (isIn(ny, nx) && map[ny][nx] == '.') {
                map[ny][nx] = shape;
                map[y][x] = '.';
                y = ny;
                x = nx;
            }
        }


        public boolean isIn(int y, int x) {

            if (0 <= x && x < X && 0 <= y && y < Y) return true;

            return false;
        }


        @Override
        public String toString() {
            return "Tank [y=" + y + ", x=" + x + ", direction=" + Arrays.toString(direction) + "]";
        }
    }


}
