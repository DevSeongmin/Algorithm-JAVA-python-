package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2263_트리의_순회 {
    static int[] inOrder, postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        inOrder = new int[N];
        postOrder = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }


        search(0, N, 0, N);
    }

    static void search(int is, int ie, int ps, int pe) {
        if (is >= ie || ps >= pe) return;

        int root = postOrder[pe - 1];
        int idx = -1;

        for (int i = is; i < ie; i++) {
            if (inOrder[i] == root) {
                idx = i;
                break;
            }
        }

        int leftSize = idx - is;

        System.out.print(root + " ");

        // 왼쪽 서브트리
        search(is, idx, ps, ps + leftSize);

        // 오른쪽 서브트리
        search(idx + 1, ie, ps + leftSize, pe - 1);
    }
}
