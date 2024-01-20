package baekjoon;

/*
작성자 : 황성민
작성일자 : 24.01.20
문제 접근 및 풀이 : https://blog.naver.com/steadydeveloper/223328467811
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040_사이클_게임 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int NODE = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 유니온-파인드 집합 리스트 생성
        // idx와 리스트의 value값이 같도록
        parents = new int[NODE];
        for (int i = 0; i < NODE; i++) {
            parents[i] = i;
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 대표 노드가 같다면 사이클이 생성된 것
            if (find(a) == find(b)){
                System.out.println(i+1);
                flag = true;
                break;
            } else{
                // 다른 집합이므로 유니온 연산 
                union(a,b);
            }
        }
        if (!flag){
            System.out.println(0);
        }


    }

    // find 메서드
    public static int find(int n){
        if (parents[n] == n){
            return n;
        }
        parents[n] = find(parents[n]);
        return parents[n];
    }

    
    // 유니온 메서드
    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        parents[a] = b;
    }
}
