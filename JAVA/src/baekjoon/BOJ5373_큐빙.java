package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5373_큐빙 {

    static String[][][] cube = new String[6][3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] color = "wyrogb".split("");


        int T = Integer.parseInt(br.readLine());


        for (int tc = 0; tc < T; tc++) {

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        cube[i][j][k] = color[i];
                    }
                }
            }


            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                String action = input[i];

                if (action.equals("U+")) {
                    U();
                } else if (action.equals("U-")) {
                    U();
                    U();
                    U();
                } else if (action.equals("D+")) {
                    D();
                } else if (action.equals("D-")) {
                    D();
                    D();
                    D();
                } else if (action.equals("F+")) {
                    F();
                } else if (action.equals("F-")) {
                    F();
                    F();
                    F();
                } else if (action.equals("L+")) {
                    L();
                } else if (action.equals("L-")) {
                    L();
                    L();
                    L();
                } else if (action.equals("R+")) {
                    R();
                } else if (action.equals("R-")) {
                    R();
                    R();
                    R();
                } else if (action.equals("B+")) {
                    B();
                } else if (action.equals("B-")) {
                    B();
                    B();
                    B();
                } else {
                    System.out.println("시발 " + action);
                }
            }


            for (int idx = 0; idx < 6; idx++) {
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        sb.append(cube[idx][y][x]);
                    }
                    sb.append("\n");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    static void U() {
        String[][] tmp = copy(0);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[0][j][2-i] = tmp[i][j];
            }
        }


        String[] tmp2 = {cube[2][0][0], cube[2][0][1], cube[2][0][2]};

        for (int i = 0; i < 3; i++) {
            cube[2][0][i] = cube[5][0][i];
        }
        for (int i = 0; i < 3; i++) {
            cube[5][0][2 - i] = cube[3][0][i];
        }
        for (int i = 0; i < 3; i++) {
            cube[3][0][i] = cube[4][0][i];
        }
        for (int i = 0; i < 3; i++) {
            cube[4][0][2 - i] = tmp2[i];
        }
    }

    static void L() {

        String[][] tmp = copy(4);

        // 3번 돌림
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[4][2 - j][i] = tmp[i][j];
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = cube[4][i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[4][2 - j][i] = tmp[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = cube[4][i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[4][2 - j][i] = tmp[i][j];
            }
        }


        String[] tmp2 = {cube[2][0][0], cube[2][1][0], cube[2][2][0]};

        for (int i = 0; i < 3; i++) {
            cube[2][i][0] = cube[0][i][0];
        }


        for (int i = 0; i < 3; i++) {
            cube[0][2 - i][0] = cube[3][i][0];
        }


        for (int i = 0; i < 3; i++) {
            cube[3][i][0] = cube[1][i][0];
        }

        for (int i = 0; i < 3; i++) {
            cube[1][2 - i][0] = tmp2[i];
        }
    }

    static void F() {

        String[][] tmp = copy(2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[2][2 - j][i] = tmp[i][j];
            }
        }


        String[] tmp2 = {cube[0][2][0], cube[0][2][1], cube[0][2][2]};

        for (int i = 0; i < 3; i++) {
            cube[0][2][i] = cube[4][i][0];
        }

        for (int i = 0; i < 3; i++) {
            cube[4][i][0] = cube[1][2][i];
        }

        for (int i = 0; i < 3; i++) {
            cube[1][2][2 - i] = cube[5][i][0];
        }

        for (int i = 0; i < 3; i++) {
            cube[5][i][0] = tmp2[i];
        }


    }

    static void R() {

        String[][] tmp = copy(5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[5][2 - j][i] = tmp[i][j];
            }
        }


        String[] tmp2 = {cube[2][0][2], cube[2][1][2], cube[2][2][2]};

        for (int i = 0; i < 3; i++) {
            cube[2][2 - i][2] = cube[1][i][2];
        }

        for (int i = 0; i < 3; i++) {
            cube[1][i][2] = cube[3][i][2];
        }

        for (int i = 0; i < 3; i++) {
            cube[3][2 - i][2] = cube[0][i][2];
        }

        for (int i = 0; i < 3; i++) {
            cube[0][i][2] = tmp2[i];
        }


    }

    static void B() {
        String[][] tmp = copy(3);

        // 3번 돌림
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[3][2 - j][i] = tmp[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = cube[3][i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[3][2 - j][i] = tmp[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = cube[3][i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[3][2 - j][i] = tmp[i][j];
            }
        }


        String[] tmp2 = {cube[0][0][0], cube[0][0][1], cube[0][0][2]};

        for (int i = 0; i < 3; i++) {
            cube[0][0][i] = cube[5][i][2];
        }

        for (int i = 0; i < 3; i++) {
            cube[5][2 - i][2] = cube[1][0][i];
        }

        for (int i = 0; i < 3; i++) {
            cube[1][0][i] = cube[4][i][2];
        }

        for (int i = 0; i < 3; i++) {
            cube[4][2 - i][2] = tmp2[i];
        }


    }

    static void D() {
        String[][] tmp = copy(1);

        // 3번 돌림
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[1][2 - j][i] = tmp[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = cube[1][i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[1][2 - j][i] = tmp[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = cube[1][i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[1][2 - j][i] = tmp[i][j];
            }
        }

        String[] tmp2 = {cube[2][2][0], cube[2][2][1], cube[2][2][2]};

        for (int i = 0; i < 3; i++) {
            cube[2][2][2 - i] = cube[4][2][i];
        }

        for (int i = 0; i < 3; i++) {
            cube[4][2][i] = cube[3][2][i];
        }

        for (int i = 0; i < 3; i++) {
            cube[3][2][2 - i] = cube[5][2][i];
        }

        for (int i = 0; i < 3; i++) {
            cube[5][2][i] = tmp2[i];
        }


    }


    static String[][] copy(int idx) {
        String[][] res = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = cube[idx][i][j];
            }
        }

        return res;

    }

}
