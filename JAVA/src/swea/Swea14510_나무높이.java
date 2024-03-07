package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea14510_나무높이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int maxVal = Arrays.stream(arr).max().getAsInt();

            for (int i = 0; i < N; i++) {
                arr[i] = maxVal - arr[i];
            }
            int twoCnt = 0;
            int oneCnt = 0;
            for (int i = 0; i < N; i++) {
                twoCnt += (arr[i] / 2);
                oneCnt += arr[i] % 2;
            }

            while (oneCnt + 1 < twoCnt) {
                oneCnt+= 2;
                twoCnt--;
            }

            int days = 0;

            int minVal = Math.min(oneCnt, twoCnt);
            days += minVal * 2;

            oneCnt -= minVal;
            twoCnt -= minVal;

            if (oneCnt == 0){
                days += twoCnt * 2;
            }else{
                days += oneCnt * 2 - 1;
            }
            sb.append("#" + tc + " " + days + "\n");
        }

        System.out.println(sb);

    }
}
