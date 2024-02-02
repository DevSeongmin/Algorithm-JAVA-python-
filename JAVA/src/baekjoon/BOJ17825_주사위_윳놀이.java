package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17825_주사위_윳놀이 {


    static boolean[] alreadyLocated = new boolean[41];
    static Horse[] horses;
    static int[] dices;
    static int solve = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        horses = new Horse[4];

        //Horse 형 배열에 말 객체 4개 추가
        for (int i = 0; i < 4; i++) {
            horses[i] = new Horse();
        }


        dices = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 10개의 턴 10개 입력 받음
        for (int i = 0; i < 10; i++) {
            dices[i] = Integer.parseInt(st.nextToken());
        }



        play(0,0);
        System.out.println(solve);
    }

    // 주사위를 10변 굴리는 재귀함수 모든 경우 탐색
    static void play(int depth, int answer) {
        solve = Math.max(answer, solve);

        if (depth == 10){
            return;
        }


        // 배열의 i번째 말을 움직이는 경우
        for (int i = 0; i < 4; i++) {


            // 현재 이동 길의 좌표룰 넘지 않은 경우
            if (horses[i].idx + dices[depth] < horses[i].move.length - 1) {

                horses[i].idx += dices[depth];

                // 다음 좌표로 갈 수 있다면
                if (!alreadyLocated[horses[i].getPosition()]) {
                    alreadyLocated[horses[i].getPosition()] = true;
                    play(depth + 1, answer + horses[i].position);
                    alreadyLocated[horses[i].getPosition()] = false;
                }

                horses[i].idx -= dices[depth];




                // 현재 이동 길의 좌표를 넘은 경우
            } else if (horses[i].idx + dices[depth] > horses[i].move.length - 1) {

                int originIdx = horses[i].idx;
                int[] originLoad = horses[i].move;


                if (horses[i].MoveLastValue() == 10) {



                    horses[i].move = Horse._10To20;
                    horses[i].idx = horses[i].idx + dices[depth] - horses[i].move.length;

                    if (!alreadyLocated[horses[i].getPosition()]) {
                        alreadyLocated[horses[i].getPosition()] = true;
                        play(depth + 1, answer + horses[i].getPosition());
                        alreadyLocated[horses[i].getPosition()] = false;
                    }


                    horses[i].idx = originIdx;
                    horses[i].move = originLoad;


                } else if (horses[i].MoveLastValue() == 20) {
                    horses[i].move = Horse._20To30;
                    horses[i].idx = horses[i].idx + dices[depth] - horses[i].move.length;

                    if (!alreadyLocated[horses[i].getPosition()]) {

                        alreadyLocated[horses[i].getPosition()] = true;
                        play(depth + 1, answer + horses[i].getPosition());
                        alreadyLocated[horses[i].getPosition()] = false;

                    }
                    horses[i].idx = originIdx;
                    horses[i].move = originLoad;


                } else if (horses[i].MoveLastValue() == 30) {
                    horses[i].move = Horse._30To40;
                    horses[i].idx = horses[i].idx + dices[depth] - horses[i].move.length;

                    if (!alreadyLocated[horses[i].getPosition()]) {

                        alreadyLocated[horses[i].getPosition()] = true;
                        play(depth + 1, answer + horses[i].getPosition());
                        alreadyLocated[horses[i].getPosition()] = false;

                    }
                    horses[i].idx = originIdx;
                    horses[i].move = originLoad;


                } else if (horses[i].MoveLastValue() == 25) {
                    horses[i].move = Horse._25To40;
                    horses[i].idx = horses[i].idx + dices[depth] - horses[i].move.length;
                    if (!alreadyLocated[horses[i].getPosition()]) {

                        alreadyLocated[horses[i].getPosition()] = true;
                        play(depth + 1, answer + horses[i].getPosition());
                        alreadyLocated[horses[i].getPosition()] = false;

                    }
                    horses[i].idx = originIdx;
                    horses[i].move = originLoad;


                }


                // 지름길 좌표에 온경우
            } else if (horses[i].idx == horses[i].move.length - 1) {

                int originIdx = horses[i].idx;
                int[] originLoad = horses[i].move;

                if (horses[i].MoveLastValue() == 10) {

                    answer += horses[i].getPosition();
                    horses[i].idx = 0;
                    horses[i].move = Horse._10To25;

                    if (!alreadyLocated[horses[i].getPosition()]) {
                        alreadyLocated[horses[i].getPosition()] = true;
                        play(depth + 1, answer + horses[i].getPosition());
                        alreadyLocated[horses[i].getPosition()] = false;

                    }


                    answer -= horses[i].getPosition();
                    horses[i].idx = originIdx;
                    horses[i].move = originLoad;



                } else if (horses[i].MoveLastValue() == 20) {

                    answer += horses[i].getPosition();
                    horses[i].idx = 0;
                    horses[i].move = Horse._20To25;

                    if (!alreadyLocated[horses[i].getPosition()]) {

                        alreadyLocated[horses[i].getPosition()] = true;
                        play(depth + 1, answer + horses[i].getPosition());
                        alreadyLocated[horses[i].getPosition()] = false;

                    }

                    answer -= horses[i].getPosition();
                    horses[i].idx = originIdx;
                    horses[i].move = originLoad;




                } else if (horses[i].MoveLastValue() == 30) {

                    answer += horses[i].getPosition();
                    horses[i].idx = 0;
                    horses[i].move = Horse._30To25;

                    if (!alreadyLocated[horses[i].getPosition()]) {

                        alreadyLocated[horses[i].getPosition()] = true;
                        play(depth + 1, answer + horses[i].getPosition());
                        alreadyLocated[horses[i].getPosition()] = false;

                    }

                    answer -= horses[i].getPosition();
                    horses[i].idx = originIdx;
                    horses[i].move = originLoad;

                }
            }
        }
    }
}

class Horse {

    static int[] _0To10 = {0, 2, 4, 6, 8, 10};
    static int[] _10To25 = {13, 16, 19, 25};
    static int[] _10To20 = {12, 14, 15, 18, 20};
    static int[] _20To25 = {22, 24, 25};
    static int[] _20To30 = {22, 24, 26, 28, 30};
    static int[] _30To25 = {28, 27, 26, 25};
    static int[] _30To40 = {32, 34, 36, 38, 40};
    static int[] _25To40 = {30, 35, 40};


    int idx;
    int position;
    int[] move = _0To10;

    public int getPosition() {
        return this.move[idx];
    }

    public int MoveLastValue() {
        return move[this.move.length - 1];
    }
}