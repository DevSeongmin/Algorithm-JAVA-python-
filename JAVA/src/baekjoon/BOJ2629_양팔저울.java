    package baekjoon;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.Iterator;
    import java.util.StringTokenizer;
    import java.util.TreeSet;

    public class BOJ2629_양팔저울 {
        public static void main(String[] args) throws IOException {

            TreeSet<Integer> treeSet = new TreeSet<>();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int weight_cnt = Integer.parseInt(br.readLine());

            int[] arr = new int[weight_cnt];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < weight_cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            treeSet.add(0);

            for (int i : arr){

                TreeSet<Integer> newSet = new TreeSet<>(treeSet);

                for (int value : treeSet){
                    newSet.add(Math.abs(i + value));
                    newSet.add(Math.abs(value - i));

                }

                treeSet = new TreeSet<>(newSet);
            }


            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++){
                if (treeSet.contains(Integer.parseInt(st.nextToken()))) {
                    System.out.print("Y ");
                } else{
                    System.out.print("N ");
                }

            }

        }
    }
