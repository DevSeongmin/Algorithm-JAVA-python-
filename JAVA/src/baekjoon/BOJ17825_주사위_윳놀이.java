package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17825_주사위_윳놀이 {

    static int solve = 0;

    // 말 4마리
    static int[] horses = new int[4];

    static int[] dices;

    static int[] map = {
      //지름길 없이 쭉   0 ~ 20       21 ~ 25 도착 인덱스
      0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, 0, 0, 0, 0,

      // 10 지름길 26 ~ 33     34~38   도착 인덱스
      10, 13,16,19,25,30,35,40,0, 0, 0, 0, 0,

      // 20 지름길 39 ~ 45    46 ~ 50
      20, 22, 24, 25, 30, 35, 40, 0, 0, 0, 0, 0,

      // 30 지름길 51 ~ 58      59 ~ 63
      30, 28, 27, 26, 25, 30, 35,40, 0 ,0 ,0 ,0 ,0
    };

    static List<Integer> twentyFive = new ArrayList<>();
    static List<Integer> thirty = new ArrayList<>();
    static List<Integer> thirtyFive = new ArrayList<>();
    static List<Integer> fourty = new ArrayList<>();


    // 지름길 발판을 밟은 경우를 대비해
    static HashMap<Integer, Integer> shortcut = new HashMap<>();

    static boolean[] visited = new boolean[64];

    public static void main(String[] args) throws IOException {

        // 25에 겹치는 부분들
        twentyFive.add(30);
        twentyFive.add(42);
        twentyFive.add(55);

        // 30에 겹치는 부분들
        thirty.add(31);
        thirty.add(43);
        thirty.add(56);

        //35에 겹치는 부분들
        thirtyFive.add(32);
        thirtyFive.add(44);
        thirtyFive.add(57);

        //40에 겹치는 부분들
        fourty.add(20);
        fourty.add(33);
        fourty.add(45);
        fourty.add(58);

        // 지름길 맵
        shortcut.put(5, 26);
        shortcut.put(10, 39);
        shortcut.put(15, 51);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        dices = new int[10];

        for (int i = 0; i < 10; i++){
            dices[i] = Integer.parseInt(input.nextToken());
        }

        // 초기 인덱스 0
        Arrays.fill(horses, 0);

        play(0, 0);

        System.out.println(solve);

    }




    static void play(int depth, int answer){

        solve = Math.max(solve, answer);

        if (depth == 10) return;


        for (int i = 0; i < 4; i++){
            // 이미 도착한 말이라면 건너뛴다.
            if (horses[i] == -1) continue;


            // 말의 원래 인덱스
            int originHorseIdx = horses[i];
            // 다음 인덱스
            int nextPosition = shortcut.getOrDefault(horses[i] + dices[depth], horses[i] + dices[depth]);

            // 이미 다음 인덱스에 말이 있다면 건너뛴다. 
            if (visited[nextPosition]) continue;

            // 말이 골인한 경우
            if (map[nextPosition] == 0) {
                visited[originHorseIdx] = false;
                horses[i] = -1;
                play(depth + 1, answer);
                visited[originHorseIdx] = true;
                horses[i] = originHorseIdx;
            }

            // 다음 좌표로 이동하는 경우     골인 못한 경우
            else {
                // 다음 좌표가 25 즉 인덱스를 공유하는 칸이라면
                if (twentyFive.contains(nextPosition)){
                    horses[i] = nextPosition;
                    for (int f : twentyFive) visited[f] = true; // 해당 칸의 공유하는 모든 인덱스 true로
                    visited[originHorseIdx] = false;

                    play(depth+1, answer + map[nextPosition]);

                    horses[i] = originHorseIdx;
                    for (int f : twentyFive) visited[f] = false;
                    visited[originHorseIdx] = true;

                } else if (thirty.contains(nextPosition)){
                    horses[i] = nextPosition;
                    for (int f : thirty) visited[f] = true;
                    visited[originHorseIdx] = false;

                    play(depth+1, answer + map[nextPosition]);

                    horses[i] = originHorseIdx;
                    for (int f : thirty) visited[f] = false;
                    visited[originHorseIdx] = true;

                } else if (thirtyFive.contains(nextPosition)){
                    horses[i] = nextPosition;
                    for (int f : thirtyFive) visited[f] = true;
                    visited[originHorseIdx] = false;

                    play(depth+1, answer + map[nextPosition]);

                    horses[i] = originHorseIdx;
                    for (int f : thirtyFive) visited[f] = false;
                    visited[originHorseIdx] = true;

                } else if (fourty.contains(nextPosition)){
                    horses[i] = nextPosition;
                    for (int f : fourty) visited[f] = true;
                    visited[originHorseIdx] = false;

                    play(depth+1, answer + map[nextPosition]);

                    horses[i] = originHorseIdx;
                    for (int f : fourty) visited[f] = false;
                    visited[originHorseIdx] = true;

                } else {

                    // 25 30 35 40 이 아닌 일반 칸이라면
                    horses[i] = nextPosition;
                    visited[nextPosition] = true;
                    visited[originHorseIdx] = false;

                    play(depth + 1, answer + map[horses[i]]);

                    horses[i] = originHorseIdx;
                    visited[nextPosition] = false;
                    visited[originHorseIdx] = true;
                }
            }
        }
    }
}

