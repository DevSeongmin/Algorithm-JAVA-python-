package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1700_멀티탭스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int multitab = Integer.parseInt(st.nextToken());
        Integer[] multitabs = new Integer[multitab];
        Arrays.fill(multitabs, 0);


        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Map<Integer, Integer> counting = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp  = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            counting.put(tmp, counting.getOrDefault(tmp, 0) + 1);
        }

        int answer = 0;

        point:
        for (int i = 0 ; i < n; i++){
            int tmp = arr[i];
            counting.put(tmp, counting.get(tmp) - 1);


            for (int j = 0; j < multitab; j++){
                if (multitabs[j] == tmp) continue point;
            }

            for (int j = 0; j < multitab; j++){
                if (multitabs[j] == 0) {
                    multitabs[j] = tmp;
                    continue point;
                }
            }

            HashSet<Integer> set = new HashSet<>(Arrays.asList(multitabs));
            int idx = i+1;

            while(set.size() != 1 && idx < n){
                set.remove(arr[idx++]);
            }


            int a = set.iterator().next();

            answer++;
            for (int j = 0; j < multitab; j++){
                if (multitabs[j] == a){
                    multitabs[j] = tmp;
                    break;
                }
            }
        }


        System.out.println(answer);

    }
}
