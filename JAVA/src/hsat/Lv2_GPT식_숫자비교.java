package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Lv2_GPT식_숫자비교 {
	public class Main {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine());

			GPTNumber[] arr = new GPTNumber[N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();

				arr[i] = new GPTNumber(input);
			}

			Arrays.sort(arr, new Comparator<GPTNumber>() {
				@Override
				public int compare(GPTNumber a, GPTNumber b) {
					return a.a != b.a ? Integer.compare(a.a, b.a) : Integer.compare(a.b, b.b);
				}
			});

			for (GPTNumber gptNum : arr) {
				System.out.println(gptNum.originVal);
			}
		}

		static class GPTNumber{
			int a,b;
			String originVal;

			public GPTNumber(String originVal){
				this.originVal = originVal;

				originVal = originVal.replace(".", " ");

				String[] tmp = originVal.split(" ");

				a = Integer.parseInt(tmp[0]);
				b = tmp.length == 1 ? -1 : Integer.parseInt(tmp[1]);
			}
		}
	}
}
