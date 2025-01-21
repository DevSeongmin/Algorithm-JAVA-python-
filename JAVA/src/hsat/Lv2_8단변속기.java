package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv2_8단변속기 {

	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());

			boolean isAscending = true;
			boolean isDescending = true;


			for (int i = 1; i <= 8; i++) {
				int num = Integer.parseInt(st.nextToken());

				if (num != i) {
					isAscending = false;
				}

				if (num != 9 - i){
					isDescending = false;
				}
			}

			if (isAscending) {
				System.out.println("ascending");
				return;
			}

			if (isDescending){
				System.out.println("descending");
				return;
			}

			System.out.println("mixed");
		}
	}
}
