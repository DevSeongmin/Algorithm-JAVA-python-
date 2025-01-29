package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_수퍼바이러스 {
	public class Main {

		static long MOD = 1000000007L;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());

			long K = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());
			long N = Long.parseLong(st.nextToken()) * 10;

			System.out.println(pow(P, N) * K % MOD);
		}

		static long pow(long num, long multi){
			if (multi == 0) return 1;
			if (multi == 1) return num;

			long tmp = pow(num, multi / 2);

			if (multi % 2 == 0) {
				return tmp * tmp % MOD;
			}

			return (tmp * tmp % MOD) * num % MOD;
		}
	}
}
