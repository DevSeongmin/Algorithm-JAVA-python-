package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3745_오름세 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String nStr = "";
        while((nStr = br.readLine()) != null) {
            nStr = nStr.trim();

            if (nStr == "" || nStr.length() == 0) {
                break;
            }

            int N = Integer.parseInt(nStr);

            int[] arr = new int[N];
            int[] lis = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            lis[0] = arr[0];
            int len = 1;

            for (int i = 1; i < N; i++) {

                if (lis[len - 1] < arr[i]) {
                    lis[len++] = arr[i];
                } else {
                    int left = 0;
                    int right = len;

                    while (left < right) {
                        int mid = (left + right) / 2;

                        if (lis[mid] < arr[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    lis[right] = arr[i];
                }
            }

            sb.append(len + "\n");
        }
        System.out.println(sb);

    }
}