package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ20187_종이접기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int hole = Integer.parseInt(br.readLine());

        int size = (int) Math.pow(2, N);
        int[][] answerMap = new int[size][size];

        int[][] map = new int[2][2];
        for (int[] m : map) Arrays.fill(m, -1);


        boolean LR = false;
        boolean UD = false;

        String[] fold = new String[2];

        int cnt = 0;

        int x = 0;
        int y = 0;

        while (!LR || !UD) {
            for (int i = input.length - 1; i >= 0; i--) {
                if (input[i].equals("L") && !LR) {
                    LR = true;
                    fold[cnt++] = "L";
                } else if (input[i].equals("R") && !LR) {
                    LR = true;
                    fold[cnt++] = "R";
                    x = 1;
                } else if (input[i].equals("U") && !UD) {
                    UD = true;
                    fold[cnt++] = "U";
                } else if (input[i].equals("D") && !UD) {
                    UD = true;
                    fold[cnt++] = "D";
                    y = 1;
                }
            }
        }

        map[y][x] = hole;

        System.out.println(Arrays.toString(fold));

        if (input[0].equals("L") && input[1].equals("U") || input[0].equals("U") && input[1].equals("L")) {
            // x = 0 y = 0

            if (map[y][x] == 0) {
                map[y + 1][x] = 2;
                map[y][x + 1] = 1;
                map[y + 1][x + 1] = 3;


            } else if (map[y][x] == 1) {
                map[y + 1][x] = 3;
                map[y][x + 1] = 0;
                map[y + 1][x + 1] = 2;


            } else if (map[y][x] == 2) {
                map[y][x + 1] = 3;
                map[y + 1][x] = 0;
                map[y + 1][x + 1] = 1;
            } else if (map[y][x] == 3) {
                map[y + 1][x] = 1;
                map[y][x + 1] = 2;
                map[y + 1][x + 1] = 0;
            }


        }

        else if (input[0].equals("L") && input[1].equals("D") || input[0].equals("D") && input[1].equals("L")) {
            // x = 0 y = 1
            if (map[y][x] == 0) {
                map[y - 1][x] = 2;
                map[y][x + 1] = 1;
                map[y - 1][x + 1] = 3;


            } else if (map[y][x] == 1) {
                map[y - 1][x] = 3;
                map[y][x + 1] = 0;
                map[y - 1][x + 1] = 2;


            } else if (map[y][x] == 2) {
                map[y - 1][x] = 0;
                map[y][x + 1] = 3;
                map[y - 1][x + 1] = 1;
            } else if (map[y][x] == 3) {
                map[y - 1][x] = 1;
                map[y][x + 1] = 2;
                map[y - 1][x + 1] = 0;
            }
        }


        else if ( (input[0].equals("R") && input[1].equals("D")) || ( input[0].equals("D") && input[1].equals("R"))) {
            // x = 1 y = 1

            if (map[y][x] == 0) {
                map[y - 1][x] = 2;
                map[y][x - 1] = 1;
                map[y - 1][x - 1] = 3;
            } else if (map[y][x] == 1) {
                map[y - 1][x] = 3;
                map[y][x - 1] = 0;
                map[y - 1][x - 1] = 2;
            } else if (map[y][x] == 2) {
                map[y - 1][x] = 0;
                map[y][x - 1] = 3;
                map[y - 1][x - 1] = 1;
            } else if (map[y][x] == 3) {
                map[y - 1][x] = 1;
                map[y][x - 1] = 2;
                map[y - 1][x - 1] = 0;
            }


        } else if (input[0].equals("R") && input[1].equals("U") || input[0].equals("U") && input[1].equals("R")) {
            // x = 1 y = 0

            if (map[y][x] == 0) {
                map[y][x - 1] = 1;
                map[y + 1][x] = 2;
                map[y + 1][x - 1] = 3;


            } else if (map[y][x] == 1) {
                map[y][x - 1] = 0;
                map[y + 1][x] = 3;
                map[y + 1][x - 1] = 2;


            } else if (map[y][x] == 2) {
                map[y][x - 1] = 3;
                map[y + 1][x] = 0;
                map[y + 1][x - 1] = 1;


            } else if (map[y][x] == 3) {
                map[y][x - 1] = 2;
                map[y + 1][x] = 1;
                map[y + 1][x - 1] = 0;
            }
        } else {
            System.out.println("넌 머냐?");
        }


        System.out.println(Arrays.toString(fold));
        for (int[] m : map) System.out.println(Arrays.toString(m));





        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < size; j += 2) {

                answerMap[i][j] = map[0][0];
                answerMap[i][j + 1] = map[0][1];
                answerMap[i + 1][j] = map[1][0];
                answerMap[i + 1][j + 1] = map[1][1];


            }
        }


        StringBuilder sb = new StringBuilder();

        for (int[] a : answerMap) {
            for (int b : a) {
                sb.append(b + " ");
            }
            sb.append('\n');
        }


        System.out.println(sb);


    }
}
