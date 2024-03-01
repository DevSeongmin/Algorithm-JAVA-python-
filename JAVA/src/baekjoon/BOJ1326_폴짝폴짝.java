//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class BOJ1326_폴짝폴짝 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input;
//
//        int N = Integer.parseInt(br.readLine());
//        input = br.readLine().split(" ");
//        int[] arr = new int[N + 1];
//
//        for (int i = 0; i < N; i++) {
//            arr[i+1] = Integer.parseInt(input[i]);
//        }
//        int[] DP = new int[N+1];
//        Arrays.fill(DP, 10_000);
//
//        input = br.readLine().split(" ");
//
//        int start = Integer.parseInt(input[0]);
//        int end = Integer.parseInt(input[1]);
//
//
//        // 초기에 시작점 기준으로 최단거리들 업데이트
//        DP[start] = 0;
//        for (int i = start - arr[start]; i >= 0; i -= arr[start]) {
//            DP[i] = DP[start] + 1;
//        }
//
//        for (int i = start + arr[start]; i < N + 1; i += arr[start]) {
//            DP[i] = DP[start] + 1;
//        }
//
//
//        for (int i = 1; i < N + 1; i++) {
//
//            for (int j = i - arr[i]; j >= 0; j -= arr[i]) {
//                DP[j] = Math.min(DP[j], DP[i] + 1);
//            }
//
//            for (int j = i + arr[i]; j < N + 1; j += arr[i]) {
//                DP[j] = Math.min(DP[j], DP[i] + 1);
//            }
//
//        }
//
//        if (DP[end] >= 10_000){
//            System.out.println(-1);
//        }else {
//            System.out.println(DP[end]);
//        }
//
//    }
//}


package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1326_폴짝폴짝 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }


        Queue<int[]> q = new LinkedList<>();

        input = br.readLine().split(" ");

        int start = Integer.parseInt(input[0])-1;
        int end = Integer.parseInt(input[1])-1;

        q.add(new int[] {start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int n = tmp[0];
            int time = tmp[1];

            if (n == end) {
                System.out.println(time);
                return;
            }


            for (int i = n - arr[n]; i >= 0; i -= arr[n]) {
                if (!visited[i]) {
                    q.add(new int[]{i, time + 1});
                    visited[i] = true;
                }
            }


            for (int i = n + arr[n]; i < N; i += arr[n]) {
                if (!visited[i]) {
                    q.add(new int[]{i, time + 1});
                    visited[i] = true;
                }
            }




        }

        System.out.println(-1);

    }
}
