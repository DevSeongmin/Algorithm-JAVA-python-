package baekjoon;
//
///**
// * 작성자 : 황성민
// * 작성일자 : 24.01.26
// * 문제 접근 및 풀이 : https://blog.naver.com/steadydeveloper/223333952084
// */
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class BOJ3359_사각사각 {
//
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        int[][] arr = new int[N][2];
//        int[][] dp = new int[N][2];
//
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            arr[i][0] = Integer.parseInt(st.nextToken());
//            arr[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        dp[0][0] = arr[0][1];
//        dp[0][1] = arr[0][0];
//
//        for (int i = 1; i < N; i++) {
//
//            dp[i][0] = Math.max(dp[i][0], Math.abs(arr[i][0] - arr[i-1][0]) + arr[i][1] + dp[i-1][0]);
//            dp[i][0] = Math.max(dp[i][0], Math.abs(arr[i][0] - arr[i-1][1]) + arr[i][1] + dp[i-1][1]);
//
//            dp[i][1] = Math.max(dp[i][1], Math.abs(arr[i][1] - arr[i-1][0]) + arr[i][0] + dp[i-1][0]);
//            dp[i][1] = Math.max(dp[i][1], Math.abs(arr[i][1] - arr[i-1][1]) + arr[i][0] + dp[i-1][1]);
//
//        }
//
//        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
//        System.out.println(Arrays.deepToString(dp));
//
//    }
//
//}
//
//
//



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3359_사각사각 {
    static int N = 0;
    static int[][] points;
    static int ans;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        points = new int[N][2];
        dp = new int[N][2];
        ans = 0;

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(str[0]);
            points[i][1] = Integer.parseInt(str[1]);
        }
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + Math.max(
                    points[i][0] + Math.abs(points[i - 1][1] - points[i][1]),
                    points[i][1] + Math.abs(points[i - 1][1] - points[i][0]));
            System.out.print(Math.max(dp[i][0], dp[i][1]) + "     ");

            dp[i][1] = dp[i - 1][1] + Math.max(
                    points[i][0] + Math.abs(points[i - 1][0] - points[i][1]),
                    points[i][1] + Math.abs(points[i - 1][0] - points[i][0]));
            System.out.println(Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}