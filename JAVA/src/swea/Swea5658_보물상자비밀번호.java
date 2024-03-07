package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Swea5658_보물상자비밀번호 {
    static char[] password;

    static HashMap<Character, Integer> numberMap = new HashMap<>();


    public static void main(String[] args) throws IOException {
        numberMap.put('0', 0);
        numberMap.put('1', 1);
        numberMap.put('2', 2);
        numberMap.put('3', 3);
        numberMap.put('4', 4);
        numberMap.put('5', 5);
        numberMap.put('6', 6);
        numberMap.put('7', 7);
        numberMap.put('8', 8);
        numberMap.put('9', 9);
        numberMap.put('A', 10);
        numberMap.put('B', 11);
        numberMap.put('C', 12);
        numberMap.put('D', 13);
        numberMap.put('E', 14);
        numberMap.put('F', 15);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= T; tc++) {


            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int passLen = N / 4;

            password = br.readLine().toCharArray();
            HashSet<String> set = new HashSet<>();

            String temp = "";
            for (int i = 0; i < N; i++) {

                temp += password[i];

                if ((i - passLen + 1) % (passLen) == 0) {
                    set.add(temp);
                    temp = "";
                }
            }


            for (int r = 0; r < passLen - 1; r++) {
                spin();
                temp = "";
                for (int i = 0; i < N; i++) {

                    temp += password[i];

                    if ((i - passLen + 1) % (passLen) == 0) {
                        set.add(temp);
                        temp = "";
                    }
                }
            }

            ArrayList<String> arr = new ArrayList<>(set);
            Collections.sort(arr, Collections.reverseOrder());

            String result = arr.get(K - 1);

            int answer = 0;
            int cnt = 0;
            for (int i = passLen - 1; i >= 0; i--) {
                answer += ((int) Math.pow(16, cnt) * numberMap.get(result.charAt(i)));
                cnt++;
            }

            sb.append("#" + tc + " " + answer + "\n");

        }

        System.out.println(sb);

    }

    static void spin() {
        char tmp = password[password.length - 1];

        for (int i = password.length - 1; i > 0; i--) {
            password[i] = password[i - 1];
        }
        password[0] = tmp;
    }

}
