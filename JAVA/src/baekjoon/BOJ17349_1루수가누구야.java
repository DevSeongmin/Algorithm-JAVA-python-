package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ17349_1루수가누구야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<Integer, Integer> correct = new HashMap<>();
        HashMap<Integer, Integer> notCorrect = new HashMap<>();
        
        int[][] info = new int[2][9];

        for (int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());

            int assertion = Integer.parseInt(st.nextToken());
            int player = Integer.parseInt(st.nextToken());

            info[0][i] = assertion;
            info[1][i] = player;

            if (assertion == 1){
                correct.put(player, correct.getOrDefault(player, 0)+1);
            } else{
                notCorrect.put(player, correct.getOrDefault(player, 0)+1);
            }
        }



        for (int i = 0; i < 9; i++){

        }





    }
}
