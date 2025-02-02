package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv2_전광판 {

	public class Main {

		static Bulb[] bulbs = new Bulb[10];
		static {
			bulbs[0] = new Bulb(6, new boolean[] {true, true, true, false, true, true, true});
			bulbs[1] = new Bulb(2, new boolean[] {false, false, true, false, false, true, false});
			bulbs[2] = new Bulb(5, new boolean[] {true, false, true, true, true, false, true});
			bulbs[3] = new Bulb(5, new boolean[] {true, false, true, true, false, true, true});
			bulbs[4] = new Bulb(4, new boolean[] {false, true, true, true, false, true, false});
			bulbs[5] = new Bulb(5, new boolean[] {true, true, false, true, false, true, true});
			bulbs[6] = new Bulb(6, new boolean[] {true, true, false, true, true, true, true});
			bulbs[7] = new Bulb(4, new boolean[] {true, true, true, false, false, true, false});
			bulbs[8] = new Bulb(7, new boolean[] {true, true, true, true, true, true, true});
			bulbs[9] = new Bulb(6, new boolean[] {true, true, true, true, false, true, true});
		}

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st  = new StringTokenizer(br.readLine());

				String first = st.nextToken();
				String second = st.nextToken();

				while (first.length() != second.length()){
					if (first.length() < second.length()){
						first = "." + first;
					} else {
						second = "." + second;
					}
				}

				int answer = 0;
				for (int j = 0; j < first.length(); j++) {
					int fc = first.charAt(j) - '0';
					int sc = second.charAt(j) - '0';

					if (fc == -2) {
						answer += bulbs[sc].value;
						continue;
					}

					if (sc == -2) {
						answer += bulbs[fc].value;
						continue;
					}

					answer += getDiff(fc, sc);
				}
				System.out.println(answer);
			}
		}

		static int getDiff(int a, int b) {
			int value = 0;

			for (int i = 0; i < 7; i++) {
				if(bulbs[a].state[i] != bulbs[b].state[i]){
					value++;
				}
			}

			return value;
		}

		static class Bulb{
			int value = 0;
			boolean[] state = new boolean[7];

			public Bulb(int value, boolean[] state) {
				this.value = value;
				this.state = state;
			}
		}
	}
}
