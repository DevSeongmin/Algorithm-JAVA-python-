import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2568_전깃줄2 {

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] countingArr = new int[500_001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map.put(val, idx);
            countingArr[idx] = val;
        }

        int cnt = 0;
        int[] arr = new int[N];
        int[] lis = new int[N];


        for (int i = 0; i < 500_001; i++) {
            if (countingArr[i] == 0)
                continue;
            arr[cnt++] = countingArr[i];
        }



        List<Record> records = new ArrayList<>();
        records.add(new Record(0, arr[0]));
        lis[0] = arr[0];


        int length = 1;

        for (int i = 1; i < N; i++) {

            int key = arr[i];

            if (key > lis[length - 1]) {
                records.add(new Record(length, key));
                lis[length++] = key;
            } else {

                int left = 0;
                int right = length;
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (key > lis[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                records.add(new Record(left, key));
                lis[left] = key;
            }
        }


        int target = length - 1;

        for (int i = records.size() - 1; i >= 0; i--) {
            if (records.get(i).idx == target) {
                target--;
                records.remove(i);
            }
        }

        sb.append(records.size() + "\n");

        for (Record r : records) {
            sb.append(map.get(r.value) + "\n");
        }

        System.out.println(sb);


    }

    static class Record {
        int idx, value;

        public Record(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Record [idx=" + idx + ", value=" + value + "]";
        }

    }

}