package swea;

import java.util.HashMap;
import java.util.Scanner;

public class Swea19113_식료품_가게 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            int N = input.nextInt();
            int[] arr = new int[N * 2];

            for (int i = 0; i < N * 2; i++) {
                arr[i] = input.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            System.out.print("#" + tc);
            for (int value : arr) {
                int v = value / 4 * 3;

                if (map.getOrDefault(v, 0) > 0) {
                    System.out.print(" " + v);
                    map.put(v, map.get(v) - 1);

                } else {
                    map.put(value, map.getOrDefault(value,0) + 1);
                }
            }
            System.out.println();

        }
    }
}
