package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ14891_톱니바퀴 {

    static LinkedList<Integer>[] wheels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        wheels = new LinkedList[4];

        for (int i = 0; i < 4; i++) {
            wheels[i] = new LinkedList<>();
            input = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                wheels[i].addLast(Integer.parseInt(input[j]));
            }
        }


        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");

            int select = Integer.parseInt(input[0]) - 1;
            int direct = Integer.parseInt(input[1]);

            spin(select, direct, ' ');
        }

        int answer = 0 ;
        int cnt = 1;
        for (LinkedList w : wheels){
            answer += cnt * (int) w.getFirst();
            cnt *= 2;
        }

        System.out.println(answer);
    }

    static void spin(int idx, int spinDirct, char direct) {


        // 오른쪽 확인
        if (idx + 1 < 4 && wheels[idx].get(2) != wheels[idx + 1].get(6) && direct != 'L') {
            spin(idx + 1, spinDirct == -1 ? 1 : -1, 'R');
        }


        // 왼쪽 확인
        if (idx - 1 >= 0 && wheels[idx].get(6) != wheels[idx - 1].get(2) && direct != 'R') {
            spin(idx - 1, spinDirct == -1 ? 1 : -1, 'L');
        }


        if (spinDirct == 1){
            wheels[idx].addFirst(wheels[idx].pollLast());
        } else {
            wheels[idx].addLast(wheels[idx].pollFirst());
        }

    }

}