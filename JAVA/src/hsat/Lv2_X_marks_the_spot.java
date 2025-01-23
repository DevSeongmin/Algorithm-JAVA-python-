package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv2_X_marks_the_spot {

	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine());

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken().toUpperCase();
				String b = st.nextToken().toUpperCase();

				sb.append(b.charAt(a.indexOf("X")));
			}

			System.out.println(sb.toString());
		}
	}

}
