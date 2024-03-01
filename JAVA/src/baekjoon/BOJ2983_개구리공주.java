package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 작성자 : 황성민
 * 작성일자 : 24.02.21
 * 문제 해결 방식
 * 				기존의 연결 리스트가 front와  tail이라면
 * 				해당 문제는 4방향에 연결 링크가 있는 연결리스트를 이용하여 접근해야한다.
 *
 *
 */

public class BOJ2983_개구리공주 {

    static Tuple position;

    // 해쉬맵을 이용하여 4방향 연결리스트 구현
    static HashMap<Tuple, HashMap<String, Tuple>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int Flower = Integer.parseInt(st.nextToken());

        String jumps[] = br.readLine().split("");

        int[][] flowers = new int[Flower][2];

        for (int i = 0; i < Flower; i++) {
            st = new StringTokenizer(br.readLine());
            flowers[i][0] = Integer.parseInt(st.nextToken());
            flowers[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 포지션
        position = new Tuple(flowers[0][0], flowers[0][1]);

        // y-x순으로 만약 같다면 x가 낮은 수 순으로 정렬을 한다.
        // 그러면 정렬 순서는 2차원 평면에 대각선을 그엇을때 순으로 정렬된다.
        Arrays.sort(flowers, Comparator.comparingInt((int[] arr) -> arr[1] - arr[0]).thenComparing(arr -> arr[0]));


        for (int i = 0; i < Flower; i++) {
            int x = flowers[i][0];
            int y = flowers[i][1];

            Tuple t = new Tuple(x, y);

            // 해당 튜플 정보가 아직 맵에 없다면 튜플 넣어줌
            if (!map.containsKey(t)) {
                map.put(t, new HashMap<>());
            }



            // 다음 값과 같은 대각선 상이라면 map연결
            if (i != Flower - 1 && (flowers[i][0] - flowers[i][1]) == (flowers[i + 1][0] - flowers[i + 1][1])) {
                map.get(t).put("A", new Tuple(flowers[i + 1][0], flowers[i + 1][1]));
            }

            // 이전 값과 같은 대각선 상이라면 map 연결
            if (i != 0 && (flowers[i][0] - flowers[i][1]) == (flowers[i - 1][0] - flowers[i - 1][1])) {
                map.get(t).put("D", new Tuple(flowers[i - 1][0], flowers[i - 1][1]));
            }
        }

        // y+x순으로 만약 같다면 x가 낮은 수 순으로 정렬을 한다.
        // 그러면 정렬 순서는 2차원 평면에 역대각선을 그엇을때 순으로 정렬된다.
        Arrays.sort(flowers, Comparator.comparingInt((int[] arr) -> arr[0] + arr[1]).thenComparing(arr -> arr[0]));

        for (int i = 0; i < Flower; i++) {

            int x = flowers[i][0];
            int y = flowers[i][1];

            Tuple t = new Tuple(x, y);

            // 해당 튜플 정보가 아직 맵에 없다면 튜플 넣어줌
            if (!map.containsKey(t)) {
                map.put(t, new HashMap<>());
            }

            // 다음 값과 같은 대각선 상이라면 map연결
            if (i != Flower - 1 && flowers[i][0] + flowers[i][1] == flowers[i + 1][0] + flowers[i + 1][1]) {
                map.get(t).put("B", new Tuple(flowers[i + 1][0], flowers[i + 1][1]));
            }

            // 이전 값과 같은 대각선 상이라면 map연결
            if (i != 0 && flowers[i][0] + flowers[i][1] == flowers[i - 1][0] + flowers[i - 1][1]) {
                map.get(t).put("C", new Tuple(flowers[i - 1][0], flowers[i - 1][1]));
            }

        }

        // 점프 메서드 실행
        for (String j : jumps) {
            if (j.equals("A")) {
                jumpA();
            } else if (j.equals("B")) {
                jumpB();
            } else if (j.equals("C")) {
                jumpC();
            } else if (j.equals("D")) {
                jumpD();
            }
        }

        // 현재 포지션 출력
        System.out.println(position);

    }


    // 점프 A 메서드
    static void jumpA() {
        // 다음 위치가 없다면 리턴
        if (map.get(position).get("A") == null)
            return;

        // before를 현재 위치로
        Tuple before = new Tuple(position.x, position.y);

        // 현재 위치를 A방향 다음 위치로
        position = map.get(position).get("A");

        // 다음 위치의 A의 반대 방향을 이전 방향의 A의 반대방향 D와 연결
        map.get(position).put("D", map.get(before).get("D"));


        // A 방향으로 이동 하고 A 방향을 바라봤을때 양옆 B, C연결
        if ((map.get(before).get("C")) != null) {
            map.get(map.get(before).get("C")).put("B", map.get(before).get("B"));
        }
        if (map.get(before).get("B") != null) {
            map.get(map.get(before).get("B")).put("C", map.get(before).get("C"));
        }
    }



    // 이하 jumpA와 같은 논리
    static void jumpB() {
        if (map.get(position).get("B") == null)
            return;

        Tuple before = new Tuple(position.x, position.y);
        position = map.get(position).get("B");

        map.get(position).put("C", map.get(before).get("C"));

        if (map.get(before).get("A") != null) {
            map.get(map.get(before).get("A")).put("D", map.get(before).get("D"));
        }
        if (map.get(before).get("D") != null) {
            map.get(map.get(before).get("D")).put("A", map.get(before).get("A"));
        }
    }

    static void jumpC() {
        if (map.get(position).get("C") == null)
            return;

        Tuple before = new Tuple(position.x, position.y);
        position = map.get(position).get("C");

        map.get(position).put("B", map.get(before).get("B"));

        if (map.get(before).get("A") != null) {
            map.get(map.get(before).get("A")).put("D", map.get(before).get("D"));
        }

        if (map.get(before).get("D") != null) {
            map.get(map.get(before).get("D")).put("A", map.get(before).get("A"));
        }
    }

    static void jumpD() {
        if (map.get(position).get("D") == null)
            return;

        Tuple before = new Tuple(position.x, position.y);
        position = map.get(position).get("D");

        map.get(position).put("A", map.get(before).get("A"));

        if (map.get(before).get("C") != null) {
            map.get(map.get(before).get("C")).put("B", map.get(before).get("B"));
        }

        if (map.get(before).get("B") != null) {
            map.get(map.get(before).get("B")).put("C", map.get(before).get("C"));
        }
    }


    // 좌표를 기준으로 해싱하여 맵에 넣고 접근하기 위해 튜플 클래스 선언
    static class Tuple {
        int x;
        int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }



        // equals 재정의
        // y, x좌표가 같다면 같은 튜플 객체로 본다.
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Tuple other = (Tuple) obj;

            return x == other.x && y == other.y;
        }

        // 출력 재정의
        @Override
        public String toString() {
            return x + " " + y;
        }

    }

}
