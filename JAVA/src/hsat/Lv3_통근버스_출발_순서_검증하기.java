package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_통근버스_출발_순서_검증하기 {
	public class Main {
		static int n;
		static int[] nums;
		static int bigger;
		static long ans;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			nums = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n; i++){
				nums[i] = Integer.parseInt(st.nextToken());
			}

			for(int i = 0 ; i < n; i++) {
				bigger = 0;
				for (int k = i + 1; k < n; k++) {
					if (nums[i] < nums[k]) bigger += 1;
					else ans += bigger;
				}
			}

			System.out.println(ans);
		}
	}
}
