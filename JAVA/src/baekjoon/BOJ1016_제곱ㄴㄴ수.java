package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ1016_제곱ㄴㄴ수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Long> set = new HashSet<>();

        String[] se = br.readLine().split(" ");

        long start = Long.parseLong(se[0]);
        long end = Long.parseLong(se[1]);


        for (long i = start; i <= end; i++){
            set.add(i);
        }


        for (long i = 2; i <= 1000000; i++) {
            long ii = i * i;

            long j = 1;
            while(true) {

                long remove = ii* j;
                if (remove >1000001000000L) break;
                set.remove(remove);
                j++;
            }
        }

        System.out.println(set);



    }
}
