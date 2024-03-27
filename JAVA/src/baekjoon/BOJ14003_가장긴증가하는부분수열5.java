package baekjoon;

/**
 * 작성자 : 황성민
 * 작성 일자 : 24.03.27
 * 문제 해결 방법 : 이진탐색을 활용한 lis(N log (N) ) 알고리즘을 활용한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14003_가장긴증가하는부분수열5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // lis배열에 삽입위치와 값을 저장해둘 리스트 선언
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(arr[0], 0));


        lis[0] = arr[0];
        int length = 1;


        // lis 알고리즘
        for (int i = 1; i < N; i++){
            int key = arr[i];

            // 현재 lis배열의 마지막 값보다 키값이 크다면
            if (lis[length - 1] < key) {

                // 삽입위치와 키값 기록
                records.add(new Record(key, length));
                // lis배열에 맨 뒤에 넣기
                lis[length++] = key;

            // 아닐 경우 2진탐색으로 끼워넣을 위치 찾기
            // 로워 바운드 사용
            } else{

                int left = 0;
                int right = length;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (key > lis[mid]){
                        left = mid + 1;
                    } else{
                        right = mid;
                    }
                }

                // 로워 바운드 위치에 끼워넣고 기록
                records.add(new Record(key, left));
                lis[left] = key;
            }
        }

        // 길이 출력
        System.out.println(length);

        System.out.println(records);

        int target = length - 1;

        Stack<Integer> answer = new Stack<>();

        // 뒤에서 부터 탐색하여 target과 같으면 출력 후 target--;
        for (int i = records.size() - 1; i >= 0; i--){
            Record curRecord = records.get(i);
            if (curRecord.idx == target){
                answer.push(curRecord.val);
                target--;
            }
        }

        // 뒤에서 시작했기에 스택에 넣어두고
        // 팝하면 정답 출력
        while (!answer.isEmpty()) {
            System.out.print(answer.pop() + " ");
        }
    }

    static class Record{
        int val, idx;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Record{");
            sb.append("val=").append(val);
            sb.append(", idx=").append(idx);
            sb.append('}');
            return sb.toString();
        }

        public Record(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        
    }
}
