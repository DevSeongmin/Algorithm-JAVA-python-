package hsat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_바이러스 {
	public class Main {
		static int MOD = 1000000007;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			StringTokenizer st = new StringTokenizer(br.readLine());

			long K = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());
			long N = Long.parseLong(st.nextToken());

			System.out.println(power(P,N) * K % MOD );
		}

		static long power(long n, long pow){

			if (pow == 1) {
				return n;
			}

			if (pow == 0) {
				return 1;
			}


			if (pow % 2 == 1) {
				return power(n * n % MOD, pow/2) * n % MOD;
			}


			return power(n * n % MOD, pow/2) % MOD;
		}
	}
}
