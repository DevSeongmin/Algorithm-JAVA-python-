package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class Practice {
//
//    static int[] inOrder;
//    static int[] postOrder;
//
//    static int N;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        N = Integer.parseInt(br.readLine());
//
//        inOrder = new int[N];
//        postOrder = new int[N];
//
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < N; i++) {
//            inOrder[i] = Integer.parseInt(st1.nextToken());
//            postOrder[i] = Integer.parseInt(st2.nextToken());
//        }
//
//        recursion(N-1, 0, N);
//
//    }
//
//    public static void recursion(int root, int s, int e) {
//
//        for (int i = s; i < e; i++) {
//            if (postOrder[root] == inOrder[i]) {
//
//                System.out.print(postOrder[root] + " ");
//
//                // left
//                recursion(i -1, s, i);
//
//                //right
//                recursion(root -1, e - i, e);
//
//
//            }
//        }
//    }
//
//
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {

    static int[] inOrder;
    static int[] postOrder;

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        inOrder = new int[N];
        postOrder = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st1.nextToken());
            postOrder[i] = Integer.parseInt(st2.nextToken());
        }

        recursion(N - 1, 0, N - 1);
    }

    public static void recursion(int postIdx, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return;
        }

        int rootValue = postOrder[postIdx];
        System.out.print(rootValue + " ");

        int inIdx = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue) {
                inIdx = i;
                break;
            }
        }

        // 왼쪽 서브트리와 오른쪽 서브트리에 대한 재귀 호출
        recursion(postIdx - (inEnd - inIdx + 1), inStart, inIdx - 1);  // 왼쪽 서브트리
        recursion(postIdx - 1, inIdx + 1, inEnd);  // 오른쪽 서브트리
    }
}