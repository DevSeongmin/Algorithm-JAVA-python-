package swea;


import java.util.Scanner;

public class Swea7465_창용_마을_무리의_개수 {

    static int[] parents;

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = find(parents[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parents[b] = a;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int T = input.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            int N = input.nextInt();
            int M = input.nextInt();

            parents = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < M; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                union(a, b);
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (find(i) == i) {
                    answer += 1;
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
