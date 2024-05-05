package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Test2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            TreeSet<Integer> tmpSet = new TreeSet<>(set);

            for (Integer s : set) {
                tmpSet.add(s + num);
                tmpSet.add(Math.abs(num - s));
            }
            set.addAll(tmpSet);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            if (set.contains(Integer.parseInt(st.nextToken()))) {
                System.out.print("Y ");
            } else{
                System.out.print("N ");
            }
        }
    }
}
