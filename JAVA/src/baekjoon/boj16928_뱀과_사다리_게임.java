package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16928_뱀과_사다리_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());



        int N = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dict.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }


        int[] mimroll = new int[101];
        Arrays.fill(mimroll, Integer.MAX_VALUE);


        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {1, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            int position = dict.getOrDefault(tmp[0], tmp[0]);
            int roll = tmp[1];

            if(position == 100){
                System.out.println(roll);
                return;
            }

            if (roll < mimroll[position]){
                mimroll[position] = roll;

                for (int i = 1; i <= 6; i++) {
                    q.add(new int[]{position + i, roll + 1});

                }
            }
        }
    }

}
